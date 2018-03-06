package com.service;


import com.pojo.MessageWithBLOBs;
import java.util.List;

/**
 * @author zhangjingyu
 */
public interface MessageService {
    List<MessageWithBLOBs> list();
    void add(MessageWithBLOBs message);
}
