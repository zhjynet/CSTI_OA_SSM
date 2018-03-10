package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User get(String studentNumber, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andStudentNumberEqualTo(studentNumber).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExampleWithBLOBs(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(String studentNumber) {
        UserExample example = new UserExample();
        example.createCriteria().andStudentNumberEqualTo(studentNumber);
        List<User> result = userMapper.selectByExampleWithBLOBs(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> list(int smallGroup,int groupId) {
        UserExample example = new UserExample();
        example.createCriteria().andSmallGroupEqualTo(smallGroup).andGroupIdEqualTo(groupId);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> list(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        return userMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }
}
