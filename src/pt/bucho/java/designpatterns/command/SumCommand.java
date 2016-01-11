package pt.bucho.java.designpatterns.command;

public class SumCommand implements Command{

	private int value1, value2, result;
	
	public SumCommand(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public void execute() {
		result = value1 + value2;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
