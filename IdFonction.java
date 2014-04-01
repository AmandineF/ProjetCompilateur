public class IdFonction extends Ident {
	
	//attributs
	private Declaration declaration = new Declaration();
	private String[] typeParam = new String[100];
	
	//Constructeurs
	public IdFonction(String t, String[] tp){
		if (t.startsWith("b") || t.startsWith("B")){
			this.type = "BOOLEEN";	
		}else this.type = "ENTIER";
		
		for(int i=0;i<declaration.getNbParam();i++){
			if (tp[i].startsWith("b") || tp[i].startsWith("B")){
				this.typeParam[i] = "BOOLEEN";	
			}else this.typeParam[i] = "ENTIER";
		}
	}
	
	//Méthodes
	
	//Récupération de la valeur
	public int getValue(){return 0;} //A VOIR
	//Méthodes toString
	public void show(String s){		
		Ecriture.ecrireString(s+" = FONCTION | resultat : "+this.type+" | les parametres : ");
		for(int i=0;i<declaration.getNbParam();i++){Ecriture.ecrireString(this.typeParam[i] + " ");}
		Ecriture.ecrireString("\n");
	}
				
}

