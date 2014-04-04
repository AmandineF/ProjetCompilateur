/**
 * Expression est la classe g�rant le controle de type
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */


import java.util.List;
import java.util.LinkedList;

public class Expression{

	/*
	  Attributs :
	  loperateur : Liste des op�rateurs
	  ltype : Liste des types lus (boolean, int)
	*/
	private LinkedList<String> loperateur = new LinkedList<String>();
	private LinkedList<String> ltype = new LinkedList<String>();

	
	/**
	 * Contr�le la concordance des types, v�rifie si les types sont en accord avec les op�rations
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
	 * Ajoute l'op�rateur en param�tre dans la liste des op�rateurs
	 * @param op : op�rateur � ajouter
	 */
	public void ajoutOp(String op){
		loperateur.add(op);
	}
	
	/**
	 * Ajoute le type en param�tre dans la liste des types
	 * @param type : type � ajouter
	 */
	public void ajoutType(String type){
		ltype.add(type);	
	}

	/**
	 * V�rifie que les conditions d'�x�cution du contr�le de type sont pr�sentes, et l'effectue si c'est le cas
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
	 * Regarde si la valeur retourn�e par la fonction correspond � son type
	 * @param f : IdFonction necessaire pour r�cup�rer le type de la fonction
	 * @return boolean : vrai si le type de retour de la fonction correspond � son type, faux sinon
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