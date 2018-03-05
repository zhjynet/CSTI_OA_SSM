package com.task;


import com.pojo.Config;
import com.pojo.User;
import com.service.ConfigService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        user.setIsSigninToday(0);
        for(int i = 0;i<userService.list().size();i++){
            user.setId(userService.list().get(i).getId());
            userService.update(user);
        }
        Config config = configService.get("running_time");
        config.setConfigValue(Integer.parseInt(config.getConfigValue())+1+"");
        config.setGmtModified(null);
        configService.update(config);
    }
}
