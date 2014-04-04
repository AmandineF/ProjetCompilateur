/**
 * Declaration est la classe permettant de gérer la déclaration des variables, constantes et fonctions
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
	 * Hashmap contenant les variables locales et les paramètres des fonctions
	 */
	public TabIdent(int taille){
		globaux = new HashMap<String, Ident>(taille);
		locaux = new HashMap<String, Ident>(taille);
	}

	public Ident chercheIdentLocaux(String clef){
		return locaux.get(clef);
	}

	public Ident chercheIdentGlobaux(String clef){
		return globaux.get(clef);
	}

	public Ident chercheIdent(String clef) {
		Ident tmp = chercheIdentLocaux(clef); 
		if(tmp != null) {
			//débug
			//System.out.println("tmp "+clef+": "+tmp);
			return tmp; 	
		} else {
			//System.out.println("fonction "+clef+": "+chercheIdentGlobaux(clef));
			return chercheIdentGlobaux(clef);
		}
	}

	public boolean existeIdent(String clef){
		return locaux.containsKey(clef) || globaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id){
		locaux.put(clef, id);
	}

	public void rangeIdentGlobaux(String clef, Ident id){
		globaux.put(clef, id);
	}

	public void show(){
		for (String key : globaux.keySet()) {
			globaux.get(key).show(key);
		}
		for (String key : locaux.keySet()) {
			locaux.get(key).show(key);
		}
		
	}

	public  String getTypeIdent(String k){
		return chercheIdent(k).getType();
	}

	public void clearLocaux() {
		locaux.clear();
	}


}
