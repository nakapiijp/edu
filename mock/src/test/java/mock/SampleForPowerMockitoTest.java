package mock;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
//1.@RunWith (推奨)
//2.MockitoRuleを使用する
//3.MockitoAnnotations.initMocksを使用する
@RunWith(PowerMockRunner.class)
@PrepareForTest({Sample.class})
public class SampleForPowerMockitoTest {
    @Test
    public void pubGetSubValue() throws Exception{
    	Sample spy = PowerMockito.spy(new Sample());
        //method1(spy);
    	//method2(spy);
    	try {
    		method3(spy);
    		spy.pubTrowsErr();
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e);
		}
        System.out.println(spy.pubGetValueWithPriGet(" mock"));
    }

	//プライベートメソッドモック方法1
	private void method1(Sample spy) throws Exception {
		PowerMockito.doReturn("スパイモック")
        .when( spy, "priGet", Mockito.anyString());
	} 
	//プライベートメソッドモック方法2
	private void method2(Sample spy) throws Exception {
		PowerMockito.when(spy, method(Sample.class, "priGet", String.class))
    	.withArguments(Mockito.anyString())
        .thenReturn("スパイモック");
	}
	//voidプライベートメソッドモック方法1
	private void method3(Sample spy) throws Exception {
		PowerMockito.doNothing()
        .when( spy, "priTrowsErr");
	} 
}