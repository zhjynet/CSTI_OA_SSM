package com.service.impl;

import com.mapper.MessageMapper;
import com.pojo.MessageExample;
import com.pojo.MessageWithBLOBs;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhang
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<MessageWithBLOBs> list() {
        MessageExample example = new MessageExample();
        example.setOrderByClause("message_id desc");
        return  messageMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void add(MessageWithBLOBs message) {
        messageMapper.insertSelective(message);
    }
}
