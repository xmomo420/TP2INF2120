
/**
 * INF2120 E22 - TP2
 * Classe de tests PARTIELS pour tester la classe RondeChainee.
 * Ces tests ne testent pas tous les cas possibles des methodes de RondeChainee.
 * Il est de votre responsabilite de faire vos propres tests pour tester
 * completement la classe RondeChainee.
 * 
 * @author Melanie Lord
 * @version Ete 2022
 */
public class TestsPartiels {
   
   private static Ronde<Integer> r;
   
   /**
    * Executer la methode main pour executer les tests.
    * Les valeurs attendues sont affichees entre parentheses.
    * 
    * @param args - aucun
    */
   public static void main (String [] args) {
      
      int [] c1 = {6, 2, -23, 0};
      int [] c2 = {3, -3, 9, -2, 8, 2};
      Integer elem;
      afficherTitre("tests mixtes");
      
      try {
         System.out.print("CONSTRUCTION RONDE VIDE : ");
         r = new RondeChainee<>();
         ok();
         System.out.print("TEST EST VIDE (TRUE) : ");
         if (r.estVide()) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }

      try {
         System.out.print("INSERTION 1 À 10 (... 10 1 2 3 4 5 6 7 8 9 ...) : ");
         for (int i = 1 ; i <= 10 ; i++) {
            r.inserer(i);
         }
         if (r.toString().equals("... 10 1 2 3 4 5 6 7 8 9 ...")) {
            ok();
         } else {
            erreur();
         }
         System.out.print("TEST EST VIDE (FALSE) : ");
         if (!r.estVide()) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("RETIRER  (... 9 1 2 3 4 5 6 7 8 ...) : ");
         r.retirer();
         if (r.toString().equals("... 9 1 2 3 4 5 6 7 8 ...")) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("ELEMENT RETIRE A COMBINAISON [6, 2, -23, 0] (3) : ");
         elem = r.retirer(c1);
         
         if (elem.equals(3)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("RONDE APRES RETRAIT (... 2 4 5 6 7 8 9 1 ...) : ");
         if (r.toString().equals("... 2 4 5 6 7 8 9 1 ...")) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("ELEMENT RETIRE A COMBINAISON [3, -3, 9, -2, 8, 2] (4) : ");
         elem = r.retirer(c2);
         if (elem.equals(4)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("RONDE APRES RETRAIT (... 2 5 6 7 8 9 1 ...) : ");
         if (r.toString().equals("... 2 5 6 7 8 9 1 ...")) {
            ok();
         } else {
            erreur();
         }
         
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("CONTIENT 9 (TRUE) : ");
         if (r.contient(9)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("CONTIENT 10 (FALSE) : ");
         if (!r.contient(10)) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("INSERER 42 A COMBINAISON [6, 2, -23, 0] (... 42 2 5 6 7 8 9 1 ...) : ");
         r.inserer(c1, 42);
         if (r.toString().equals("... 42 2 5 6 7 8 9 1 ...")) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("INSERER 13 A COMBINAISON [3, -3, 9, -2, 8, 2] (... 13 5 6 7 8 9 1 42 2 ...) : ");
         r.inserer(c2, 13);
         if (r.toString().equals("... 13 5 6 7 8 9 1 42 2 ...")) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("TOURNER [6, 2, -23, 0] ET VERIFIER ELEM COURANT (7) : ");
         r.tourner(c1);
         if (r.getCourant().equals(7)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("TOURNER [3, -3, 9, -2, 8, 2] ET VERIFIER ELEM COURANT (6) : ");
         r.tourner(c2);
         if (r.getCourant().equals(6)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("POSITIONNER SUR 42 ET VERIFIER ELEM COURANT (42): ");
         r.positionner(42);
         if (r.getCourant().equals(42)) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("POSITIONNER SUR 0 ET VERIFIER ELEM COURANT (42): ");
         r.positionner(0);
         if (r.getCourant().equals(42)) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
      
      try {
         System.out.print("VIDER RONDE (... ) : ");
         r.vider();
         if (r.toString().equals("... ")) {
            ok();
         } else {
            erreur();
         }
         
         System.out.print("EST VIDE (TRUE) : ");
         if (r.estVide()) {
            ok();
         } else {
            erreur();
         }
      } catch (Exception e) {
         erreur(e);
      }
   }
   
   
   /*********************
    * METHODES PRIVEES
    *********************/

   private static void erreur() {
      System.out.println("ERREUR\n");
   }
   
   private static void erreur(Exception e) {
      System.out.println("ERREUR. Leve " + e.getClass().getSimpleName() + "\n");
   }
   
   private static void ok() {
      System.out.println("OK\n");
   }
   
   private static void afficherTitre (String s) {
      for (int i = 0 ; i < s.length() ; i++) {
         System.out.print("-");
      }
      System.out.println("\n" + s.toUpperCase());
      for (int i = 0 ; i < s.length() ; i++) {
         System.out.print("-");
      }
      System.out.println();
      
   }
}
