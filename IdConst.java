/**
 * IdConst est la classe gérant les constantes lues
 * Hérite de la classe Ident
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
public class IdConst extends Ident {

	//attributs
	private int value;

	//Constructeurs

	/**
	 * Constructeur attribuant le type et la valeur du booléen
	 * @param b : booléen lu
	 */
	public IdConst(boolean b){
		if (b){
			value = 1;
		} else value =0;
		type = "BOOLEEN";
	}

	/**
	 * Constructeur attribuant le type et la valeur de l'entier
	 * @param i : entier lu
	 */
	public IdConst(int i){
		value = i;
		type ="ENTIER";
	}

	/**
	 * Constructeur attribuant le type et la valeur en fonction de ce qui est lu.
	 * @param t : type
	 * @param i : entier lu
	 */
	public IdConst(String t, int i){
		if (t.startsWith("b") || t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";

		value = i;
	}
	//Méthodes

	/**
	 * Récupère la valeur de la constante
	 * @return int : value -> valeur de la constante
	 */
	public int getValue(){
		return value;
	}

	/**
	 * Affiche la constante selon une norme imposée
	 * @param s : nom de la constante
	 */
	public void show(String s){
		if(type.equals("BOOLEEN")){
			Ecriture.ecrireString("CONSTANTE | "+ s +" | BOOLEEN | VALEUR ="+value+"\n");
		}else if(type.equals("ENTIER")){
			Ecriture.ecrireString("CONSTANTE | "+ s +" | ENTIER | VALEUR ="+value+"\n");
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}
	}
}

