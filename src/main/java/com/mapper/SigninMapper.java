package com.mapper;

import com.pojo.Signin;
import com.pojo.SigninExample;

import java.util.List;

public interface SigninMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Signin record);

    int insertSelective(Signin record);

    List<Signin> selectByExample(SigninExample example);

    Signin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);
}