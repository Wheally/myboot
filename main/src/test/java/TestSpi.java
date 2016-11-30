import com.hzm.boot.spi.Spi;
import com.hzm.boot.spi.SpiFactory;
import org.junit.Test;

/**
 * 测试Spi
 *
 * @author xiaoqian.wen
 * @create 2016-11-29 9:19
 **/
public class TestSpi {

    @Test
    public void test(){
        Spi spi = SpiFactory.getSpi("SPIB");
        System.out.println(spi.sayHello());
    }

}
