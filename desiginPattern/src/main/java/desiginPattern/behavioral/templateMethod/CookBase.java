package desiginPattern.behavioral.templateMethod;

public abstract class CookBase {
	private void setup() {
		//DBAlbg[NZbgAbv
		System.out.println("Äðô¤");
		System.out.println("ÄðÉZ·");
		System.out.println("Äð­");
	}
	private void finish() {
		//DBAlbg[N\[XJú
		System.out.println("Ñíðô¤");
		System.out.println("Híðô¤");
		System.out.println("HíðÐt¯é");
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
	protected void before() {System.out.println("Híð@­");};
	protected abstract void run();
	protected void after() {System.out.println("¿ðñ·é");};
}