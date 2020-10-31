package mock.mathApplication;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//Mock、Spy、Captor、InjectMocksアノテーションが付いたオブジェクトの初期化を行う方法です。
//1.@RunWith (推奨)
//2.MockitoRuleを使用する
//3.MockitoAnnotations.initMocksを使用する
@RunWith(PowerMockRunner.class)
// @RunWith attaches a runner with the test class to initialize the test data
@PrepareForTest({ MathApplication.class }) // <--- コメントアウトしてもテストは通る
public class MathApplicationTestDoNothing {

	// @InjectMocks annotation is used to create and inject the mock object
	// MathApplicationのCalculatorServiceメンバーにMockを注入します。
	@InjectMocks
	MathApplication mathApplication;

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	//注意！！CalculatorServiceの実装クラス
	SubCalculatorService ｓubCalculatorService;

	@Test
	public void test_doAnswer() throws Exception {
		// calcService.hellowException(double input1, double input2)のモック処理を設定
		Mockito.doNothing().when(ｓubCalculatorService).hellowException(Mockito.anyDouble(), Mockito.anyDouble());
		try {
			//Junit 5
			//assertDoesNotThrow(() -> target.execute());
			mathApplication.hellowException(0, 0);
		} catch (Exception e) {
			//テスト失敗
			fail("Should not have thrown any exception");
		}
	}

}