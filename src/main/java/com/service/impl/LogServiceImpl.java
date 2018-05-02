package com.service.impl;

import com.mapper.LogMapper;
import com.pojo.LogExample;
import com.pojo.LogWithBLOBs;
import com.pojo.User;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjingyu
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired

    LogMapper logMapper;

    @Override
    public void add(LogWithBLOBs logWithBLOBs) {
        logMapper.insertSelective(logWithBLOBs);
    }

    @Override
    public List<LogWithBLOBs> list() {
        LogExample logExample = new LogExample();
        logExample.setOrderByClause("id desc");
        return logMapper.selectByExampleWithBLOBs(logExample);
    }

}
