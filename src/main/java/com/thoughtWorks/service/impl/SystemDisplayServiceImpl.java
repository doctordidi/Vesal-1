package com.thoughtWorks.service.impl;

import com.thoughtWorks.dao.SystemDisplayDao;
import com.thoughtWorks.entity.Level;
import com.thoughtWorks.entity.Model;
import com.thoughtWorks.service.SystemDisplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 马欢欢
 * @date 2017/12/15
 */
@Service
public class SystemDisplayServiceImpl implements SystemDisplayService {

    @Resource
    private SystemDisplayDao systemDisplayDao;

    @Override
    public List<Model> systemInfo(Level level) throws Exception {
        return systemDisplayDao.systemInfo(level);
    }
}