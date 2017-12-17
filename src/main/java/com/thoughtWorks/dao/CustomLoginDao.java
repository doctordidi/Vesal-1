package com.thoughtWorks.dao;

import com.thoughtWorks.entity.Custom;
import com.thoughtWorks.entity.Model;
import com.thoughtWorks.entity.Subscribe;

import java.util.List;
import java.util.Map;

/**
 * @author ubuntu
 */
public interface CustomLoginDao{

    /**
     * 客户登录
     * @param custom
     * @return
     */
    Custom login(Custom custom) throws Exception;

    /**
     * 取消订阅
     * @param subscribe
     * @throws Exception
     */
    void deleteSubscribe(Subscribe subscribe)throws Exception;

    /**
     * 添加订阅
     * @param subscribe 添加订阅信息
     * @throws Exception
     */
    void addSubscribe(Subscribe subscribe)throws Exception;

    /**
     *
     * 查找个人订阅信息
     * @param custom 个人信息：ID
     * @return 个人订阅的信息
     * @throws Exception
     */
    List<Map<String,Object>> personalSubscription (Custom custom)throws Exception;
}
