package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.User;

/**
 * @author jrl
 * @date 2022/2/3
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * spring data jpa 会在运行时自动生成这个接口的实现
     *
     * @param username 用户名称
     * @return user
     * @date 2022/2/3
     */
    User findByUsername(String username);

}
