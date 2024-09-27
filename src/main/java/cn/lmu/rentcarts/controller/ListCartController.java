package cn.lmu.rentcarts.controller;

import cn.lmu.rentcarts.pojo.Carts;
import cn.lmu.rentcarts.service.CatrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/ListCarts")
public class ListCartController {
    @Autowired
    private CatrsService catrsService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listCarts(Model model){
        List<Carts> listCarts = this.catrsService.findAllCarts();
        model.addAttribute("listCarts", listCarts);
        return "Carts/List";
    }
}
