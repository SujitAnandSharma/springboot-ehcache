package com.quppler.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Department {

    ACCOUNTING("accounting"), FINANCE("finance"), OFFICER("officer"), LABOUR("labour");

    private String value;
    private static final Map<String, Department> mapOfDepartments;

    static{
        mapOfDepartments = Collections.unmodifiableMap(Arrays.asList(Department.values()).stream().collect(Collectors.toMap(Department::value, Function.identity())));
    }

    Department(String value){
        this.value = value;
    }

    @JsonValue
    public String value(){
        return value;
    }

    public static Department lookupValue(String value){
        return mapOfDepartments.get(value);
    }

}
