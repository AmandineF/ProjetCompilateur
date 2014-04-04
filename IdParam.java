/**
 * IdParam est la classe permettant de g�rer les param�tres de fonctions
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

	//M�thodes

	/**	retourne l'offset du param�tre
	 * @return int : offset du param�tre
	 */
	
	public int getValue() {

		return offset;
	}


	/** Affiche le param�tre selon une norme
	 * @param s : String contenant la clef (le nom) du param�tre � afficher
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
