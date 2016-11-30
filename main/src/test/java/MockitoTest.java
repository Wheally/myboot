import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @desc mockito测试
 * Created by WXQ on 2016/10/20.
 */
public class MockitoTest {

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sampleTest(){
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);
        verify(list).get(0);

        Assert.assertEquals("helloworld", result);
    }

}
