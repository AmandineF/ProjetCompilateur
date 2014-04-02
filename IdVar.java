/**
 * IdVar est la classe gérant les variables lues
 * Hérite de la classe Ident
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
public class IdVar extends Ident {

	//Attributs
	private int offset;

	//Constructeur
	/**
	 * Constructeur attribuant le type et la valeur en fonction de ce qui est lu.
	 * @param t : type
	 * @param i : entier lu
	 */
	public IdVar(String t, int i){
		if (t.startsWith("b") || t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";

		offset = i;
	}

	//Méthodes

	/**
	 * Récupère l'offset
	 * @return int : offset
	 */
	public int getValue(){
		return offset;
	}

	/**
	 * Affiche la variable selon une norme imposée
	 * @param s : nom de la variable
	 */
	public void show(String s){
		if(type.equals("BOOLEEN")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | BOOLEEN | OFFSET ="+offset+"\n");
		}else if(type.equals("ENTIER")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | ENTIER | OFFSET ="+offset+"\n");
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}

	}
}
