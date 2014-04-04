/**
 * Expression est la classe gérant le controle de type
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */


import java.util.List;
import java.util.LinkedList;

public class Expression{

	/*
	  Attributs :
	  loperateur : Liste des opérateurs
	  ltype : Liste des types lus (boolean, int)
	*/
	private LinkedList<String> loperateur = new LinkedList<String>();
	private LinkedList<String> ltype = new LinkedList<String>();

	
	/**
	 * Contrôle la concordance des types, vérifie si les types sont en accord avec les opérations
	 * @return boolean : vrai si les types sont corrects, faux sinon.
	*/
	public boolean controleType(){

		String op = loperateur.getLast();
		String typeA = ltype.get(ltype.size()-1);
		String typeB = ltype.getLast();
		int nbErreur = 0;
		

		switch(op){

		case "+":
		case "-":
		case "*":
		case "/":
			if (!( typeA.equals("ENTIER") && typeB.equals("ENTIER") )) {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("ENTIER");
				loperateur.removeLast();
				
				return true;
			}
		case "<":
		case ">":
		case "<=":
		case ">=":
			if (!( typeA.equals("ENTIER") && typeB.equals("ENTIER") )) {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("BOOLEEN");
				loperateur.removeLast();
				return true;
			}

		case "=":
		case "<>":
			if ((!( typeA.equals("ENTIER") && typeB.equals("ENTIER") )) || (!(typeA.equals("BOOLEEN") && typeB.equals("BOOLEEN")))){
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("BOOLEEN");
				loperateur.removeLast();
				return true;
			}

		case "et":
		case "ou":
			if (!( typeA.equals("BOOLEEN") && typeB.equals("BOOLEEN") )) {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.removeLast();
				ltype.addLast("BOOLEEN");
				loperateur.removeLast();
				return true;
			}

		case "neg":
			if (!typeB.equals("ENTIER")) {
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.addLast("ENTIER");
				loperateur.removeLast();
				return true;
			}

		case "non":
			if (!typeB.equals("BOOLEEN")) {
				ltype.removeLast();
				ltype.addLast("ERREUR");
				loperateur.removeLast();
				System.out.println("erreur de type, arret de la compilation");
				return false;
			}else {
				ltype.removeLast();
				ltype.addLast("BOOLEEN");
				loperateur.removeLast();
				return true;
			}
		default:
			ltype.removeLast();
			ltype.removeLast();
			ltype.addLast("ERREUR");
			loperateur.removeLast();
			System.out.println("\nerreur inconnue (case default) : arret de la compilation\n\n");
			return false;
		}
	}

	/**
	 * Ajoute l'opérateur en paramètre dans la liste des opérateurs
	 * @param op : opérateur à ajouter
	 */
	public void ajoutOp(String op){
		loperateur.add(op);
	}
	
	/**
	 * Ajoute le type en paramètre dans la liste des types
	 * @param type : type à ajouter
	 */
	public void ajoutType(String type){
		ltype.add(type);	
	}

	/**
	 * Vérifie que les conditions d'éxécution du contrôle de type sont présentes, et l'effectue si c'est le cas
	 * @return boolean : vrai si le controle de type est correct, faux sinon
	 */
	public boolean typage(){
		if(loperateur.size()>0){
			String op = loperateur.getLast();
			if(op.equals("neg") || op.equals("non")){
				boolean a = controleType();
				boolean b = typage();
				return ( a && b ); 
			}

			if(ltype.size()>=2){
				return controleType();
			}
		}else return true;
		return false;
	}

	/**
	 * Regarde si la valeur retournée par la fonction correspond à son type
	 * @param f : IdFonction necessaire pour récupérer le type de la fonction
	 * @return boolean : vrai si le type de retour de la fonction correspond à son type, faux sinon
	 */
	public boolean controleRetourDeFonction(IdFonction f){
		String typef = f.getType();
		String typeRetour = ltype.getLast();
		if(typef.equals(typeRetour)){
			return true;
		}else{
			ltype.removeLast();
			ltype.addLast("ERREUR");
			return false;
		}
	}
}