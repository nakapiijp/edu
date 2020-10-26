package desiginPattern.behavioral.templateMethod;

public class CookRowEgg extends CookBase{
	public static void main(String args[]) {
		CookRowEgg banana = new CookRowEgg();
		banana.exec();
	}
	public void run() {
		System.out.println("¶—‘‚ğ‚²‚Í‚ñ‚É¬‚º‚é");
	}
}