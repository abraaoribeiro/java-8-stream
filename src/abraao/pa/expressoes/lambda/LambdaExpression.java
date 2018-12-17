package abraao.pa.expressoes.lambda;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

interface Drawable {
	public void draw();
}

interface Sayable {
	public String say();
}

interface Printable {
	void print(String msg);
}

interface Addable {
	int add(int a, int b);
}

interface IAvarage {
	double avg(int[] array);
}

// @formatter:off
public class LambdaExpression {

	// Lambda Syntax
	// (lista-de-argumento) -> {corpo}

	// Lista de argumentos: pode estar vazia ou não vazia também.
	// Arrow-token: É usado para vincular a lista de argumentos e o corpo da expressão.
	// Corpo: contém expressões e instruções para a expressão lambda.

	public static void main(String[] args) {
		
		int width = 10;

		Drawable drawable = () -> {
			System.out.println("Drawing" + width);
		};

		drawable.draw();

		// Expressão Lambda sem paramentro
		Sayable sayable = () -> {
			return "Return something...";
		};
		sayable.say();

		// Expressão Lambda com parametro único

		Printable printable = (msg) -> System.out.println(msg);
		printable.print("Print message to console...");
		
		// Expressão Lambda com multiplos paramentros
		Addable addable = (a,b) -> (a + b);
		System.out.println(addable.add(50,60));
		
		// Expressão Lambda com multiplos paramentros e com tipagem
		Addable addable1 = (int a,int b) -> (a+b);
		System.out.println(addable1.add(100,200));
		
		// Expressão lambda com palavra-chave return
		Addable addable2 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(addable2.add(50,10));
		
		// Expressão lambda multiplas estruções
		IAvarage iavarage = (array) -> {
			double sum = 0;
			int arraySize = array.length;
			
		System.out.println("ArraySize " + arraySize);
		
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
			
		}
		System.out.println("Sum : "+ sum);
			
		return (sum/arraySize);
		
		};

		int [] withArray = {1,2,3,4,5};
		System.out.println(iavarage.avg(withArray));
		
		// Expressão lambda criando thread
		Runnable runnable = () -> System.out.println("Runnable exemplo com lambda");
		Thread thread = new Thread(runnable);
		thread.start();
		
	}	
			
	
		

}
