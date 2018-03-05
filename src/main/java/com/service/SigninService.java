package com.service;

import com.pojo.Signin;

import java.util.List;

/**
 * @author zhangjingyu
 */
public interface SigninService {
    void add(Signin signin);
    List<Signin> list();
}
