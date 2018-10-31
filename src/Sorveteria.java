
public class Sorveteria {
	  public final static double IMPOSTO = 6.5;        // 6.5%
	  public final static String NOME_LOJA = "Sorveteria M & M";
	  public final static int TAMANHO_MAX_DO_NOME_DO_ITEM = 25;
	  public final static int LARGURA_DO_ITEM = 6;
	  
	  public static String centavos2ReaisECentavos(int centavos) {
	 
	    String s = "";
	     
	    if (centavos < 0) {
	      s += "-";
	      centavos *= -1;
	    }
	    
	    int reais = centavos/100;
	    centavos = centavos % 100;
	    
	    if (reais == 0)
	    	s += "0";
	    else if (reais > 0)
	      s += reais;
	    
	    s +=",";
	      
	    if (centavos < 10)
	      s += "0";
	      
	    s += centavos;
	    return s;
	  } 
}
