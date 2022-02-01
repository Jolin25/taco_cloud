package tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 控制器类
 * 初始化页面
 *
 * @author jrl
 * @date 2022/1/31
 */
@Slf4j // （simple logging facade for java ）lombok提供的注解，用于在这个类中自动生成一个Logger
@Controller // 表示该类为一个bean
@RequestMapping("/design") // 指明该处理器所接受的请求类型
public class DesignTacoController {
    /**
     * knowledge point:
     * Controller的作用就是获取数据，然后有两种模式返回数据：
     * 1.将请求传递给视图以便渲染HTML
     * 2.直接将数据写入响应体（RESTful）
     * 这里用的是第一种形式
     */
    @GetMapping // 和@RequestMapping 的属性一模一样，但是指明了接受get请求
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            // Model对象负责在Controller和视图之间传递数据。
            // （通过把Model属性中的数据复制给Servlet Response的属性中，这样视图就可以找到数据了）
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        // 这里返回的是视图的名称
        return "design";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Taco design) {
        log.info("Processing design:" + design);
        //todo 这里会对设计的taco进行保存
        /** knowledge point:
         * redirect:  代表重定向，这是后台干的，把请求继续发送给/orders/current
         */
        return "redirect:/orders/current";
    }
}
