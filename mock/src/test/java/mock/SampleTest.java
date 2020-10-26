package mock;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SampleTest {
    private Sample instance;
    @Before
    public void init() {
        this.instance = new Sample();
    }
    @Test
    public void pubGet() {
        // public���\�b�h�̃e�X�g
        String actual = instance.pubGet();
        assertThat(actual, is("pubGet"));
    }
    @Test
    public void priGet() throws Exception {
        // private���\�b�h�̃e�X�g�i�����Ȃ��j
        Method method = Sample.class.getDeclaredMethod("priGet");
        method.setAccessible(true);

        String actual = (String) method.invoke(instance);
        assertThat(actual, is("priGet"));
    }
    @Test
    public void priGet_withArg() throws Exception {
        // private���\�b�h�̃e�X�g�i��������j
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