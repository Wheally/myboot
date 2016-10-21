import com.alibaba.fastjson.JSON;
import com.hzm.boot.Application;
import com.hzm.boot.controller.UserController;
import com.hzm.boot.domain.User;
import com.hzm.boot.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;


/**
 * Created by wxq-mac on 16/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserTest{

    @Autowired
    private WebApplicationContext context;

    public MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setName("wenxq");
        user.setPassword("1234");

        int num = userService.saveUser(user);
        Assert.assertEquals(1, num);
    }
    @Test
    public void saveUser2(){
        User user2 = new User();
        user2.setName("wenzj");
        user2.setPassword("1234");
        int id = userService.saveUserBackId(user2);
        Assert.assertNotNull(id);
    }

    @Test
    public void findUser(){
        User user = userService.findUser(1);

        Assert.assertNotNull(user);
        Assert.assertEquals("wenxq", user.getName());
    }

    @Test
    public void getUser() throws Exception {

        String expectedResult = "zhaojigang";
        String url = "/user/getUser?userId=2";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        Map map = JSON.parseObject(content, Map.class);

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertFalse("错误，正确的返回值为200", status != 200);
        Assert.assertTrue("数据一致", expectedResult.equals(map.get("username")));
        Assert.assertFalse("数据不一致", !expectedResult.equals(map.get("username")));
    }

}
