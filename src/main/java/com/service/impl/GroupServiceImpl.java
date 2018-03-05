package com.service.impl;

import com.mapper.GroupMapper;
import com.pojo.Group;
import com.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhangjingyu
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Override
    public Group get(int id) {
        return groupMapper.selectByPrimaryKey(id);
    }
}
