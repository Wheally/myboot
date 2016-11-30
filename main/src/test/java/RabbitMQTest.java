import com.hzm.boot.Application;
import com.hzm.boot.mq.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by WXQ on 2016/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RabbitMQTest{

    @Autowired
    private RabbitTemplate rabbit;

    @Test
    public void sendMsg(){
        rabbit.convertAndSend(RabbitMQConfig.queueName,"Hello World");
    }
}
