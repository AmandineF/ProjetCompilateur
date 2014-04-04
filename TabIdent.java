/**
 * TabIdent est la classe permettant de gérer les hashmaps contenant les variables, constantes et fonctions
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
import java.util.*;

public class TabIdent {


	/**
	 * Hashmap contenant les variables globales et les fonctions
	 */
	private HashMap<String,Ident> globaux;
	/**
	 * Hashmap contenant les variables locales et les paramètres des fonctions
	 */
	private HashMap<String,Ident> locaux;


	/**
	 * Constructeurs des hashmaps
	 * @param taille : int
	 */
	public TabIdent(int taille){
		globaux = new HashMap<String, Ident>(taille);
		locaux = new HashMap<String, Ident>(taille);
	}

	/**
	 * Cherche variable locale, paramètres et constantes locales à partir de la clef passée en paramètre
	 * @param clef : String
	 * @return Ident : l'ident recherché
	 */
	public Ident chercheIdentLocaux(String clef){
		return locaux.get(clef);
	}

	/**
	 * Cherche variable globale, paramètres et constantes globales à partir de la clef passée en paramètre
	 * @param clef : String
	 * @return Ident : l'ident recherché
	 */
	public Ident chercheIdentGlobaux(String clef){
		return globaux.get(clef);
	}

	/**
	 * Cherche l'ident dans les deux hashmaps à partir de la clef passée en paramètre
	 * @param clef : String
	 * @return Ident : l'ident recherché
	 */
	public Ident chercheIdent(String clef) {
		Ident tmp = chercheIdentLocaux(clef); 
		if(tmp != null) {
			return tmp; 	
		} else {
			return chercheIdentGlobaux(clef);
		}
	}

	/**
	 * Retourne vrai si l'ident correspondant à la clef passée en paramètre existe dans l'une des hashmaps
	 * @param clef : String
	 * @return boolean
	 */
	public boolean existeIdent(String clef){
		return locaux.containsKey(clef) || globaux.containsKey(clef);
	}

	/**
	 * Place l'ident et la clef passée en paramètres dans la hashmap des locaux
	 * @param clef : String
	 * @param id : Ident
	 */
	public void rangeIdent(String clef, Ident id){
		locaux.put(clef, id);
	}

	/**
	 * Place l'ident et la clef passée en paramètres dans la hashmap des globaux
	 * @param clef : String
	 * @param id : Ident
	 */
	public void rangeIdentGlobaux(String clef, Ident id){
		globaux.put(clef, id);
	}

	/**
	 * Affiche les paramètres, variables et constantes sous une norme imposée
	 */
	public void show(){
		for (String key : globaux.keySet()) {
			globaux.get(key).show(key);
		}
		for (String key : locaux.keySet()) {
			locaux.get(key).show(key);
		}
	}

	/**
	 * Retourne le type de l'ident correspondant à la clef passer en paramètre
	 * @param k : String -> la clef pour trouver le type de l'ident correspondant
	 * @return String : le type de l'ident recherché
	 */
	public  String getTypeIdent(String k){
		return chercheIdent(k).getType();
	}

	/**
	 * Permet de vider la hashmap des locaux
	 */
	public void clearLocaux() {
		locaux.clear();
	}
}
