package desiginPattern.behavioral.templateMethod;

public abstract class CookBase {
	private void setup() {
		//DB、ネットワークセットアップ等
		System.out.println("米を洗う");
		System.out.println("米を水に浸す");
		System.out.println("米を炊く");
	}
	private void finish() {
		//DB、ネットワークリソース開放
		System.out.println("炊飯器を洗う");
		System.out.println("食器を洗う");
		System.out.println("食器を片付ける");
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
	protected void before() {System.out.println("食器を拭く");};
	protected abstract void run();
	protected void after() {System.out.println("料理を提供する");};
}