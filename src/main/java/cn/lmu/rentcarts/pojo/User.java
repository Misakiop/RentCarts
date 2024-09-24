package cn.lmu.rentcarts.pojo;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    int telephone;
    String address;

    public User(int id, String name, int telephone, String address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }
}


