package mock.mathApplication;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
public class MathApplicationTestDoThrow {
	
   //@InjectMocks annotation is used to create and inject the mock object
   //MathApplication��CalculatorService�����o�[��Mock�𒍓����܂��B
   @InjectMocks 
   MathApplication mathApplication;

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   CalculatorService calcService;

   @Test(expected = NullPointerException.class)
   public void doThrow_NullPointerException(){
	   Mockito.doThrow(NullPointerException.class)
	   .when(calcService).add(Mockito.anyDouble(),Mockito.anyDouble());

      mathApplication.add(10.0, 20.0);
   } 
   
   @Test(expected = NullPointerException.class)
   public void thenThrow_NullPointerException(){
	   Mockito.when(mathApplication.add(Mockito.anyDouble(),Mockito.anyDouble()))
	      .thenThrow(NullPointerException.class);

      mathApplication.add(10.0, 20.0);
   }
   
   @Test
   public void doThrow_NullPointerException_try_catch() {
     try {
  	   Mockito.doThrow(NullPointerException.class)
  	   .when(calcService).add(Mockito.anyDouble(),Mockito.anyDouble());
       
  	   //JUnit 5
  	   //JUnit 5 Jupiter�A�T�[�V����API�ł́A��O���A�T�[�g���邽�߂� assertThrows ���\�b�h����������܂����B
  	   //assertThrows(NullPointerException.class, () -> mathApplication.add(10.0, 20.0));

     } catch (Exception e) {
    	 assertEquals(e, NullPointerException.class);
     }
   }
   

   //@Test
   public void thenThrow_NullPointerException_junit5(){
	   Mockito.when(mathApplication.add(Mockito.anyDouble(),Mockito.anyDouble()))
	      .thenThrow(NullPointerException.class);

  	   //JUnit 5
  	   //JUnit 5 Jupiter�A�T�[�V����API�ł́A��O���A�T�[�g���邽�߂� assertThrows ���\�b�h����������܂����B
  	   //assertThrows(NullPointerException.class, () -> mathApplication.add(10.0, 20.0));
   }
}