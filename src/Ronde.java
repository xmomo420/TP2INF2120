
/**
 * INF2120 E22 - TP2
 * Une ronde est une sequence d'elements sans debut ni fin, mais qui possede 
 * un element courant (qui pointe sur un des elements de la ronde) en tout temps, 
 * lorsque celle-ci n'est pas vide. Lorsque la ronde est vide (ne contient aucun 
 * element), l'element courant est null.
 * 
 * On peut modifier l'element courant d'une ronde en tournant vers la gauche ou 
 * vers la droite dans la ronde, c'est-a-dire en parcourant ses elements vers la 
 * gauche ou vers la droite.
 * 
 * Un parcours (dans la ronde) est donne par un nombre entier :       
 *    - un entier n positif : indque de parcourir n elements vers la droite.
 *    - un entier n negatif : indique de parcourir n elements vers la gauche.
 *    - un entier egal a 0  : indique de ne parcourir aucun element
 * 
 * Une combinaison est une suite de parcours a effectuer dans la ronde, donnee
 * dans un tableau de nombres entiers. Par exemple, la combinaison donnee par 
 * le tableau [3, -7, 23] specifie le parcours de 3 elements vers la droite, 
 * de 7 elements vers la gauche, suivi de 23 elements vers la droite. 
 * 
 * Une ronde n'accepte pas les elements null, ni les doublons.
 * 
 * Insertion : L'ajout d'un element dans une ronde se fait toujours a DROITE
 *             de l'element courant.
 * 
 * Retrait : Le retrait d'un element est toujours le retrait de l'element courant.
 *           Apres un retrait, l'element courant pointe sur l'element qui etait
 *           a sa GAUCHE, avant son retrait ou devient null si la ronde ne
 *           contenait qu'un seul element avant le retrait.
 * 
 * Dans une ronde non vide, il est possible de tourner indefiniment vers la 
 * gauche ou la droite.
 * 
 * @author Melanie Lord
 * @version Ete 2022
 * @param <T> le type generique des elements de la ronde.
 */
public interface Ronde<T> {
   
   /**
    * Teste si la ronde contient ou non des elements.
    * @return true si la ronde ne contient aucun element, false sinon
    */
   boolean estVide ();
   
   /**
    * Teste si element est present dans la ronde sans modifier l'element courant.
    * C'est la methode equals des elements dans la ronde qui est utilisee pour 
    * tester l'existence de l'element donne.
    * @param element l'element dont on veut determiner s'il est dans la ronde.
    * @return true si cette ronde contient element, false sinon.
    */
   boolean contient (T element);
   
   /**
    * Retire tous les elements de cette ronde. 
    * Apres l'appel de cette methode, estVide() retourne true.
    */
   void vider();
   
   /**
    * Modifie l'element courant par un element de la ronde egal a l'element donne
    * en parametre, s'il en existe un dans la ronde. Sinon, l'element courant  
    * demeure inchange. C'est la methode equals des elements dans la ronde qui est 
    * utilisee pour tester l'existence de l'element donne.
    * @param element l'element qu'on cherche dans cette ronde pour y positionner
    *                l'element courant de cette ronde.
    */
   void positionner(T element);
   
   /**
    * Deplace le pointeur de l'element courant en parcourant les elements de la 
    * ronde vers la gauche ou vers la droite, selon la combinaison donnee.
    * Si la ronde est vide ou si la combinaison est un tableau vide, l'element 
    * courant de cette ronde reste inchange.
    * 
    * @param combinaison un tableau de nombres entiers dont chaque nombre indique 
    *                    un parcours gauche ou droit a effectuer dans la ronde.
    *                    ANT : combinaison n'est pas null.
    * @return l'element courant apres le ou les parcours effectues selon la 
    *         combinaison donnee.
    */
   T tourner (int [] combinaison);
   
   /**
    * Insere l'element donne dans la ronde, A DROITE de l'element courant de cette
    * ronde. Apres une insertion, l'element courant devient l'element insere.
    * 
    * Si la ronde est vide avant l'insertion, l'element insere devient l'element 
    * courant de cette ronde.
    * 
    * Si element est null ou s'il est deja present dans la ronde, il n'est pas 
    * insere et l'element courant de la ronde reste inchange.
    * 
    * @param element l'element a inserer dans la ronde.
    * @return true si l'element a ete insere, faux sinon.
    */
   boolean inserer (T element);
   
   /**
    * Insere l'element donne dans la ronde, A DROITE de l'element courant, APRES
    * avoir positionner l'element courant de cette ronde selon la combinaison 
    * donnee. Apres l'insertion, l'element courant de cette ronde pointe sur 
    * l'element insere.
    * 
    * Si element est null ou s'il est deja present dans la ronde, il n'est pas 
    * insere et l'element courant de la ronde reste inchange.
    * 
    * Si la combinaison est un tableau vide ou si cette ronde est vide avant 
    * l'insertion, cette methode se comporte comme la methode 
    * boolean inserer(T element) en ne tenant pas compte de la combinaison
    * donnee.
    * 
    * @param combinaison un tableau de nombres entiers dont chaque nombre indique 
    *                    un parcours gauche ou droit a effectuer dans la ronde.
    *                    ANTECEDENT : combinaison n'est pas null.
    * @param element l'element a inserer dans la ronde.
    * @return true si l'element a ete insere, faux sinon.
    */
   boolean inserer (int [] combinaison, T element);
   
   /**
    * Retire l'element courant de cette ronde.
    * Apres un retrait, l'element courant de cette ronde pointe sur l'element 
    * qui etait a sa GAUCHE avant le retrait, ou devient null si la ronde ne 
    * contenait qu'un seul element avant le retrait.
    * 
    * @return l'element retire
    * @throws ExceptionRondeVide si cette ronde est vide avant le retrait.
    */
   T retirer ();
   
   /**
    * Retire l'element courant de cette ronde, APRES avoir effectue 
    * le ou les parcours indiques par la combinaison donnee.
    * Apres un retrait, l'element courant de cette ronde pointe sur l'element 
    * qui etait a sa GAUCHE avant le retrait. Lorsque la ronde ne contient qu'un 
    * seul element avant le retrait, l'element courant est null apres le retrait.
    * 
    * Si la combinaison donnee est un tableau vide, l'element a retirer est 
    * l'element courant.
    * 
    * @param combinaison un tableau de nombres entiers dont chaque nombre indique 
    *                    un parcours gauche ou droit a effectuer dans la ronde.
    *                    ANT : combinaison n'est pas null.
    * 
    * @return l'element retire
    * @throws ExceptionRondeVide si cette ronde est vide avant le retrait.
    */
   T retirer (int [] combinaison);
   
   /**
    * Permet de consulter l'element courant de cette ronde.
    * @return l'element courant de cette ronde sans le modifier.
    * @throws ExceptionRondeVide si cette ronde est vide.
    */
   T getCourant();

}
