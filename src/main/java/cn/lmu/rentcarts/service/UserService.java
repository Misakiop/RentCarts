package cn.lmu.rentcarts.service;

import cn.lmu.rentcarts.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User selectByname(String name);
}
