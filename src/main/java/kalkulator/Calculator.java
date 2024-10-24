package kalkulator;

public class Calculator {
	private int state = 0;
	String x = "Nie dziel przez 0!";

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void add(int value){
		state += value;
	}

	public void mult(int value){
		state *= value;
	}

	public void divide(int value){
		if (value != 0){
			state = state / value;
		}
	}

}
