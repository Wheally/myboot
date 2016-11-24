import com.hzm.boot.Application;
import com.hzm.boot.event.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author xiaoqian.wen
 * @create 2016-11-24 17:32
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EventTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    public void testPubish(){
        OrderService orderService = (OrderService)context.getBean("orderService")           ;
        orderService.createOrder(001);
    }

    @Test
    public void testUserEvent(){
        OrderService orderService = context.getBean(OrderService.class);
        orderService.addUser("1111", "wenxq");
    }

}
