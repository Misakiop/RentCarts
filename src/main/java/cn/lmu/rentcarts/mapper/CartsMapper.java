package cn.lmu.rentcarts.mapper;

import cn.lmu.rentcarts.pojo.Carts;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartsMapper {

    @Select("select * from car_rental.cars")
    List<Carts> findAllCarts();


    @Select("select * from cars where car_id=#{car_id}")
    @Results(id = "CartsMap",value = {
            @Result(property = "car_id",column = "car_id"),
            @Result(property = "car_name",column = "car_name"),
            @Result(property = "car_number",column = "car_number"),
            @Result(property = "car_category",column = "car_category"),
            @Result(property = "car_gear",column = "car_gear"),
            @Result(property = "car_star",column = "car_star"),
            @Result(property = "car_comment",column = "car_comment"),
            @Result(property = "car_price",column = "car_price") })
    public Carts findCartById(int id);

    @Insert("insert into cars(car_id, car_name, car_number, car_category, car_gear, car_star, car_comment, car_price) "+
            "value (#{car_id},#{car_name},#{ car_number},#{car_category},#{car_gear},#{car_star},#{car_comment},#{car_price})")
    public int addCart(Carts carts);

    @Update("update cars set car_number=#{car_number},car_category=#{car_category},car_gear=#{car_gear},car_star=#{car_star},car_comment=#{car_comment},car_price=#{car_price} where car_id=#{car_id}")
    public int updateCart(Carts carts);

    @Delete("delete from cars where car_id=#{car_id}")
    public int deleteCart(int car_id);
}