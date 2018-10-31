// TestCheckout.java - método principal para testar a classe Checkout
//                         e a hierarquia de ItemSobremesa
// Rodrigo Gregori, out 2018 
// Baseado no trabalho de Suzanne Balik

public class TestCheckout {

  public static void main(String[] args) {
  
    Checkout checkout = new Checkout();
    
    checkout.insereItem(new Doce("Caramelo de manteiga de amendoim", 0.35, 399));
    checkout.insereItem(new Sorvete("Sorvete de Baunilha",105));
    checkout.insereItem(new Sundae("Sorvete de flocos",145, "Calda de caramelo", 50));
    checkout.insereItem(new Cookie("Cookies com passas e aveia", 4, 399));
    
    System.out.println("\nNúmero de ítens: " + checkout.numeroDeItens() + "\n");
    System.out.println("\nCusto total: " + checkout.custoTotal() + "\n");
    System.out.println("\nTotal de impostos: " + checkout.impostoTotal() + "\n");
    System.out.println("\nCusto + Impostos: " + (checkout.custoTotal() + checkout.impostoTotal()) + "\n");
    System.out.println(checkout);
    
    checkout.esvazia();
    
    checkout.insereItem(new Sorvete("Sorvete de Morango",145));
    checkout.insereItem(new Sundae("Sorvete de Baunilha",105, "Caramelo", 50));
    checkout.insereItem(new Doce("Jujuba", 0.83, 89));
    checkout.insereItem(new Cookie("Cookies com chocolate", 4, 399));
    checkout.insereItem(new Doce("Bala puxa-puxa", 0.5, 209));
    checkout.insereItem(new Doce("Delicado",1.2, 109));
    
    System.out.println("\nNúmero de ítens: " + checkout.numeroDeItens() + "\n");
    System.out.println("\nCusto total: " + checkout.custoTotal() + "\n");
    System.out.println("\nTotal de impostos: " + checkout.impostoTotal() + "\n");
    System.out.println("\nCusto + Impostos: " + (checkout.custoTotal() + checkout.impostoTotal()) + "\n");
    System.out.println(checkout);
  }
}
