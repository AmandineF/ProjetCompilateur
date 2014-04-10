/**
 * IdFonction est la classe permettant de gérer les fonctions
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
import java.util.List;
import java.util.LinkedList;

public class IdFonction extends Ident {


	/**
	 * Hashmap contenant le type des paramètres des fonctions
	 */
	private LinkedList<String> typeParam = new LinkedList();

	/**
	 * Entier indiquant le nombre de paramètre des fonctions
	 */
	private int nbParam;


	/**
	 * Constructeur d'IdFonction
	 * @param t : String contenant le type de retour de la fonction
	 * @param tp : LinkedList<String> contenant le type des paramètres
	 * @param rangParam : int contenant le rang du dernier paramètre
	 */
	public IdFonction(String t, LinkedList<String> tp, int rangParam){
		if (t.startsWith("b") || t.startsWith("B")){
			this.type = "BOOLEEN";	
		}else this.type = "ENTIER";
		this.nbParam = rangParam+1;
		for(int i=0;i<nbParam;i++){
			if (tp.get(i).startsWith("b") || tp.get(i).startsWith("B")){
				typeParam.addLast("BOOLEEN");	
			}else typeParam.addLast("ENTIER");
		}
	}




	public int getValue(){return 0;} //A oublier, cette méthode n'est pas utile à IdFonction (sauf cas d'erreur)

	/**
	 * Retourne le nombre de paramètre de la fonction
	 * @return nbParam : int contenant le nombre de paramètre de la fonction
	 */

	public int nbParam(){
		return nbParam;
	}

	public String getTypeParam(int i){
		return typeParam.get(i);
	}
	/**
	 * Retourne la liste des types des paramètres de la fonction
	 * @return typeParam : String contenant la liste des types des paramètres de la fonction
	 */

	public LinkedList<String> typeParam(){
		return typeParam;
	}

	/** Affiche la fonction selon une norme
	 * @param s : String contenant la clef (le nom) de la fonction à afficher
	 */
	public void show(String s){
		Ecriture.ecrireString(s+" = FONCTION | resultat : "+this.type+" | les parametres : ");
		for(int i=0;i<nbParam;i++){Ecriture.ecrireString(this.typeParam.get(i) + " ");}
		Ecriture.ecrireString("\n");
	}

}

