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
//Mock�ASpy�ACaptor�AInjectMocks�A�m�e�[�V�������t�����I�u�W�F�N�g�̏��������s�����@�ł��B
//1.@RunWith (����)
//2.MockitoRule���g�p����
//3.MockitoAnnotations.initMocks���g�p����
@RunWith(PowerMockRunner.class)
// @RunWith attaches a runner with the test class to initialize the test data
@PrepareForTest({ MathApplication.class }) // <--- �R�����g�A�E�g���Ă��e�X�g�͒ʂ�
public class MathApplicationTestDoAnswer {

	// @InjectMocks annotation is used to create and inject the mock object
	// MathApplication��CalculatorService�����o�[��Mock�𒍓����܂��B
	@InjectMocks
	MathApplication mathApplication;

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@Test
	public void test_doAnswer() {
		//double calcService.add(double input1, double input2)�̃��b�N�������`
		// Answer<Double>�̓��^�[���l�̌^
		Answer<Double> answer = new Answer<Double>() {
			@Override
			public Double answer(final InvocationOnMock invocation) throws Throwable {
				//calcService.add�̑�����
				Double orgArgs1 = (Double) (invocation.getArguments())[0];
				//calcService.add�̑������
				Double orgArgs2 = (Double) (invocation.getArguments())[1];
				//���^�[���l��ݒ�
				Double rtnVal = 100.0;
				return rtnVal;
			}
		};
		//calcService.add(double input1, double input2)�̃��b�N������ݒ�
		Mockito.doAnswer(answer).when(calcService).add(Mockito.anyDouble(), Mockito.anyDouble());

		assertThat( mathApplication.add(10.0, 20.0), CoreMatchers.is(100.0));
	}

}