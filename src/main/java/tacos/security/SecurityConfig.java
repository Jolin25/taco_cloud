package tacos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
    /**
     * 进行用户存储配置（用来对用户进行存储）
     * 方式一：基于内存的用户存储
     * 适用情况：假设只有数量有限的几个用户，而且这些用户几乎不会发生变化，
     * 在这种情况下，将这些用户定义成安全配置的一部分是非常简单的。
     *
     * @param auth
     * @date 2022/2/3
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Joly")
                .password("{noop}123456") // 这个｛noop｝好像是必需加的，不然程序要报错，密码是123456
                .authorities("ROLE_USER")
                .and()
                .withUser("Jolin")
                .password("{noop}654321")
                .authorities("ROLE_USER");

    }
}
