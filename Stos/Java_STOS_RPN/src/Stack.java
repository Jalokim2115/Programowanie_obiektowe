public class Stack {
	private String [] elements;
	int rozmiar = 0;
	public void push(String element){
		elements.add(element);
		rozmiar +=1;
	}
	public String pop(){
		if rozmiar < 1{
			return"stos jest pusty";
		}else{
		return elements[rozmiar];
		remove(elements[rozmiar]);
		rozmiar -= 1;
		}
	}

	public String peek(){
		return elements[rozmiar];
	}
}
