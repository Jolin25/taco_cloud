package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.po.Order;


public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
