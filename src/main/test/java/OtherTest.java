import org.junit.Test;

public class OtherTest {

    @Test
    public void test1(){
        String str = "a/a/a/a";
        str = str.replace("/","@");
        System.out.println(str);
    }
}
