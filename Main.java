import java.util.Scanner;

/* 
1) Creare quattro thread che popolano i quattro quadranti
2) Popolare la matrice di Vigenere con i quattro quadranti
3) Chiedere all'utente di inserire la chiave in input
4) Chiedere all'utente di inserire una frase da cifrare
5) Stampare il messaggio cifrato con la chiave fornita in precedenza
*/

public class Main {
  public static void main(String[] args) {
    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto!");
    
    Scanner s = new Scanner(System.in);
    System.out.println("Inserisci la chiave di cifratura: ");
    String chiave = s.nextLine();

    Scanner input = new Scanner(System.in);
    System.out.println("Inserisci la frase da cifrare: ");
    String frase = input.nextLine();
    
    Matrice m = new Matrice(chiave);
    Vigenere v1 = new Vigenere(0, 12, 0, 12, m);
    Thread t1 = new Thread(v1);
    Vigenere v2 = new Vigenere(12, 26, 0, 12, m);
    Thread t2 = new Thread(v2);
    Vigenere v3 = new Vigenere(0, 12, 12, 26, m);
    Thread t3 = new Thread(v3);
    Vigenere v4 = new Vigenere(12, 26, 12, 26, m);
    Thread t4 = new Thread(v4);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
    } catch (InterruptedException e) {
      System.err.println("Errore durante l'esecuzione del thread");
    }
    m.stampa();

    try {
      String fraseCifrata = m.cifra(frase);
      System.out.println("Il messaggio cifrato è: " + fraseCifrata);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Errore di indice nella matrice");
    }
  }
}