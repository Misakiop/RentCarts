package cn.lmu.rentcarts.security;

import cn.lmu.rentcarts.service.serviceImp.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Autowired
    MyUserDetailsServiceImpl myUserDetailsService;
    @Autowired
    MyPasswordEncoder myPasswordEncoder;

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//将编写的UserDetailsService注入进来
        provider.setUserDetailsService(myUserDetailsService);
//将使用的密码编译器加入进来
        provider.setPasswordEncoder(myPasswordEncoder);
//将provider放置到AuthenticationManager 中
        ProviderManager providerManager = new ProviderManager(provider);
        return providerManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //       关闭csrf
        httpSecurity.csrf(it -> it.disable())
                .authorizeHttpRequests(it -> it.requestMatchers("/user/login", "/user/loginfail", "/user/logouted").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN") //管理员角色才能访问管理模块
                        .anyRequest().authenticated() //任何路径都要进行拦截
                )
                .formLogin(form -> form.permitAll().loginPage("/user/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/user_login")
                        .defaultSuccessUrl("/listCarts/")
                        .failureUrl("/user/loginfail"))
                .logout(it -> it.logoutUrl("/logout").logoutSuccessUrl("/user/logouted"))
                .exceptionHandling(it -> it.accessDeniedPage("/user/access_denied"));

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/css/**", "/image/**", "/js/**");
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
//        users.createUser(User.withUsername("tom").password("{noop}123456").roles("USER").build());
//        users.createUser(User.withUsername("admin").password("{noop}admin").roles("ADMIN").build());
//        return users;
//    }
}
