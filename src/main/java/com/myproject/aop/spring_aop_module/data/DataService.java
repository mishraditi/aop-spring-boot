package com.myproject.aop.spring_aop_module.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {

public int[] retrieveData() {
    return new int[] {11, 22, 33, 44, 55};
}

}