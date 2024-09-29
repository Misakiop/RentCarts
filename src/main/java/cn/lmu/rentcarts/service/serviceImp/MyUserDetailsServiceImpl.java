package cn.lmu.rentcarts.service.serviceImp;

import cn.lmu.rentcarts.mapper.RoleMapper;
import cn.lmu.rentcarts.mapper.UserInfoMapper;
import cn.lmu.rentcarts.pojo.Role;
import cn.lmu.rentcarts.pojo.UserInfo;
import cn.lmu.rentcarts.security.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userDetailsService")
public class MyUserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =  this.userInfoMapper.findByName(username);
        org.springframework.security.core.userdetails.User user = null;
        if (userInfo != null) {
            List<Role> roles =  this.roleMapper.findRolesByUserId(userInfo.getId());
            userInfo.setRoleList(roles);
            user = new  org.springframework.security.core.userdetails.User(userInfo.getUserName(), myPasswordEncoder.encode(userInfo.getPassword()),
                    getAuthority(roles));
        }
        return user;
    }
    private List<SimpleGrantedAuthority>  getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list =  new ArrayList<>();
        for (Role role : roles) {
            list.add(new  SimpleGrantedAuthority("ROLE_" +  role.getRoleName().toUpperCase()));
        }
        return list;
    }
}
