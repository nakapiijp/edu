package mock.mathApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//Mock�ASpy�ACaptor�AInjectMocks�A�m�e�[�V�������t�����I�u�W�F�N�g�̏��������s�����@�ł��B
//1.@RunWith (����)
//2.MockitoRule���g�p����
//3.MockitoAnnotations.initMocks���g�p����
@RunWith(PowerMockRunner.class)
// @RunWith attaches a runner with the test class to initialize the test data
@PrepareForTest({MathApplication.class})// <--- �R�����g�A�E�g���Ă��e�X�g�͒ʂ�
public class MathApplicationTester3 {
	
   //@InjectMocks annotation is used to create and inject the mock object
   //MathApplication��CalculatorService�����o�[��Mock�𒍓����܂��B
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