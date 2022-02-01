package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * 构建领域类
 * @author jrl
 * @date 2022/1/31
 */
@Data // 提供setter和getter , toString ,equals,hashCode 等方法
@RequiredArgsConstructor // 给final属性创建对应的构造器
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    /**
     * 枚举内部类
     *
     * @author jrl
     * @date 2022/1/31
     */
    public enum Type {
        /**
         * 包装
         */
        WRAP,
        /**
         * 蛋白质
         */
        PROTEIN,
        /**
         * 素菜
         */
        VEGGIES,
        /**
         * 奶酪
         */
        CHEESE,
        /**
         * 酱汁
         */
        SAUCE
    }


}
