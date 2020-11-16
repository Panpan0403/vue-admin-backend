package com.own.backend.admin.Service;

/**
 * @Author fangting
 * @create 2020/11/13 14:36
 * @description
 **/
public interface BaseInterface<T>{
    T getByName(String name);
}
