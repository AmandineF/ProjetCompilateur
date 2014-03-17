
public class IdConst extends Ident {
	
	//attributs
	private int value;
	
	//Constructeurs
	public IdConst(boolean b){
		if (b){
		value = 1;
		} else value =0;
		type = "BOOLEEN";
	}
	
	public IdConst(int i){
		value = i;
		type ="ENTIER";
	}
	
	public IdConst(String t, int i){
		if (t.startsWith("b") || t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";
		
		value = i;
	}
	//Méthodes
	
	//Récupération de la valeur
	public int getValue(){
		return value;
	}
	
	//Méthodes toString
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

