package cn.lmu.rentcarts.controller;

import cn.lmu.rentcarts.pojo.Carts;
import cn.lmu.rentcarts.service.CatrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ListCarts")
public class ListCartController {
    @Autowired
    private CatrsService catrsService;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String listCarts(Model model){
//        List<Carts> listCarts = this.catrsService.findAllCarts();
//        model.addAttribute("listCarts", listCarts);
//        return "Carts/List";
//    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Carts> getList(){
        List<Carts> cartsList = this.catrsService.findAllCarts();
        return cartsList;
    }
}
