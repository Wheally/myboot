import com.alibaba.dubbo.config.annotation.Reference;
import com.hzm.boot.Application;
import com.hzm.boot.demo.IDubboDemoService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author xiaoqian.wen
 * @create 2016-11-29 12:52
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DubboTest {

    @Autowired
    private WebApplicationContext context;

    @Reference(interfaceClass = IDubboDemoService.class)
    private IDubboDemoService demoService;

    public MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test(){
        demoService.sayHello("Hello World");
    }

}
