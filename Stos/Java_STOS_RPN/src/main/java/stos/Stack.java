package stos;
public class Stack {
    private String[] elements = null; // Pusta tablica na początek
    private int rozmiar = 0; // Liczba elementów na stosie

    // Metoda push dodaje element do stosu
    public void push(String element) {
        // Jeśli tablica jest pusta, inicjujemy ją z rozmiarem 1
        if (elements == null) {
            elements = new String[1];
        } 
        // Jeśli tablica jest pełna, zwiększamy jej rozmiar
        else if (rozmiar == elements.length) {
            expandCapacity();
        }
        
        elements[rozmiar] = element;
        rozmiar++;
    }

    // Metoda pop zdejmuje element ze stosu i go zwraca
    public String pop() {
        try {
            if (rozmiar == 0) {
                throw new EmptyStackException("Stos jest pusty");
            }
            String topElement = elements[rozmiar - 1];
            elements[rozmiar - 1] = null;
            rozmiar--;
            return topElement;
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Metoda peek zwraca element na szczycie
    public String peek() {
        try {
            if (rozmiar == 0) {
                throw new EmptyStackException("Stos jest pusty");
            }
            return elements[rozmiar - 1];
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Metoda do zwiekszania rozmiaru stosu
    private void expandCapacity() {
        String[] newElements = new String[size() * 2];
        System.arraycopy(elements, 0, newElements, 0, size());
        elements = newElements;
    }

    // Metoda do sprawdzania rozmiaru stosu
    public int size() {
        return rozmiar;
    }

    // Własny wyjątek do obsługi pustego stosu
    private static class EmptyStackException extends Exception {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}
