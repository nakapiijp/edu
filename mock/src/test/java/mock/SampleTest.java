package mock;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
//1.@RunWith (推奨)
//2.MockitoRuleを使用する
//3.MockitoAnnotations.initMocksを使用する
public class SampleTest {
    private Sample instance;
    @Before
    public void init() {
        this.instance = new Sample();
    }
    @Test
    public void pubGet() {
        // publicメソッドのテスト
        String actual = instance.pubGet();
        assertThat(actual, is("pubGet"));
    }
    @Test
    public void priGet() throws Exception {
        // privateメソッドのテスト（引数なし）
        Method method = Sample.class.getDeclaredMethod("priGet");
        method.setAccessible(true);

        String actual = (String) method.invoke(instance);
        assertThat(actual, is("priGet"));
    }
    @Test
    public void priGet_withArg() throws Exception {
        // privateメソッドのテスト（引数あり）
        Method method = Sample.class.getDeclaredMethod("priGet", String.class);
        method.setAccessible(true);

        String actual = (String) method.invoke(instance, "Suffix");
        assertThat(actual, is("priGetSuffix"));
    }
    @Test
    public void pubGetSubValue() {
        Sample instance = new Sample(new Sample.Sub("test"));

        String actual = instance.pubGetSubValue();
        assertThat(actual, is("test"));
    }

}