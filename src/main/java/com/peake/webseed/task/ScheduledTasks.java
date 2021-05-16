package com.peake.webseed.task;

import com.peake.webseed.feature.merchant.service.MerchantChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author lix
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018-05-0416:59
 */
@Component
public class ScheduledTasks {
    @Autowired
    private MerchantChartService merchantChartService;
//0 0-5 0,6,12,18,23 * * ?
    @Scheduled(cron = "0 0 3 1 1/1 ? ")//每月1号3点
    public void genMerchantMonthChart() {

        merchantChartService.genMonthCharts(LocalDate.now().minusDays(1));//每月1号3点，生成当天前一天的那个月的月报表
    }

}
