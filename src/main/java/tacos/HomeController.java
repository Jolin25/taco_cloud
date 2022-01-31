package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jrl
 * @date 2022/1/30
 */
@Controller
public class HomeController {
    /**
     * knowledge point:
     * springMVC做的工作是 帮忙解析请求，与Controller进行匹配。
     * （如果没有SpringMVC的话，就需要自己拿出来request，对请求路径进行分析，
     * 匹配到了对应的请求后，再调用对应的Controller。所以没有SpringMVC的话，就需要
     * 自己写一个类似的东西来进行请求分配）
     */
    @GetMapping("/")
    public String home() {
        /** knowledge point:
         *  返回视图名
         */
        System.out.println("hello19");
        return "home";

    }
}
