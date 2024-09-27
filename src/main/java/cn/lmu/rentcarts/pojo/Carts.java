package cn.lmu.rentcarts.pojo;

import lombok.Data;

@Data
public class Carts {
    int cart_id;
    String cart_name;
    String cart_number;
    String cart_category;
    String cart_gear;
    String cart_star;
    String cart_comment;
    int cart_price;

    public Carts(int cart_id, String cart_name, String cart_number, String cart_category, String cart_gear, String cart_star, String cart_comment, int cart_price) {
        this.cart_id = cart_id;
        this.cart_name = cart_name;
        this.cart_number = cart_number;
        this.cart_category = cart_category;
        this.cart_gear = cart_gear;
        this.cart_star = cart_star;
        this.cart_comment = cart_comment;
        this.cart_price = cart_price;
    }
}
