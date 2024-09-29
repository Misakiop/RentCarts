package cn.lmu.rentcarts.service;

import cn.lmu.rentcarts.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    public List<UserInfo> getAll() ;
    public UserInfo getUserByName(String username);
}
