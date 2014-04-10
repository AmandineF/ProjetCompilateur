/**
 * Declaration est la classe permettant de g�rer la d�claration des variables, constantes et fonctions
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
import java.util.List;
import java.util.LinkedList;


public class Declaration{

	/**
	 * Stocke l'ident courant
	 */
	private static String identAStocker;
	/**
	 * Stocke le type courant
	 */
	private static String typeAStocker;
	/**
	 * Stocke le type du retour des fonctions
	 */
	private static String retourFonction;
	/**
	 * Liste permettant le stockage des attributs des param�tres de fonctions
	 */
	private static LinkedList<String> typeParam= new LinkedList(), clefParam = new LinkedList();
	/**
	 * Stocke l'entier courant
	 */
	private static int entierAStocker;
	/**
	 * Stocke l'offset courant & atribut permettant de compter le nombre de param�tres d'une fonction
	 */
	private static int offset, compterParam = -1;

	/*Pour chaque constante ou variable, on stocke son type, son nom et sa valeur ( offset pour les variables)*/

	/**
	 * Fonction permettant de stocker l'ident lu
	 */
	public void stockerIdent(){
		this.identAStocker = YakaTokenManager.identLu;
	}
	
	/**
	 * Sauvegarde le type du retour de fonction
	 */
	public void sauvRetourFonction(){
		retourFonction = typeAStocker;
	}

	/**
	 * Stocke le nom du param�tre lu
	 */
	public void stockerParam(){
		clefParam.addFirst(YakaTokenManager.identLu);
	}

	/**
	 * Stocke l'entier placer en param�tre
	 * @param n : entier � stocker
	 */
	public void stockerEntier(int n){
		this.entierAStocker = n;
	}

	/**
	 * Stocke le type passer en param�tre
	 * @param type : type � stocker
	 */
	public void stockerType(String type){
		this.typeAStocker = type;
	}

	/**
	 * Incr�mente l'offset pour les variables
	 */
	public void calculerOffset(){
		this.offset = this.offset-2;
	}

	/**
	 *Stocke le type � stocker dans la pile et incr�mente le rang du dernier param�tre
	 */
	public void stockerTypeParam(){
		compterParam++; 
		this.typeParam.addFirst(this.typeAStocker);
	}

	/**
	 * Retourne le rang du dernier param�tre
	 * @return int : rang du dernier param�tre
	 */
	public int getNbParam() {
		return compterParam;
	}



	/* On regroupe finalement toutes les informations dans un tableau qu'on pourra afficher */

	/**
	 * Remplit tabIdent avec les variables lues
	 */
	public void remplirTableauVar(){
		IdVar idVar =  new IdVar(this.typeAStocker,this.offset);
		Yaka.tabIdent.rangeIdent(this.identAStocker,idVar);
	}

	/**
	 * Remplit tabIdent avec les constantes lues
	 */
	public void remplirTableauConst(){
		IdConst idConst = new IdConst(this.typeAStocker,this.entierAStocker);	
		Yaka.tabIdent.rangeIdent(this.identAStocker, idConst);
	}

	/**
	 * Remplit tabIdent avec les fonctions lues et les param�tres lues
	 */
	public void remplirTableauGlobaux(){
		IdFonction idFonction = new IdFonction(this.retourFonction,this.typeParam, this.compterParam);
		Yaka.tabIdent.rangeIdentGlobaux(this.identAStocker, idFonction);
		
		IdParam idParam;
		for(int i =0; i<=compterParam; i++){
			idParam = new IdParam(typeParam.get(i),4+2*i);
			Yaka.tabIdent.rangeIdent(clefParam.get(i),idParam);
		}
		compterParam = -1;
		typeParam = new LinkedList();
		clefParam = new LinkedList();
	}
	
	public void clearOffset(){
		this.offset = 0;
	}
}
