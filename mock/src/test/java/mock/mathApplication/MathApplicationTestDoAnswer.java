package mock.mathApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.hamcrest.CoreMatchers;
//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
//1.@RunWith (推奨)
//2.MockitoRuleを使用する
//3.MockitoAnnotations.initMocksを使用する
@RunWith(PowerMockRunner.class)
// @RunWith attaches a runner with the test class to initialize the test data
@PrepareForTest({ MathApplication.class }) // <--- コメントアウトしてもテストは通る
public class MathApplicationTestDoAnswer {

	// @InjectMocks annotation is used to create and inject the mock object
	// MathApplicationのCalculatorServiceメンバーにMockを注入します。
	@InjectMocks
	MathApplication mathApplication;

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@Test
	public void test_doAnswer() {
		//double calcService.add(double input1, double input2)のモック処理を定義
		// Answer<Double>はリターン値の型
		Answer<Double> answer = new Answer<Double>() {
			@Override
			public Double answer(final InvocationOnMock invocation) throws Throwable {
				//calcService.addの第一引数
				Double orgArgs1 = (Double) (invocation.getArguments())[0];
				//calcService.addの第第二引数
				Double orgArgs2 = (Double) (invocation.getArguments())[1];
				//リターン値を設定
				Double rtnVal = 100.0;
				return rtnVal;
			}
		};
		//calcService.add(double input1, double input2)のモック処理を設定
		Mockito.doAnswer(answer).when(calcService).add(Mockito.anyDouble(), Mockito.anyDouble());

		assertThat( mathApplication.add(10.0, 20.0), CoreMatchers.is(100.0));
	}

}