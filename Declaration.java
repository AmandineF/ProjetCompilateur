import java.util.List;
import java.util.LinkedList;


public class Declaration{

	/* ça se passe de commentaires ! Mais on va faire un effort*/

	private static String identAStocker;
	private static String typeAStocker;
	private static LinkedList<String> typeParam= new LinkedList(), clefParam = new LinkedList();
	private static int entierAStocker;
	private static int offset, compterParam = -1;

	/*Pour chaque constante ou variable, on stocke son type, son nom et sa valeur ( offset pour les variables)*/


	public void stockerIdent(){
		this.identAStocker = YakaTokenManager.identLu;
	}//nom

	public void stockerParam(){
		//compterParam++;
		clefParam.addLast(YakaTokenManager.identLu);
	}//nom paramètre

	public void stockerEntier(int n){
		this.entierAStocker = n;
	}//valeur pour les constantes

	public void stockerType(String type){
		this.typeAStocker = type;
	}//type

	public void calculerOffset(){
		this.offset = this.offset-2;
	}//incrémentation de l'offset pour les variables

	public void stockerTypeParam(){
		compterParam++; 
		this.typeParam.addLast(this.typeAStocker);
	}

	public int getNbParam() {
		return compterParam;
	}



	/* On regroupe finalement toutes les informations dans un tableau qu'on pourra afficher */

	public void remplirTableauVar(){
		IdVar idVar =  new IdVar(this.typeAStocker,this.offset);
		Yaka.tabIdent.rangeIdent(this.identAStocker,idVar);
	}

	public void remplirTableauConst(){
		IdConst idConst = new IdConst(this.typeAStocker,this.entierAStocker);	
		Yaka.tabIdent.rangeIdent(this.identAStocker, idConst);
	}

	/*
	public void remplirTableauParam(){
		IdParam idParam = new IdParam(this.typeAStocker,4+2*i);
		Yaka.tabIdent.rangeIdent(this.identAStocker,idParam);
	}
	 */

	public void remplirTableauGlobaux(){
		IdFonction idFonction = new IdFonction(this.typeAStocker,this.typeParam, this.compterParam);
		Yaka.tabIdent.rangeIdentGlobaux(this.identAStocker, idFonction);

		IdParam idParam;
		for(int i =0; i<=compterParam; i++){
			idParam = new IdParam(typeParam.pollFirst(),4+2*i);
			Yaka.tabIdent.rangeIdent(clefParam.pollFirst(),idParam);
		}
	}
}
