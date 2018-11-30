package abraao.stream.pa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamExemplo {
	private static List<Produto> produtosList = new ArrayList<Produto>();

	public static void main(String[] agrs) {

		produtosList.add(new Produto(1, "HP Laptop", 25000f));
		produtosList.add(new Produto(2, "Dell Laptop", 30000f));
		produtosList.add(new Produto(3, "Lenevo Laptop", 28000f));
		produtosList.add(new Produto(4, "Sony Laptop", 28000f));
		produtosList.add(new Produto(5, "Apple Laptop", 90000f));

		// totaldePreco
		double totalPreco = produtosList.stream().collect(Collectors.summingDouble(procuto -> procuto.getPreco()));
		System.out.println("Total: " + totalPreco);

		
		//Convertendo uma lista em em Set
		
		Set<Float> produtoPrecoList = produtosList.stream()
				.filter((produto)-> produto.getPreco() < 30000)
				.map((produto) -> produto.getPreco()).collect(Collectors.toSet());
		
		System.out.println("Lista de Precos dos Produtos menor que 30000: "+ produtoPrecoList);
		
		//Convertendo uma lista em em Map , mapeando por id e recebendo nome
		 Map<Integer, String> produtoPrecoMap = produtosList.stream()
				    .collect(Collectors.toMap(p -> p.getId(), p -> p.getNome()));
		System.out.println("Map "+produtoPrecoMap);
		
		//Usando o Method References
		List<Float> produtoPrecoLista2 = produtosList.stream()
				.filter(p -> p.getPreco() > 30000)
				.map(Produto::getPreco)
				.collect(Collectors.toList());
		
		System.out.println("Preço de produto maior que 30000: "+ produtoPrecoLista2);
		
		// Menor e maio Valor
		// Operação ternaria ? 1 : -1 segnifica se produto1.getPreco for > que produto2.getPreco entao 1 senão -1, ou seja se for true faça 1, se for false faca -1 
		Produto produtoA = produtosList.stream()
				.max((produto1, produto2) -> produto1.getPreco() > produto2.getPreco() ? 1 : -1)
				.get();
		System.out.println("Maior Valor : "+ produtoA.getPreco());
		
		Produto produtoB = produtosList.stream()
				.max((produto1, produto2) -> produto1.getPreco() < produto2.getPreco() ? 1 : -1)
				.get();
		System.out.println("Menor Valor : "+ produtoB.getPreco());
		
		filtroPorPreco();
	}
	private static void filtroPorPreco() {

		List<Float> produtoPrecoList = produtosList.stream().filter((produto) -> produto.getPreco() > 25000)
				.map((produto) -> produto.getPreco()).collect(Collectors.toList());

		produtoPrecoList.forEach((preco) -> System.out.println(preco));

	}

		

}
