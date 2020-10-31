package mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
// 1.@RunWith (推奨)
// 2.MockitoRuleを使用する
// 3.MockitoAnnotations.initMocksを使用する
@RunWith(PowerMockRunner.class)
@PrepareForTest(CodeWithPrivateMethod.class)
public class CodeWithPrivateMethodTest {

    @Test(expected = RuntimeException.class)
    public void when_gambling_is_true_then_always_explode() throws Exception {
        CodeWithPrivateMethod spy = PowerMockito.spy(new CodeWithPrivateMethod());

        when(spy, method(CodeWithPrivateMethod.class, "doTheGamble", String.class, int.class))
                .withArguments(anyString(), anyInt())
                .thenReturn(true);

        spy.meaningfulPublicApi();
    }
}