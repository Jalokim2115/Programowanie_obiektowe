package kalkulator;
import java.util.Scanner;

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

    public long factorial(int state) {
        if (state == 0) {
            return 1;
        } else {
            return state * factorial(state - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        boolean running = true;
		System.out.println("Podaj pierwsza liczbe: ");
        int Initialstate = scanner.nextInt();
		calc.setState(Initialstate);
        while (running) {
            System.out.println("Wybierz operacje:");
            System.out.println("1. Dodawanie");
            System.out.println("2. Mnożenie");
            System.out.println("3. Dzielenie");
            System.out.println("4. Silnia");
            System.out.println("5. Zakończ");

            int choice = scanner.nextInt();
			int value = 0;
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println("Podaj wartość: ");
                value = scanner.nextInt();
            }

            // Switch case do obsługi wyboru
            switch (choice) {
                case 1:
                    System.out.println("Dodajemy " + value);
                    calc.add(value);
                    System.out.println("Nowy stan: " + calc.getState());
                    break;

                case 2:
                    System.out.println("Mnożymy przez " + value);
                    calc.mult(value);
                    System.out.println("Nowy stan: " + calc.getState());
                    break;

                case 3:
                    System.out.println("Dzielimy przez " + value);
                    calc.divide(value);
                    System.out.println("Nowy stan: " + calc.getState());
                    break;

                case 4:
                    System.out.println("Silnia z " + calc.getState() + " wynosi: " + calc.factorial(calc.getState()));
                    break;

                case 5:
                    System.out.println("Kończenie programu...");
                    running = false;
                    break;

                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                    break;
            }
        }

        scanner.close();
    }
}
