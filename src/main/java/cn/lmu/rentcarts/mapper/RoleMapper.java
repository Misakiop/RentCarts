package cn.lmu.rentcarts.mapper;

import cn.lmu.rentcarts.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from car_rental.role where id in (select user_role.role_id from user_role where user_id=#{userId})")
    @Results(id = "RoleMap",value={
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc")})
    public List<Role> findRolesByUserId(int userId);
}
