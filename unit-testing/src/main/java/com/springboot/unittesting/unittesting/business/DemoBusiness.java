package com.springboot.unittesting.unittesting.business;

import java.util.List;

public class DemoBusiness {

    public Double calculateMean(List<Integer> numList) {
        if (numList == null) {
            return 0.0;
        }
        Integer sum = 0;
        for (Integer num : numList) {
            sum += num;
        }
        return (double) sum / numList.size();
    }



    // For stub testing
    private IDemoDataService demoDataService;

    public IDemoDataService getDemoDataService() {
        return demoDataService;
    }

    public void setDemoDataService(IDemoDataService demoDataService) {
        this.demoDataService = demoDataService;
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
        return (double) sum / numList.size();
    }
}
