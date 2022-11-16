
/** 
 * INF2120 E22 - TP2
 * Classe qui modelise un maillon avec possibilite de chainer vers la droite 
 * et de chainer vers la gauche. 
 * 
 * @author Melanie lord
 * @version Ete 2022
 * @param <T> le type generique de l'element dans le maillon.
 */
public class MaillonRonde <T> {
   
   private T element;              //l'element dans le maillon
   private MaillonRonde<T> gauche; //le maillon chaine a la gauche de ce maillon
   private MaillonRonde<T> droite; //le maillon chaine a la droite de ce maillon
   
   /**
    * Constructeur qui initialise l'element de ce maillon avec l'element donne.
    * Les maillons a gauche et a droite sont initialises a null.
    * @param element l'element pour initialiser l'element de ce maillon.
    */
   public MaillonRonde (T element) { this(element, null, null); }
   
   /**
    * Constructeur qui initialise l'element de ce maillon ainsi que le maillon
    * chaine a gauche, et le maillon chaine a droite. 
    * @param element l'element pour initialiser l'element de ce maillon 
    * @param gauche le maillon pour initialiser le maillon chaine a gauche de 
    *               ce maillon
    * @param droite le maillon pour initialiser le maillon chaine a droite de 
    *               ce maillon
    */
   public MaillonRonde (T element, MaillonRonde<T> gauche, MaillonRonde<T> droite) {
      this.element = element;
      this.gauche = gauche;
      this.droite = droite;
   }

   /**
    * Permet de consulter l'element de ce maillon.
    * @return l'element de ce maillon.
    */
   public T getElement() {
      return element;
   }

   /**
    * Permet de modifier l'element de ce maillon.
    * @param element le nouvel element.
    */
   public void setElement(T element) {
      this.element = element;
   }

   /**
    * Permet de consulter le maillon chaine a gauche de ce maillon.
    * @return le maillon chaine a gauche de ce maillon.
    */
   public MaillonRonde<T> getGauche() {
      return gauche;
   }

   /**
    * Permet de modifier le maillon chaine a gauche de ce maillon.
    * @param gauche le nouveau maillon chaine a gauche.
    */
   public void setGauche(MaillonRonde<T> gauche) {
      this.gauche = gauche;
   }

   /**
    * Permet de consulter le maillon chaine a droite de ce maillon.
    * @return le maillon chaine a droite de ce maillon.
    */
   public MaillonRonde<T> getDroite() {
      return droite;
   }

   /**
    * Permet de modifier le maillon chaine a droite de ce maillon.
    * @param droite le nouveau maillon chaine a droite.
    */
   public void setDroite(MaillonRonde<T> droite) {
      this.droite = droite;
   }

}
