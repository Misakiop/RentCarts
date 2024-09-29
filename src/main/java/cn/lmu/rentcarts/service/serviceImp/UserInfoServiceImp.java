package cn.lmu.rentcarts.service.serviceImp;

import cn.lmu.rentcarts.mapper.RoleMapper;
import cn.lmu.rentcarts.mapper.UserInfoMapper;
import cn.lmu.rentcarts.pojo.UserInfo;
import cn.lmu.rentcarts.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RoleMapper roleMapper;
    public List<UserInfo> getAll() {
        return this.userInfoMapper.findAll();
    }
    public UserInfo getUserByName(String username) {
        return this.userInfoMapper.findByName(username);
    }
}
