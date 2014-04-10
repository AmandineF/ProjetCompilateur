/**
 * IdFonction est la classe permettant de g�rer les fonctions
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
import java.util.List;
import java.util.LinkedList;

public class IdFonction extends Ident {


	/**
	 * Hashmap contenant le type des param�tres des fonctions
	 */
	private LinkedList<String> typeParam = new LinkedList();

	/**
	 * Entier indiquant le nombre de param�tre des fonctions
	 */
	private int nbParam;


	/**
	 * Constructeur d'IdFonction
	 * @param t : String contenant le type de retour de la fonction
	 * @param tp : LinkedList<String> contenant le type des param�tres
	 * @param rangParam : int contenant le rang du dernier param�tre
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




	public int getValue(){return 0;} //A oublier, cette m�thode n'est pas utile � IdFonction (sauf cas d'erreur)

	/**
	 * Retourne le nombre de param�tre de la fonction
	 * @return nbParam : int contenant le nombre de param�tre de la fonction
	 */

	public int nbParam(){
		return nbParam;
	}

	public String getTypeParam(int i){
		return typeParam.get(i);
	}
	/**
	 * Retourne la liste des types des param�tres de la fonction
	 * @return typeParam : String contenant la liste des types des param�tres de la fonction
	 */

	public LinkedList<String> typeParam(){
		return typeParam;
	}

	/** Affiche la fonction selon une norme
	 * @param s : String contenant la clef (le nom) de la fonction � afficher
	 */
	public void show(String s){
		Ecriture.ecrireString(s+" = FONCTION | resultat : "+this.type+" | les parametres : ");
		for(int i=0;i<nbParam;i++){Ecriture.ecrireString(this.typeParam.get(i) + " ");}
		Ecriture.ecrireString("\n");
	}

}

