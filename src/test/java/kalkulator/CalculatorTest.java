package kalkulator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testAddNegative(){
		Calculator sut = new Calculator();
		sut.add(-1);
		assertEquals("0+(-1) = -1", -1, sut.getState());
	}
	@Test
	public void testMultOneByZero(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(0);
		assertEquals("1*0 = 0", 0, sut.getState());
	}
	@Test
	public void testDivByZero(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.divide(0);
		assertEquals("1/0 = 1", "Nie dziel przez 0!", sut.x);
	}
}
