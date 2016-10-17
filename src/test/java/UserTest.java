import com.alibaba.fastjson.JSON;
import com.hzm.boot.Application;
import com.hzm.boot.controller.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;


/**
 * Created by wxq-mac on 16/9/16.
 */
public class UserTest extends BaseTest{

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
