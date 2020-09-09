package com.df.demo;

import lombok.Data;

/**
 * @author hanyli
 * @date 2020/4/19
 */
@Data
public class Result {
    private String code;
    private String name;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;

    public Result(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
