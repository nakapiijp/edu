package mock.mathApplication;

import org.junit.Assert;
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
@PrepareForTest({MathApplication.class})// <--- コメントアウトしてもテストは通る
public class MathApplicationTester3 {
	
   //@InjectMocks annotation is used to create and inject the mock object
   //MathApplicationのCalculatorServiceメンバーにMockを注入します。
   @InjectMocks 
   MathApplication mathApplication;

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
	   Mockito.when(calcService.add(10.0,20.0)).thenReturn(30.00);
		
      //test the add functionality
	  // @param expected value
	  // @param actual the value to check against expected
	  // @param delta the maximum delta between expected and actual for which both numbers are still
      Assert.assertEquals( 30.0, mathApplication.add(10.0, 20.0), 0);
   }
}