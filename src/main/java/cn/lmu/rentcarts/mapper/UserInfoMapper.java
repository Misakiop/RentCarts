package cn.lmu.rentcarts.mapper;

import cn.lmu.rentcarts.pojo.Role;
import cn.lmu.rentcarts.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 获取符合条件的用户列表
    @Select("select * from user")
    public List<UserInfo> findAll();

    @Select("select * from user where username=#{username}")
    UserInfo findByName(String username);

    @Select("select * from user where id=#{id}")
    UserInfo findById(Integer id);

    @Select("select * from role where id in(select  role_id from user_role where user_role.user_id=#{userId})")
    @Results(id = "RoleMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc")})
    public List<Role> findRolesByUserId(int userId);

}
