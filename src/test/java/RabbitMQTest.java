import com.hzm.boot.mq.RabbitMQConfig;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by WXQ on 2016/10/18.
 */
public class RabbitMQTest extends BaseTest{

    @Autowired
    private RabbitTemplate rabbit;

    @Test
    public void sendMsg(){
        rabbit.convertAndSend(RabbitMQConfig.queueName,"Hello World");
    }
}
