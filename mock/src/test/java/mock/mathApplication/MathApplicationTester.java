package mock.mathApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
//@PrepareForTest({MathApplication.class})
// @RunWith attaches a runner with the test class to initialize the test data
public class MathApplicationTester {
	
   //@InjectMocks annotation is used to create and inject the mock object
   //MathApplicationÇÃCalculatorServiceÉÅÉìÉoÅ[Ç…MockÇíçì¸ÇµÇ‹Ç∑ÅB
   @InjectMocks 
   //MathApplication mathApplication = new MathApplication();
   MathApplication mathApplication;

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
	   Mockito.when(calcService.add(10.0,20.0)).thenReturn(30.00);
		
      //test the add functionality
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
   }
}