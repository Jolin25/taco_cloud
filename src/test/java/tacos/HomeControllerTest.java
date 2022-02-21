package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tacos.controller.HomeController;
/** knowledge point:
 * ����import static��̬������JDK1.5�е������ԡ�
 *
 * ����һ�����ǵ���һ���඼�� import ����.����;
 *
 * ��������̬������������import static ����.����.*;
 *
 * ��������Ķ��˸�static�����о�������������˸� .* ����˼�ǵ����������ľ�̬��Ա����̬��������̬��������
 *    ��Ȼ��Ҳ����ֻ����ĳ����̬������ֻҪ�� .* ���ɾ�̬�����������ˡ�
 *    Ȼ����������У��Ϳ���ֱ���÷��������þ�̬�������������á�����.������������ �ķ�ʽ�����á�
 *
 *    ���ַ����ĺô����ǿ��Լ�һЩ����������һЩ������ľ�̬������
 *    ���ʹ�˾�̬���룬�Ϳ�����ʹ���Լ��ķ���һ��ʹ����Щ��̬������
 *
 * ����������ʹ�þ�̬����֮ǰ�����Ǳ����˽����漸�㣺
 *
 *    ��̬������ܻ��ô�����������Ķ�
 *    import static��static import������i
 *    ���ͬʱ������������������������ľ�̬��Ա������ֱ�������������Integer���Long���MAX_VALUE��
 *    ���Ե���ľ�̬��Ա������̬�������á���̬�����;�̬������
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
