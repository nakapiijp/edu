package desiginPattern.behavioral.templateMethod;

public abstract class CookBase {
	private void setup() {
		//DB�A�l�b�g���[�N�Z�b�g�A�b�v��
		System.out.println("�Ă��");
		System.out.println("�Ă𐅂ɐZ��");
		System.out.println("�Ă𐆂�");
	}
	private void finish() {
		//DB�A�l�b�g���[�N���\�[�X�J��
		System.out.println("���ъ���");
		System.out.println("�H����");
		System.out.println("�H���Еt����");
	}
	public final void exec()
	{
		try {
			setup();
			before();
			run();
			after();
		}finally {
			finish();
		}
	}
	protected void before() {System.out.println("�H���@��");};
	protected abstract void run();
	protected void after() {System.out.println("������񋟂���");};
}