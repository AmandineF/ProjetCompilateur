import java.util.*;

public class TabIdent {

	//attributs

	private HashMap<String,Ident> globaux;
	private HashMap<String,Ident> locaux;



	//méthodes

	public TabIdent(int taille){
		globaux = new HashMap<String, Ident>(taille);
		locaux = new HashMap<String, Ident>(taille);
	}

	public Ident chercheIdent(String clef){
		return locaux.get(clef);
	}

	public boolean existeIdent(String clef){
		return locaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id){
		locaux.put(clef, id);
	}
	
	public void rangeIdentGlobaux(String clef, Ident id){
		globaux.put(clef, id);
	}

	public void show(){
		for (String key : locaux.keySet()) {
		    locaux.get(key).show(key);
		}
		for (String key : globaux.keySet()) {
		    globaux.get(key).show(key);
		}
	}
	
	public  String getTypeIdent(String k){
		return chercheIdent(k).getType();
	}
	
	public void clearLocaux() {
		locaux.clear();
	}
	
		
}
