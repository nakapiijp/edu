package mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Mock�ASpy�ACaptor�AInjectMocks�A�m�e�[�V�������t�����I�u�W�F�N�g�̏��������s�����@�ł��B
//1.@RunWith (����)
//2.MockitoRule���g�p����
//3.MockitoAnnotations.initMocks���g�p����
public class SampleForMockitoTest {
    @Mock
    private Sample mock;///�N���X�̈���\�b�h�����b�N�����ꍇ�A���̃��\�b�h�̓f�t�H���g���b�N�����
    @Spy
    private Sample spy;//�N���X�̈ꕔ�̃��\�b�h�����b�N�������ꍇ�Ɏg�p
    @Before
    public void init() {
        // @Mock�A�m�e�[�V�����̃��b�N�I�u�W�F�N�g��������
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void pubGetSubValue() {
        // ���b�N���g�p���Ȃ��ꍇ
        Sample instance = new Sample(new Sample.Sub("test"));

        String actual = instance.pubGetSubValue();
        assertThat(actual, is("test"));
    }
    @Test
    public void pubGetSubValue_withMockito() {
        // ���b�N���g�p�����ꍇ�́A�X�^�u�̒l��Ԃ�
        Sample.Sub mock = mock(Sample.Sub.class);
        when(mock.getValue()).thenReturn("mock value");
        Sample instance = new Sample(mock);

        String actual = instance.pubGetSubValue();
        assertThat(actual, is("mock value"));
    }

    @Test
    public void pubGetSubValue_withMockitoMock() {
        // mock() �̓X�^�u���������Ȃ��ƃf�t�H���g�l�inull�j�ƂȂ�
        String actual1 = mock.pubGet();
        assertThat(actual1, is(nullValue()));

        // mock() �̓X�^�u����������ƃX�^�u�̒l��Ԃ�
        when(mock.pubGet()).thenReturn("mock value");
        String actual2 = mock.pubGet();
        assertThat(actual2, is("mock value"));
    }

    @Test
    public void pubGetSubValue_withMockitoSpy() {
        // spy() �̓X�^�u���������Ȃ��Ǝ��ۂ̒l��Ԃ�
        String actual1 = spy.pubGet();
        assertThat(actual1, is("pubGet"));

        // spy() �̓X�^�u����������ƃX�^�u�̒l��Ԃ�
        when(spy.pubGet()).thenReturn("mock value");
        String actual2 = spy.pubGet();
        assertThat(actual2, is("mock value"));
    }
    @Test
    public void pubGetSubValue_withMockitoAnswer() {
        // mock() �̓X�^�u����������ƃX�^�u�̒l��Ԃ�
        // Answer���g���ƃX�^�u�Ƀ��\�b�h�̈����𗘗p���邱�Ƃ��ł���
        when(mock.pubGet(anyString())).thenAnswer(invocation -> {
            String arg1 = (String) invocation.getArguments()[0];
            return "mock value " + arg1;
        });
        String actual = mock.pubGet("suffix");
        assertThat(actual, is("mock value suffix"));
    }
}