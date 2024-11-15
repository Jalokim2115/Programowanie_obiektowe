package stos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    // Testowanie metody push
    @Test
    public void testPushAndSize() {
        assertEquals(0, stack.size());
        
        stack.push("Element 1");
        assertEquals(1, stack.size());
        
        stack.push("Element 2");
        assertEquals(2, stack.size());
    }

    // Testowanie metody pop
    @Test
    public void testPop() {
        stack.push("Element 1");
        stack.push("Element 2");
        
        assertEquals("Element 2", stack.pop());
        assertEquals(1, stack.size());
        
        assertEquals("Element 1", stack.pop());
        assertEquals(0, stack.size());
    }

    // Testowanie metody pop na pustym stosie
    @Test
    public void testPopEmptyStack() {
        assertNull("Metoda pop powinna zwrócić null dla pustego stosu", stack.pop());
    }

    // Testowanie metody peek
    @Test
    public void testPeek() {
        stack.push("Element 1");
        stack.push("Element 2");
        assertEquals("Element 2", stack.peek());
        assertEquals(2, stack.size());
    }

    // Testowanie metody peek na pustym stosie
    @Test
    public void testPeekEmptyStack() {
        assertNull("Metoda peek powinna zwrócić null dla pustego stosu", stack.peek());
    }
    // Testowanie czy wyjatek dla pustego stosu dobrze jest wylapywany
    @Test
    public void testPopOnEmptyStackShouldHaveSizeZero() {
        stack.pop();
        assertEquals("Rozmiar stosu powinien wynosić 0 po wywołaniu pop na pustym stosie.", 0, stack.size());
    }
}

