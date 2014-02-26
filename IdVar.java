
public class IdVar extends Ident {
	
	//Attributs
	private int offset;
	
	//Constructeur
	public IdVar(String t, int i){
		if (t.startsWith("b")){
			type = "boolean";	
		}else type = "int";
		
		offset = i;
	}
	
	//Méthodes
	
	//Récupération de l'offset
	public int getValue(){
		return offset;
	}
	
	//Affichage
	public void show(String s){
		
		if(type.equals("boolean")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | BOOLEEN | OFFSET ="+offset);
		}else if(type.equals("int")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | ENTIER | OFFSET ="+offset);
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}
		
	}//fin show
}
