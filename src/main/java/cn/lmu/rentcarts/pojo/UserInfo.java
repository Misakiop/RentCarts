package cn.lmu.rentcarts.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class UserInfo {
    private int id; // 用户编号
    private String userName; // 用户姓名
    private String password; // 用户密码
    private String gender; // 用户性别
    private String email; // 用户邮箱
    private String telephone; // 用户联系电话
    private String introduce; // 用户介绍
    private String activeCode; // 激活码
    private int state;//用户状态
    private String role; // 用户角色
    private List<Role> roleList;//用户角色列表
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date registTime;//注册时间

    public UserInfo() {
    }

    public UserInfo(int id, String password, String userName, String gender, String email, String telephone, String introduce, String activeCode, int state, String role, List<Role> roleList, Date registTime) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.introduce = introduce;
        this.activeCode = activeCode;
        this.state = state;
        this.role = role;
        this.roleList = roleList;
        this.registTime = registTime;
    }
}
