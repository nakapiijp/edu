package mock.mathApplication;

public class SubCalculatorService implements CalculatorService {
	public double add(double input1, double input2) {return 0;};
	public double subtract(double input1, double input2) {return 0;};
	public double multiply(double input1, double input2)  {return 0;};
	public double divide(double input1, double input2)  {return 0;};	
	public void hellowException(double input1, double input2) throws Exception {
		throw new Exception();
	}
}