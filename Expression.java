import java.util.List;
import java.util.LinkedList;

public class Expression{

	private LinkedList<String> loperateur = new LinkedList<String>();
	private LinkedList<String> ltype = new LinkedList<String>();

	public boolean controleType(){

		String op = loperateur.getLast();
		String typeA = ltype.get(ltype.size()-1);
		String typeB = ltype.getLast();

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
			return false;
		}
	}

	public void ajoutOp(String op){
		loperateur.add(op);
	}

	public void ajoutType(String type){
		ltype.add(type);	
	}

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
}