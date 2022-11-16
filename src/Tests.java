public class Tests {

    public static void main(String[] args) {
    RondeChainee<Integer> r = new RondeChainee<>();
    r.inserer(23);
    r.inserer(28);
    r.inserer(-9);
    r.inserer(3);
    r.inserer(0);
    r.inserer(945);
        System.out.println(r);
        r.retirer();
        System.out.println(r);
        int [] tab = {6, 2, -23, 0};
        //r.tourner(tab);
        //System.out.println(r);
        //System.out.println(r.getCourant());
    }
/*
    ---------------

------------
TESTS MIXTES
------------
CONSTRUCTION RONDE VIDE : OK

TEST EST VIDE (TRUE) : OK

INSERTION 1 À 10 (... 10 1 2 3 4 5 6 7 8 9 ...) : OK

TEST EST VIDE (FALSE) : OK

RETIRER  (... 9 1 2 3 4 5 6 7 8 ...) : ERREUR

ELEMENT RETIRE A COMBINAISON [6, 2, -23, 0] (3) : ERREUR

RONDE APRES RETRAIT (... 2 4 5 6 7 8 9 1 ...) : ERREUR

ELEMENT RETIRE A COMBINAISON [3, -3, 9, -2, 8, 2] (4) : ERREUR

RONDE APRES RETRAIT (... 2 5 6 7 8 9 1 ...) : ERREUR

CONTIENT 9 (TRUE) : OK

CONTIENT 10 (FALSE) : OK

INSERER 42 A COMBINAISON [6, 2, -23, 0] (... 42 2 5 6 7 8 9 1 ...) : ERREUR

INSERER 13 A COMBINAISON [3, -3, 9, -2, 8, 2] (... 13 5 6 7 8 9 1 42 2 ...) : ERREUR

TOURNER [6, 2, -23, 0] ET VERIFIER ELEM COURANT (7) : ERREUR

TOURNER [3, -3, 9, -2, 8, 2] ET VERIFIER ELEM COURANT (6) : ERREUR

POSITIONNER SUR 42 ET VERIFIER ELEM COURANT (42): OK

POSITIONNER SUR 0 ET VERIFIER ELEM COURANT (42): OK

VIDER RONDE (... ) : OK

EST VIDE (TRUE) : OK


Process finished with exit code 0

------------------------

 */



}
