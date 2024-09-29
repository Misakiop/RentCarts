package cn.lmu.rentcarts.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;  // 用户ID
    private String name;  // 用户名
    private String password;  // 密码
    private int phone;  // 手机号码
    private String address;  // 地址
    private String email;  // 邮箱
    private List<Role> roleList;  // 角色列表

    public User() {
    }

    public User(int id, String name, String password, int phone, String address, String email, List<Role> roleList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.roleList = roleList;
    }
}


