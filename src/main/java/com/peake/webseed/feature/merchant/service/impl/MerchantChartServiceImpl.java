package com.peake.webseed.feature.merchant.service.impl;

import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.feature.merchant.mapper.MerchantChartMapper;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.feature.merchant.model.MerchantChart;
import com.peake.webseed.feature.merchant.service.MerchantChartService;
import com.peake.webseed.feature.merchant.service.MerchantService;
import com.peake.webseed.utils.DateUtils;
import com.peake.webseed.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/10/11.
 */
@Service
@Transactional
public class MerchantChartServiceImpl extends AbstractService<MerchantChart> implements MerchantChartService {

    Logger logger = LoggerFactory.getLogger(MerchantChartServiceImpl.class);

    @Resource
    private MerchantChartMapper MerchantChartMapper;

    @Resource
    private MerchantService merchantService;

    @Override
    public void genMonthCharts(LocalDate date) {
        LocalDate beforeDate = date.with(TemporalAdjusters.firstDayOfMonth()).plusMonths(1);//下个月1号
        List<Merchant> merchantList = merchantService.findMerchantCreatedBefore(DateUtils.localDate2Date(beforeDate));//获取下个月1号之前创建的所有商家
        for (Merchant merchant: merchantList){
            try {
                if (merchant.getDeviceCount() <= 0){
                    break;
                }
                genMerchantMonthChart(merchant.getPkId(),date);
            }catch (Exception e){
                logger.error(e.getMessage());
                e.printStackTrace();
            }

        }
    }

    /**
     * 生成该商家当月报表
     * @param merchantId
     * @param date
     */
    private void genMerchantMonthChart(long merchantId, LocalDate date){
        LocalDate startDate = date.with(TemporalAdjusters.firstDayOfMonth());//当月1号
        LocalDate endDate = date.with(TemporalAdjusters.firstDayOfMonth()).plusMonths(1);//下个月1号

        MerchantChart oldMerchantChart = MerchantChartMapper.getMerchantChartByTime(merchantId, DateUtils.localDate2Date(startDate), DateUtils.localDate2Date(endDate));
        if (oldMerchantChart != null){
            logger.info("已有月报表存在:" + JSONUtils.beanToJson(oldMerchantChart));
            return;
        }

        MerchantChart merchantChart = MerchantChartMapper.getMerchantMonthAmount(merchantId, DateUtils.localDate2Date(startDate), DateUtils.localDate2Date(endDate));
        if (merchantChart == null){
            merchantChart = new MerchantChart();
            merchantChart.setOrderCount(0);
            merchantChart.setTotalAmount(BigDecimal.ZERO);
            merchantChart.setPayAmount(BigDecimal.ZERO);
        }
        Merchant merchant = merchantService.findById(merchantId);
        merchantChart.setBonusCalType(merchant.getBonusCalType());
        merchantChart.setBonusRatio(merchant.getBonusRatio());
        merchantChart.setCreateTime(now());
        merchantChart.setDataStatus(EnumDataStatus.normal.getValue());
        merchantChart.setEndDate(DateUtils.localDate2Date(endDate));
        merchantChart.setFkMerchantId(merchantId);
        merchantChart.setMonth(String.valueOf(date.getMonthValue()));
        merchantChart.setName(merchant.getName() +date.getYear() + "年" + date.getMonthValue() + "月商家销售报表" );
        merchantChart.setRealBonus(BigDecimal.ZERO);
        merchantChart.setStartDate(DateUtils.localDate2Date(startDate));
        merchantChart.setType(1);
        merchantChart.setUpdateTime(now());
        merchantChart.setYear(String.valueOf(date.getYear()));
        logger.info("开始生成报表：《" + merchant.getName() +date.getYear() + "年" + date.getMonthValue() + "月商家销售报表》");
        save(merchantChart);

    }
}
