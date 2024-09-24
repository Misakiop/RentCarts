package cn.lmu.rentcarts.service.serviceImp;

import cn.lmu.rentcarts.mapper.UserMapper;
import cn.lmu.rentcarts.pojo.User;
import cn.lmu.rentcarts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired

    private UserMapper usermapper;

    @Override
    public List<User> findAll() {
        return this.usermapper.findAll();
    }

    @Override
    public User selectByname(String name) {
        return this.usermapper.selectByname(name);
    }
}
