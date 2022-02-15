package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.Order;

/**
 * @author jrl
 * @date 2022-2-15
 */
public interface OrderRepository
        extends CrudRepository<Order, Long> {

}
