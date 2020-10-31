package mock.mathApplication;

import static org.junit.Assert.fail;

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
@PrepareForTest({ MathApplication.class }) // <--- �R�����g�A�E�g���Ă��e�X�g�͒ʂ�
public class MathApplicationTestDoNothing {

	// @InjectMocks annotation is used to create and inject the mock object
	// MathApplication��CalculatorService�����o�[��Mock�𒍓����܂��B
	@InjectMocks
	MathApplication mathApplication;

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	//���ӁI�ICalculatorService�̎����N���X
	SubCalculatorService ��ubCalculatorService;

	@Test
	public void test_doAnswer() throws Exception {
		// calcService.hellowException(double input1, double input2)�̃��b�N������ݒ�
		Mockito.doNothing().when(��ubCalculatorService).hellowException(Mockito.anyDouble(), Mockito.anyDouble());
		try {
			//Junit 5
			//assertDoesNotThrow(() -> target.execute());
			mathApplication.hellowException(0, 0);
		} catch (Exception e) {
			//�e�X�g���s
			fail("Should not have thrown any exception");
		}
	}

}