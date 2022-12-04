package com.springboot.unittesting.unittesting.business;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class DemoBusiness {

    // For stub testing
    private IDemoDataService demoDataService;

    public IDemoDataService getDemoDataService() {
        return demoDataService;
    }

    public void setDemoDataService(IDemoDataService demoDataService) {
        this.demoDataService = demoDataService;
    }

    public Double calculateMean(List<Integer> numList) {
        if (CollectionUtils.isEmpty(numList)) {
            return 0.0;
        }
        Integer sum = 0;
        for (Integer num : numList) {
            sum += num;
        }
        return (double) sum / numList.size();
    }

    public Double calculateMeanFromDataService() {
        List<Integer> numList = demoDataService.retrieveNumberList();
        if (numList == null) {
            return 0.0;
        }
        Integer sum = 0;
        for (Integer num : numList) {
            sum += num;
        }

        double mean = (double) sum / numList.size();

        demoDataService.storeMean(mean);
        return mean;
    }
}
