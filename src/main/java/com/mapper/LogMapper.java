package com.mapper;

import com.pojo.Log;
import com.pojo.LogExample;
import com.pojo.LogWithBLOBs;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogWithBLOBs record);

    int insertSelective(LogWithBLOBs record);

    List<LogWithBLOBs> selectByExampleWithBLOBs(LogExample example);

    List<Log> selectByExample(LogExample example);

    LogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogWithBLOBs record);

    int updateByPrimaryKey(Log record);
}