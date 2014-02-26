
public class IdVar extends Ident {
	
	//Attributs
	private int offset;
	
	//Constructeur
	public IdVar(String t, int i){
		if (t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";
		
		offset = i;
	}
	
	//Méthodes
	
	//Récupération de l'offset
	public int getValue(){
		return offset;
	}
	
	//Affichage
	public void show(String s){
		
<<<<<<< HEAD
		if(type.equals("boolean")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | BOOLEEN | OFFSET ="+offset+"\n");
		}else if(type.equals("int")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | ENTIER | OFFSET ="+offset+"\n");
=======
		if(type.equals("BOOLEEN")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | BOOLEEN | OFFSET ="+offset);
		}else if(type.equals("ENTIER")){
			Ecriture.ecrireString("VARIABLE | "+ s +" | ENTIER | OFFSET ="+offset);
>>>>>>> 484a5c537b0025d9639722c58bb976f2d974c6f4
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}
		
	}//fin show
}
