
public class IdFonction extends Ident {
	
	//attributs
	private String[] typeParam = new String[10];
	
	//Constructeurs

	
	public IdFonction(String t, String[] tp ){
		if (t.startsWith("b") || t.startsWith("B")){
			type = "BOOLEEN";	
		}else type = "ENTIER";
		
		for(i=0;i<10;i++){
			if (tp[i].startsWith("b") || tp[i].startsWith("B")){
				this.typeParam[i] = "BOOLEEN";	
			}else this.typeParam[i] = "ENTIER";
		}
		
		
	}
	//M�thodes
	
	//R�cup�ration de la valeur

	
	//M�thodes toString
	public void show( String s ){
		
	Ecriture.ecrireString(s+" = FONCTION | resultat : "+this.type+" | les parametres : + ACOMPLETER"
		);
	}
		
			
}

