package com.own.backend.admin.Config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;

import java.util.List;

/**
 * @Author fangting
 * @create 2020/12/7 16:49
 * @description
 **/
public class MySqlInjector extends DefaultSqlInjector {
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new LogicDeleteByIdWithFill());
        return methodList;
    }
}
