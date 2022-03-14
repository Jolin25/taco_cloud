package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jrl
 * @date 2022/01/29
 * knowledge point:
 * 作为引导类（springboot），要完成的功能是什么？
 * 1.拉起maven【待定】
 * 2.spring ioc 等--->spring context
 * 所以spring的核心其实是ioc，换句话说就是bean，
 * 在光板程序中，springboot做的事就是初始化spring上下文
 * aop的相关加强是什么时候做的？
 * <p>
 * SpringBootApplication注解包含了三个注解：启动注解扫描、启动自动配置、声明该类为配置类
 */
@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

}
