package com.springboot.unittesting.unittesting.business;

import java.util.List;

public interface IDemoDataService {
    List<Integer> retrieveNumberList();

    void storeMean(double mean);
}
