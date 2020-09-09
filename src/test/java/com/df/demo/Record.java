package com.df.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hanyli
 * @date 2020/4/19
 */
@Data
public class Record implements Serializable {
    private static final long serialVersionUID = -6636231784003455969L;
    private String month;
    private String day;
    private String division;
    private String start;
    private String end;
    private Integer num;

    public Record(String month) {
        this.month = month;
    }
}
