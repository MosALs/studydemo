import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldTests.class)
public class HelloWorldTests {

    @Test
    public void test(){
        System.out.println("welcome in spring boot test");
    }
}
