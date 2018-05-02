package com.service;

import com.pojo.LogWithBLOBs;

import java.util.List;

/**
 * @author zhangjingyu
 */
public interface LogService {
    void add(LogWithBLOBs logWithBLOBs);
    List<LogWithBLOBs> list();

}
