package cn.lmu.rentcarts.pojo;

import lombok.Data;

@Data
public class Carts {
    int car_id;
    String car_name;
    String car_number;
    String car_category;
    String car_gear;
    String car_star;
    String car_comment;
    int car_price;

    public Carts() {
    }

    public Carts(int car_id, String car_name, String car_number, String car_category, String car_gear, String car_star, int car_price, String car_comment) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.car_number = car_number;
        this.car_category = car_category;
        this.car_gear = car_gear;
        this.car_star = car_star;
        this.car_price = car_price;
        this.car_comment = car_comment;
    }
}
