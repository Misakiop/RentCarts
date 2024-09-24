package cn.lmu.rentcarts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("cn.lmu.rentcarts.mapper")
public class RentCartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCartsApplication.class, args);
    }

}
