package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * 使用基于注解的Spring Security 配置完成 Taco Cloud 安全性需要的所有设置
 * 验证通过时效：基于会话的时效
 *
 * @author jrl
 * @date 2022/2/3
 */
@EnableWebSecurity
@Configuration // spring 的，表明这是一个配置类
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * 密码转换器
     *
     * @author jrl
     * @date 2022/2/3
     */
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
    /**
     * 进行用户存储配置（用来对用户进行存储）
     * 方式一：基于内存的用户存储
     * 适用情况：假设只有数量有限的几个用户，而且这些用户几乎不会发生变化，
     * 在这种情况下，将这些用户定义成安全配置的一部分是非常简单的。
     *
     * @param auth
     * @date 2022/2/3
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Joly")
//                .password("{noop}123456") // 这个｛noop｝好像是必需加的，不然程序要报错，密码是123456
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("Jolin")
//                .password("{noop}654321")
//                .authorities("ROLE_USER");
//
//    }

    /**
     * 基于JDBC的用户存储
     * 会自动去查询数据库中的几张设定好名字的表，按照用户名来查询，
     * 进行认证、授权
     *
     * @param
     * @return
     * @date 2022/2/3
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);
//
//    }

    /**
     * 自定义用户认证
     * 通过jpa到数据库中根据用户名找到用户，将转换后的密码和数据库中的密码进行比对
     *
     * @param
     * @return
     * @date 2022/2/3
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

    }

    /**
     * 用于配置需要拦截的请求，以及对应的如需访问用户需要具备的条件
     *
     * @param
     * @return
     * @date 2022/2/3
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // 进行授权相关的配置
                .authorizeRequests()
                // 配置的顺序很重要，前面的优先级比后面高
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").permitAll()
                // and方法用于连接上下两种配置
                .and()
                // 进行http相关的配置
                .formLogin()
                // 用于告诉spring security 自定义登录页的路径是什么(这是路径不是页面)
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/design", true);

    }
}
