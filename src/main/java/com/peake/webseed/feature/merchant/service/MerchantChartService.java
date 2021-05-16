package com.peake.webseed.feature.merchant.service;

import com.peake.webseed.core.Service;
import com.peake.webseed.feature.merchant.model.MerchantChart;

import java.time.LocalDate;


/**
 * Created by CodeGenerator on 2018/10/11.
 */
public interface MerchantChartService extends Service<MerchantChart> {
    /**
     *
     * @param date
     */
    void genMonthCharts(LocalDate date);

}
