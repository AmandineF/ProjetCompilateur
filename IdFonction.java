import java.util.List;
import java.util.LinkedList;

public class IdFonction extends Ident {
	
	//attributs
	//private Declaration declaration = new Declaration();
	private LinkedList<String> typeParam = new LinkedList();
	private int nbParam;
	
	//Constructeurs
	public IdFonction(String t, LinkedList<String> tp, int rangParam){
		if (t.startsWith("b") || t.startsWith("B")){
			this.type = "BOOLEEN";	
		}else this.type = "ENTIER";
		this.nbParam = rangParam+1;
		for(int i=0;i<nbParam;i++){
			if (tp.getFirst().startsWith("b") || tp.getFirst().startsWith("B")){
				typeParam.addLast("BOOLEEN");	
			}else typeParam.addLast("ENTIER");
		}
	}
	
	//Méthodes
	
	//Récupération de la valeur
	public int getValue(){return 0;} //A VOIR
	//Méthodes toString
	public void show(String s){		
		Ecriture.ecrireString(s+" = FONCTION | resultat : "+this.type+" | les parametres : ");
		for(int i=0;i<nbParam;i++){Ecriture.ecrireString(this.typeParam.get(i) + " ");}
		Ecriture.ecrireString("\n");
	}
				
}

