package com.service.impl;

import com.mapper.SigninMapper;
import com.pojo.Signin;
import com.pojo.SigninExample;
import com.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang
 */
@Service
public class SigninServiceImpl implements SigninService {
    @Autowired
    SigninMapper signinMapper;
    @Override
    public void add(Signin signin) {
        signinMapper.insertSelective(signin);
    }

    @Override
    public List<Signin> list() {
        SigninExample example = new SigninExample();
        example.setOrderByClause("id desc");
        return signinMapper.selectByExample(example);
    }
}
