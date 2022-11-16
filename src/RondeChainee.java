
/**
 * Classe qui implemente l'interface Ronde<T> et modelise une chaine de
 * MaillonRonde.
 * Contient l'implementation de toutes les methodes de l'interface Ronde<T>
 * @author Mohamed Bendourou, BENM23109703, groupe : 20
 * @version 29 juillet 2022
 */


public class RondeChainee<T> implements Ronde<T> {

    //Attribut d'instance
    private MaillonRonde<T> courant;

    //Implementation des methodes de l'interface Ronde<T>
    /**
     * Teste si la ronde contient ou non des elements.
     * @return true si la ronde ne contient aucun element, false sinon
     */
    @Override
    public boolean estVide() {
        return courant == null;
    }

    /**
     * Teste si element est present dans la ronde sans modifier l'element courant.
     * C'est la methode equals des elements dans la ronde qui est utilisee pour
     * tester l'existence de l'element donne.
     * @param element l'element dont on veut determiner s'il est dans la ronde.
     * @return true si cette ronde contient element, false sinon.
     */
    @Override
    public boolean contient(T element) {
        if (element == null || estVide()) {
            return false;
        } else {
            boolean estEgal = false;
            boolean continu = true;
            MaillonRonde<T> aGaucheAuDebut = courant.getGauche();
            while (continu && !estEgal) {
                continu = getCourant() != aGaucheAuDebut.getElement();
                estEgal = element.equals(getCourant());
                courant = courant.getDroite();
            }
            courant = aGaucheAuDebut.getDroite();
            return estEgal;
        }
    }

    /**
     * Retire tous les elements de cette ronde.
     * Apres l'appel de cette methode, estVide() retourne true.
     */
    @Override
    public void vider() {
        courant = null;
    }

    /**
     * Modifie l'element courant par un element de la ronde egal a l'element donne
     * en parametre, s'il en existe un dans la ronde. Sinon, l'element courant
     * demeure inchange. C'est la methode equals des elements dans la ronde qui est
     * utilisee pour tester l'existence de l'element donne.
     *
     * @param element l'element qu'on cherche dans cette ronde pour y positionner
     *                l'element courant de cette ronde.
     */
    @Override
    public void positionner(T element) {
        if (contient(element)) {
            while (!getCourant().equals(element)) {
                courant = courant.getDroite();
            }
        }
    }

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
     * combinaison donnee.
     */
    @Override
    public T tourner(int[] combinaison) {
        if (!estVide() && combinaison != null && combinaison.length > 0) {
            int sommeCombinaison = somme(combinaison);
            boolean estPositif = sommeCombinaison > 0;
            int i = 0;
            while (i < Math.abs(sommeCombinaison)) {
                if (estPositif) {
                    courant = courant.getDroite();
                } else
                    courant = courant.getGauche();
                i++;
            }
        }
        return getCourant();
    }


    /**
     * Calcul la somme d'un tableau d'entier qui correspond a une combinaison.
     * @param combinaison le tableau dont on veut calculer la somme de ses
     * elements.
     * @return la somme des element du tableau donnes en parametre.
     */
    private static int somme (int[] combinaison) {
        int somme = 0;
        for (int i : combinaison) {
            somme += i;
        }
        return somme;
    }

    /**
     * Insere l'element donne dans la ronde, A DROITE de l'element courant de cette
     * ronde. Apres une insertion, l'element courant devient l'element insere.
     * <p>
     * Si la ronde est vide avant l'insertion, l'element insere devient l'element
     * courant de cette ronde.
     * <p>
     * Si element est null ou s'il est deja present dans la ronde, il n'est pas
     * insere et l'element courant de la ronde reste inchange.
     *
     * @param element l'element a inserer dans la ronde.
     * @return true si l'element a ete insere, faux sinon.
     */
    @Override
    public boolean inserer(T element) {
        if (element == null || contient(element)) {
            return false;
        } else {
            if (estVide()) {
                courant = new MaillonRonde<>(element);
                courant.setGauche(courant);
                courant.setDroite(courant);

            } else {
                MaillonRonde<T> maillonAAjouter = new MaillonRonde<>(element,
                        courant,courant.getDroite());
                courant.getDroite().setGauche(maillonAAjouter);
                courant.setDroite(maillonAAjouter);
                courant = courant.getDroite();
            }
            return true;
        }

    }

    /**
     * Insere l'element donne dans la ronde, A DROITE de l'element courant, APRES
     * avoir positionner l'element courant de cette ronde selon la combinaison
     * donnee. Apres l'insertion, l'element courant de cette ronde pointe sur
     * l'element insere.
     * <p>
     * Si element est null ou s'il est deja present dans la ronde, il n'est pas
     * insere et l'element courant de la ronde reste inchange.
     * <p>
     * Si la combinaison est un tableau vide ou si cette ronde est vide avant
     * l'insertion, cette methode se comporte comme la methode
     * boolean inserer(T element) en ne tenant pas compte de la combinaison
     * donnee.
     *
     * @param combinaison un tableau de nombres entiers dont chaque nombre indique
     *                    un parcours gauche ou droit a effectuer dans la ronde.
     *                    ANTECEDENT : combinaison n'est pas null.
     * @param element     l'element a inserer dans la ronde.
     * @return true si l'element a ete insere, faux sinon.
     */
    @Override
    public boolean inserer(int[] combinaison, T element) {
        boolean insereAvecSucces;
        if (!estVide() && combinaison.length != 0) {
            tourner(combinaison);
        }
        insereAvecSucces = inserer(element);
        return insereAvecSucces;
    }

    /**
     * Retire l'element courant de cette ronde.
     * Apres un retrait, l'element courant de cette ronde pointe sur l'element
     * qui etait a sa GAUCHE avant le retrait, ou devient null si la ronde ne
     * contenait qu'un seul element avant le retrait.
     *
     * @return l'element retire
     * @throws ExceptionRondeVide si cette ronde est vide avant le retrait.
     */
    @Override
    public T retirer() throws ExceptionRondeVide {
        if (estVide()) {
            throw new ExceptionRondeVide();
        }
        T element = getCourant();
        courant.getGauche().setDroite(courant.getDroite());
        courant.getDroite().setGauche(courant.getGauche());
        courant = courant.getGauche();
        return element;
    }

    /**
     * Retire l'element courant de cette ronde, APRES avoir effectue
     * le ou les parcours indiques par la combinaison donnee.
     * Apres un retrait, l'element courant de cette ronde pointe sur l'element
     * qui etait a sa GAUCHE avant le retrait. Lorsque la ronde ne contient qu'un
     * seul element avant le retrait, l'element courant est null apres le retrait.
     * <p>
     * Si la combinaison donnee est un tableau vide, l'element a retirer est
     * l'element courant.
     *
     * @param combinaison un tableau de nombres entiers dont chaque nombre indique
     *                    un parcours gauche ou droit a effectuer dans la ronde.
     *                    ANT : combinaison n'est pas null.
     * @return l'element retire
     * @throws ExceptionRondeVide si cette ronde est vide avant le retrait.
     */
    @Override
    public T retirer(int[] combinaison) throws ExceptionRondeVide {
        if (estVide()) {
            throw new ExceptionRondeVide();
        }
        tourner(combinaison);
        return retirer();
    }

    /**
     * Permet de consulter l'element courant de cette ronde.
     * @return l'element courant de cette ronde sans le modifier.
     * @throws ExceptionRondeVide si cette ronde est vide.
     */
    @Override
    public T getCourant() throws ExceptionRondeVide  {
        if (estVide()) {
            throw new ExceptionRondeVide();
        }
        return courant.getElement();
    }

    /**
     * Construit une representation de cette ronde sous forme de chaine de
     * caracteres. La chaine construite debute avec "... " suivi de tous les
     * elements de la ronde parcourus vers la droite, a partir de l'element
     * courant, separes par des espaces. La chaine se termine par "...".
     *
     * Une ronde vide est representee par "... "
     *
     * Exemple : si on insere dans une ronde vide les elements 1, 2, 3, 4
     *           (apres la derniere insertion, courant pointe sur 4) =>
     *           la chaine retournee sera "... 4 1 2 3 ..."
     *
     * @return une representation de cette ronde sous forme de chaine de
     *         caracteres
     */
    @Override
    public String toString() {
        MaillonRonde<T> tmp = courant;
        String s = "... ";
        if (courant != null) {
            do {
                s = s + tmp.getElement() + " ";
                tmp = tmp.getDroite();
            } while (tmp != courant);
            s = s + "...";
        }
        return s;
    }


}
