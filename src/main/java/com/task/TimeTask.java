package com.task;


import com.pojo.Config;
import com.pojo.User;
import com.service.ConfigService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhang
 */
@Component("task")
public class TimeTask {
    @Autowired
    UserService userService;
    @Autowired
    ConfigService configService;
    @Scheduled(cron = "0 0 0 * * ? ")
    public void taskCycle() {
        User user = new User();
        //签到重置
        user.setIsSigninToday(0);
        user.setGmtModified(null);
        for(int i = 0;i<userService.list().size();i++){
            user.setId(userService.list().get(i).getId());
            userService.update(user);
        }
        //运行时间加一
        Config config = configService.get("running_time");
        config.setConfigValue(Integer.parseInt(config.getConfigValue())+1+"");
        config.setGmtModified(null);
        configService.update(config);
        //值日表更新


    }
}
