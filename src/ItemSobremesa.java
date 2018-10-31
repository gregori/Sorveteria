// ItemSobremesa.java - Superclasse abstrata para Item de Sobremesa
// Rodrigo Gregori, Out 2018
// Baseado em Suzanne Balik


/**
 * Superclasse abstrata para hierarquia de Item de Sobremesa
 * @author Rodrigo Gregori
 */
public abstract class ItemSobremesa {
  
  protected String nome;
  
/**
 * Construtor nulo para a classe ItemSobremesa
 */
  public ItemSobremesa() {
    this("");
  }
/**
 * Inicializa os dados de ItemSobremesa
 */   
  public ItemSobremesa(String nome) {
    if (nome.length() <= Sorveteria.TAMANHO_MAX_DO_NOME_DO_ITEM)
      this.nome = nome;
    else 
      this.nome = nome.substring(0,Sorveteria.TAMANHO_MAX_DO_NOME_DO_ITEM);
  }
/**
 * Retorna o nome do ItemSobremesa
 * @return nome do ItemSobremesa
 */  
  public final String getNome() {
    return nome;
  }
/**
 * Retorna o custo do ItemSobremesa
 * @return custo do ItemSobremesa
 */  
  public abstract int getCusto();

}
