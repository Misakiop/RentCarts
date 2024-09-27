package cn.lmu.rentcarts.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    //核心配置
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable) //关闭csrf
                .authorizeHttpRequests(it->it.requestMatchers("/admin/**").hasRole("ADMIN") //管理员角色才能访问管理模块
                        .anyRequest().authenticated() //任何路径都要进行拦截
                )
                .formLogin(form-> form.permitAll().defaultSuccessUrl("/ListCarts/"));
        return httpSecurity.build();
    }

    //放行静态资源目录
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/css/**","/image/**","/js/**");
    }

    //自定义UserDetailsService实现（基于内存的用户信息）
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("tom").password("{noop}123456").roles("USER").build());
        //SpringSecurity支持多种密码的验证方式所以，如果数据库的密码为明文需要添加{noop}密码
        users.createUser(User.withUsername("admin").password("{noop}admin").roles("ADMIN").build());
        return users;
    }
}
