package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tacos.controller.HomeController;
/** knowledge point:
 * 　　import static静态导入是JDK1.5中的新特性。
 *
 * 　　一般我们导入一个类都用 import 包名.类名;
 *
 * 　　而静态导入是这样：import static 包名.类名.*;
 *
 * 　　这里的多了个static，还有就是类名后面多了个 .* 。意思是导入这个类里的静态成员（静态方法、静态变量）。
 *    当然，也可以只导入某个静态方法，只要把 .* 换成静态方法名就行了。
 *    然后在这个类中，就可以直接用方法名调用静态方法，而不必用“类名.方法名（）” 的方式来调用。
 *
 *    这种方法的好处就是可以简化一些操作，例如一些工具类的静态方法，
 *    如果使了静态导入，就可以像使用自己的方法一样使用这些静态方法。
 *
 * 　　不过在使用静态导入之前，我们必须了解下面几点：
 *
 *    静态导入可能会让代码更加难以阅读
 *    import static和static import不能替i
 *    如果同时导入的两个类中又有重命名的静态成员，会出现编译器错误。例如Integer类和Long类的MAX_VALUE。
 *    可以导入的静态成员包括静态对象引用、静态常量和静态方法。
 */
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")).
                andExpect(status().isOk()).
                andExpect(view().name("home"));
//                andExpect(content().string(containsString("Welcome to...")));
    }
}
