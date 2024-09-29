package cn.lmu.rentcarts.mapper;

import cn.lmu.rentcarts.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from car_rental.user")
    List<User> findAll();

    @Select("select * from car_rental.user where username=#{name}")
    public User selectByname(String username);
}
