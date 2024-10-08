package cn.lmu.rentcarts.service;

import cn.lmu.rentcarts.pojo.UserInfo;

public interface UserAuthService {
    UserInfo register(UserInfo userToAdd);
    UserInfo login(String username, String  password);
    String refresh(String oldToken);
    UserInfo findByUsername(String username);
}
