import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * Mantém uma lista de referências de ItemSobremesa.
 * Não há limites quanto ao número de ItemSobremesa na lista
 * @author Rodrigo Gregori
 *
 */
public class Checkout {
	private List<ItemSobremesa> itens;
	
	/**
	 * Cria uma instância com uma lista vazia de ItemSobremesa
	 */
	public Checkout() {
		itens = new ArrayList<>();
	}
	
	/**
	 * Limpa a lista para iniciar a compra de novos itens
	 */
	public void esvazia() {
		itens.clear();
	}
	
	/**
	 * Insere um ItemSobremesa ao final da lista de itens
	 * @param item Um item de sobremesa
	 */
	public void insereItem(ItemSobremesa item) {
		itens.add(item);
	}
	
	/**
	 * Retorna o número de itens na lista
	 * @return O número de itens
	 */
	public int numeroDeItens() {
		return itens.size();
	}
	
	/**
	 * Retorna o custo total dos itens, em centavos (sem impostos)
	 * @return O custo total dos itens
	 */
	public int custoTotal() {
		// TODO construir o código
		return 0;
	}
	
	/**
	 * Retorna o total dos impostos dos itens, em centavos
	 * @return O total dos impostos
	 */
	public int impostoTotal() {
		// TODO construir o código
		return 0;
	}
	
	/**
	 * Retorna uma string representando o cupom fiscal, da lista de itens atual
	 * @return uma string representando o cupom fiscal da lista de ItemSobremesa com o nome da loja, os itens comprados e o custo total, por exemplo:
	 * <pre>
	 *       Sorveteria M & M
     *     	 ----------------	
     *     
	 * Sorvete de Morango          1,45
	 * Sundae de Caramelo com
	 * Sorvete de Baunilha         1,55
	 * 1,33 g @ 0,89 /g
	 * Jujuba                      1,18
	 * 4 @ 3,99 /dz
	 * Cookies com gotas de choc   1,33
	 * 1,50 g @ 2,09 /g
	 * Bala puxa-puxa              3,14
	 * 3,00 g @ 1,09 /g
	 * Delicado                    3,27
	 * Imposto                     0,77
	 * Custo Total                12,69
	 * </pre>
	 */
	@Override
	public String toString() {
		// gera cabeçalho
		String saida = String.format("%24s\n", Sorveteria.NOME_LOJA);
		String linha = "";
		for (int i = 0; i < Sorveteria.NOME_LOJA.length(); i++)
			linha += "-";
		saida += String.format("%24s\n\n", linha);
		
		// gera itens
		for (ItemSobremesa item : itens) {
			saida += item.toString() + "\n";
		}
		saida += String.format("%-25s %6s\n", "Imposto", Sorveteria.centavos2ReaisECentavos(impostoTotal()));
		saida += String.format("%-25s %6s", "Custo Total", Sorveteria.centavos2ReaisECentavos(custoTotal()+impostoTotal()));
		return saida; 
	}
	
}
