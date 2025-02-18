package com.myproject.aop.spring_aop_module.business;

import com.myproject.aop.spring_aop_module.data.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class BusinessService {
public DataService dataService;

    public BusinessService(DataService dataService) {
        this.dataService = dataService;
    }
//    public int calculateMax() {
//        int[] data = dataService.retrieveData();
//        throw new RuntimeException("something went wrong in the code ");
////        return Arrays.stream(data).max().orElse(0);
//    }
public int calculateMax() {
    try {
        int[] data = dataService.retrieveData();
        throw new RuntimeException("something went wrong in the code");
        // return Arrays.stream(data).max().orElse(0);
    } catch (Exception e) {
        System.err.println("Handled exception: " + e.getMessage());
        return 0;  // Provide a fallback value
    }
}}
