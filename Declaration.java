/**
 * Declaration est la classe permettant de gérer la déclaration des variables, constantes et fonctions
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
	 * Liste permettant le stockage des attributs des paramètres de fonctions
	 */
	private static LinkedList<String> typeParam= new LinkedList(), clefParam = new LinkedList();
	/**
	 * Stocke l'entier courant
	 */
	private static int entierAStocker;
	/**
	 * Stocke l'offset courant & atribut permettant de compter le nombre de paramètres d'une fonction
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
	 * Stocke le nom du paramètre lu
	 */
	public void stockerParam(){
		clefParam.addFirst(YakaTokenManager.identLu);
	}

	/**
	 * Stocke l'entier placer en paramètre
	 * @param n : entier à stocker
	 */
	public void stockerEntier(int n){
		this.entierAStocker = n;
	}

	/**
	 * Stocke le type passer en paramètre
	 * @param type : type à stocker
	 */
	public void stockerType(String type){
		this.typeAStocker = type;
	}

	/**
	 * Incrémente l'offset pour les variables
	 */
	public void calculerOffset(){
		this.offset = this.offset-2;
	}

	/**
	 *Stocke le type à stocker dans la pile et incrèmente le rang du dernier paramètre
	 */
	public void stockerTypeParam(){
		compterParam++; 
		this.typeParam.addFirst(this.typeAStocker);
	}

	/**
	 * Retourne le rang du dernier paramètre
	 * @return int : rang du dernier paramètre
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
	 * Remplit tabIdent avec les fonctions lues et les paramètres lues
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
