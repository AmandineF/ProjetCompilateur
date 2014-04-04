/**
 * IdParam est la classe permettant de gérer les paramètres de fonctions
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
public class IdParam extends Ident {

	//Attributs
	private int offset;

	//Constructeur
	/**
	 * Constructeur attribuant le type et la valeur en fonction de ce qui est lu.
	 * @param t : type
	 * @param i : entier lu
	 */
	public IdParam(String t, int i){
		if (t.startsWith("b") || t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";

		offset = i;
	}

	//Méthodes

	/**	retourne l'offset du paramètre
	 * @return int : offset du paramètre
	 */
	
	public int getValue() {

		return offset;
	}


	/** Affiche le paramètre selon une norme
	 * @param s : String contenant la clef (le nom) du paramètre à afficher
	 */
	public void show(String s) {
		if(type.equals("BOOLEEN")){
			Ecriture.ecrireString("PARAMETRE | "+ s +" | BOOLEEN | OFFSET ="+offset+"\n");
		}else if(type.equals("ENTIER")){
			Ecriture.ecrireString("PARAMETRE | "+ s +" | ENTIER | OFFSET ="+offset+"\n");
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}

	}

}
