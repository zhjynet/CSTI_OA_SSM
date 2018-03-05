package com.service;

import com.pojo.Message;

import java.util.List;

/**
 * @author zhangjingyu
 */
public interface MessageService {
    List<Message> list();
    void add(Message message);
}
