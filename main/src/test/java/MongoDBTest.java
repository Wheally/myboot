import com.hzm.boot.Application;
import com.hzm.boot.domain.User;
import com.hzm.boot.mongodb.UserMongoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by WXQ on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MongoDBTest {

    @Autowired
    private UserMongoService userService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setId(1);
        user.setName("wenxq");
        user.setPassword("1234");
        userService.save(user);
    }

    @Test
    public void findUser(){
        User user = userService.findUser(1);

        Assert.assertNotNull(user);
        Assert.assertEquals("wenxq", user.getName());
    }
}
