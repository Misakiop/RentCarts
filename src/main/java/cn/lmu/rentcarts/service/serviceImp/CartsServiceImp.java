package cn.lmu.rentcarts.service.serviceImp;

import cn.lmu.rentcarts.mapper.CartsMapper;
import cn.lmu.rentcarts.pojo.Carts;
import cn.lmu.rentcarts.service.CatrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsServiceImp implements CatrsService{
    @Autowired
    private CartsMapper cartsMapper;

    @Override
    public List<Carts> findAllCarts(){
        return this.cartsMapper.findAllCarts();
    }
}
