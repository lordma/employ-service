package com.lordma.employ.common.base;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/6/27 20:40
 * @Version 1.0
 */
@Data
public class PageResult<T> {
    private int code;
    private String message;
    private long count;
    private List<T> data;

    public PageResult(){

    }

    public PageResult(long count, List<T> rows){
        this.code = 200;
        this.message = "";
        this.count = count;
        this.data = rows;


    }
}
