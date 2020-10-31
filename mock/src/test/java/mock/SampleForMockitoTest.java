package mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
//1.@RunWith (推奨)
//2.MockitoRuleを使用する
//3.MockitoAnnotations.initMocksを使用する
public class SampleForMockitoTest {
    @Mock
    private Sample mock;///クラスの一つメソッドをモックした場合、他のメソッドはデフォルトモックされる
    @Spy
    private Sample spy;//クラスの一部のメソッドをモックしたい場合に使用
    @Before
    public void init() {
        // @Mockアノテーションのモックオブジェクトを初期化
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void pubGetSubValue() {
        // モックを使用しない場合
        Sample instance = new Sample(new Sample.Sub("test"));

        String actual = instance.pubGetSubValue();
        assertThat(actual, is("test"));
    }
    @Test
    public void pubGetSubValue_withMockito() {
        // モックを使用した場合は、スタブの値を返す
        Sample.Sub mock = mock(Sample.Sub.class);
        when(mock.getValue()).thenReturn("mock value");
        Sample instance = new Sample(mock);

        String actual = instance.pubGetSubValue();
        assertThat(actual, is("mock value"));
    }

    @Test
    public void pubGetSubValue_withMockitoMock() {
        // mock() はスタブを実装しないとデフォルト値（null）となる
        String actual1 = mock.pubGet();
        assertThat(actual1, is(nullValue()));

        // mock() はスタブを実装するとスタブの値を返す
        when(mock.pubGet()).thenReturn("mock value");
        String actual2 = mock.pubGet();
        assertThat(actual2, is("mock value"));
    }

    @Test
    public void pubGetSubValue_withMockitoSpy() {
        // spy() はスタブを実装しないと実際の値を返す
        String actual1 = spy.pubGet();
        assertThat(actual1, is("pubGet"));

        // spy() はスタブを実装するとスタブの値を返す
        when(spy.pubGet()).thenReturn("mock value");
        String actual2 = spy.pubGet();
        assertThat(actual2, is("mock value"));
    }
    @Test
    public void pubGetSubValue_withMockitoAnswer() {
        // mock() はスタブを実装するとスタブの値を返す
        // Answerを使うとスタブにメソッドの引数を利用することができる
        when(mock.pubGet(anyString())).thenAnswer(invocation -> {
            String arg1 = (String) invocation.getArguments()[0];
            return "mock value " + arg1;
        });
        String actual = mock.pubGet("suffix");
        assertThat(actual, is("mock value suffix"));
    }
}