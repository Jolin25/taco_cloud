package tacos.po;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 构建领域类
 *
 * @author jrl
 * @date 2022/1/31
 */
@Data // 提供setter和getter , toString ,equals,hashCode 等方法
@RequiredArgsConstructor // 给final属性创建对应的构造器
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) // 生成无参构造器，因为JPA需要实体有一个无参构造器
@Entity // 给spring data jpa 用的，申明Ingredient为JPA实体
public class Ingredient {
    @Id
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
