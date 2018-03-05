package com.service.impl;

import com.mapper.ConfigMapper;
import com.pojo.Config;
import com.pojo.ConfigExample;
import com.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    ConfigMapper configMapper;
    @Override
    public Config get(String configName) {
        ConfigExample example = new ConfigExample();
        example.createCriteria().andConfigNameEqualTo(configName);
        List<Config> result = configMapper.selectByExampleWithBLOBs(example);
        return result.get(0);
    }

    @Override
    public void update(Config config) {
        configMapper.updateByPrimaryKeySelective(config);
    }
}
