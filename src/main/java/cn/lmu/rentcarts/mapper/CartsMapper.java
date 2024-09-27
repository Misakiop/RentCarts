package cn.lmu.rentcarts.mapper;

import cn.lmu.rentcarts.pojo.Carts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartsMapper {

    @Select("select * from car_rental.cars")
    List<Carts> findAllCarts();
}
