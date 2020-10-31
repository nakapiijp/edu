package mock;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
//Mock�ASpy�ACaptor�AInjectMocks�A�m�e�[�V�������t�����I�u�W�F�N�g�̏��������s�����@�ł��B
//1.@RunWith (����)
//2.MockitoRule���g�p����
//3.MockitoAnnotations.initMocks���g�p����
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

	//�v���C�x�[�g���\�b�h���b�N���@1
	private void method1(Sample spy) throws Exception {
		PowerMockito.doReturn("�X�p�C���b�N")
        .when( spy, "priGet", Mockito.anyString());
	} 
	//�v���C�x�[�g���\�b�h���b�N���@2
	private void method2(Sample spy) throws Exception {
		PowerMockito.when(spy, method(Sample.class, "priGet", String.class))
    	.withArguments(Mockito.anyString())
        .thenReturn("�X�p�C���b�N");
	}
	//void�v���C�x�[�g���\�b�h���b�N���@1
	private void method3(Sample spy) throws Exception {
		PowerMockito.doNothing()
        .when( spy, "priTrowsErr");
	} 
}