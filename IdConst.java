
public class IdConst extends Ident {
	
	//attributs
	private int value;
	
	//Constructeurs
	public IdConst(boolean b){
		if (b){
		value = 1;
		} else value =0;
		type = "boolean";
	}
	
	public IdConst(int i){
		value = i;
		type ="int";
	}
	
	public IdConst(String t, int i){
		if (t.startsWith("b")){
			type = "boolean";	
		}else type = "int";
		
		value = i;
	}
	//Méthodes
	
	//Récupération de la valeur
	public int getValue(){
		return value;
	}
	
	//Méthodes toString
	public void show(String s){
		if(type.equals("boolean")){
			Ecriture.ecrireString("CONSTANTE | "+ s +" | BOOLEEN | VALEUR ="+value);
		}else if(type.equals("int")){
			Ecriture.ecrireString("CONSTANTE | "+ s +" | ENTIER | VALEUR ="+value);
		}else{
			Ecriture.ecrireString("ERREUR SHOW");
		}
	}
}

