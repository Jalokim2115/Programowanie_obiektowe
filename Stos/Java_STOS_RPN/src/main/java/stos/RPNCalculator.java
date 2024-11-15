package stos;
public class RPNCalculator {
    private Stack stack;

    public RPNCalculator() {
        this.stack = new Stack();
    }
    // Metoda obliczania wyrazenia
    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                
                int result = performOperation(a, b, token);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        
        // Wynik końcowy będzie jedynym elementem na stosie
        return Integer.parseInt(stack.pop());
    }

    // Sprawdzanie, czy dany token jest operatorem
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*");
    }

    // Metoda wykonująca odpowiednią operację na dwóch liczbach
    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("Nieznany operator: " + operator);
        }
    }
}
