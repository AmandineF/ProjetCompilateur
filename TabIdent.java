import java.util.*;

public class TabIdent {

	//attributs

	private HashMap<String,Ident> table;


	//méthodes

	public TabIdent(int taille){
		table = new HashMap<String, Ident>(taille);
	}

	public Ident chercheIdent(String clef){
		return table.get(clef);
	}

	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id){
		table.put(clef, id);
	}

	public void show(){
		for (String key : table.keySet()) {
		    table.get(key).show(key);
		}
	}
}
