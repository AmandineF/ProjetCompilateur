/**
 * 
 */

/**
 * @author bbignon
 *
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

	public int getValue() {

		return offset;
	}


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
