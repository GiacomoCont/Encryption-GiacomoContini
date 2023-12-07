public class Main {
  public static void main(String[] args) {
    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto!");
    Matrice m = new Matrice("cappio");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Thread t = new Thread(v);
    t.start();
    try {
      t.join();
    } catch (InterruptedException e) {
      System.err.println("Errore durante l'esecuzione del thread");
    }
    Vigenere v1 = new Vigenere(13, 25, 13, 25, m);
    Thread t1 = new Thread(v1);
    t1.start();
    m.stampa();
  }
}