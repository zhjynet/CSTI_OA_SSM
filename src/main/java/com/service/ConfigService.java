package com.service;

import com.pojo.Config;

/**
 * @author zhang
 */
public interface ConfigService {
    Config get(String configName);
    void update(Config config);
}
