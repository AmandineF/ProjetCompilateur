import java.util.List;
import java.util.LinkedList;

public class YVM {

	/**
	 * Attribut dans lequel on stocke la partie traduite du programme a afficher à la fin de la lecture
	 */
	protected String programme = "";

	/**
	 * Attribut dans lequel on stocke l'opérateur de test des conditionnelles et des itérations
	 */
	protected String testIter;

	/**
	 * Attribut dans lequel on stocke l'opérateur d'addition
	 */
	protected LinkedList<String> operateurAdd = new LinkedList<String>();

	/**
	 * Attribut dans lequel on stocke l'opérateur de multiplication
	 */
	protected LinkedList<String> operateurMul = new LinkedList<String>();

	/**
	 * Attribut dans lequel on stocke l'opérateur de négation
	 */
	protected LinkedList<String> opNeg = new LinkedList<String>();

	protected LinkedList<String> nomFonction = new LinkedList<String>();
	/**
	 * Attribut dans lequel on stocke le nombre de variables du programme
	 */
	protected int nbVar=0;

	/**
	 * Attribut dans lequel on stocke l'offset de la variable affectée
	 */
	protected int store;

	/**
	 * Attribut dans lequel on stocke le numero des conditionnelles
	 */
	protected int incrIter;
	protected LinkedList<Integer> liter = new LinkedList<Integer>();

	/**
	 * Attribut dans lequel on stocke le numero des itérations
	 */
	protected int  incrCond;
	protected LinkedList<Integer> lcond =new LinkedList<Integer>();

	/**
	 * Attribut gérant l'arrêt du programme
	 */

	protected int nbParam = 0;

	protected boolean arret;

	/**
	 * Booleen indiquant si on est dans une fonction ou non
	 */
	protected boolean fonction;
	/**
	 * Permet l'arrêt du programme en cas d'erreur de type
	 * @param b : booleen 
	 */

	public void stop(boolean b){
		if(b){}
		else{
			arret = true;
		}
	}

	/**
	 *  Fonction permetant de stocker dans programme la traduction de debut du progamme
	 */
	public void entete() {
		if (!arret){
			this.programme +="entete\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction de fin du programme
	 */
	public void queue() {
		if (!arret){
			this.programme+="queue\n";
		}
	}

	/**
	 * Fonction permettant d'incrémenter de 2 la valeur qui s'affiche derrière 
	 * ouvrePrinc à chaque variable lue
	 */
	public void incVar(){
		if (!arret){
			this.nbVar+=2;  
		}

	}

	/** 
	 * Fonction permettant d'afficher ouvrePrinc avec le nombre d'octets utilisés pour les variables
	 */
	public void ouvrePrinc() {
		if (!arret){
			if(fonction = false) {
				this.programme+="ouvrePrinc "+this.nbVar+"\n";
			} else {
				this.programme+="ouvbloc "+this.nbVar+"\n";
			}
		}
	}



	/**
	 * Fonction permettant de stocker l'opérateur plus
	 */
	public void stockerPlus() {
		if (!arret){
			this.operateurAdd.addLast("iadd");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur moins
	 */   
	public void stockerMoins() {
		if (!arret){
			this.operateurAdd.addLast("isub");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur ou
	 */
	public void stockerOu() {
		if (!arret){
			this.operateurAdd.addLast("ior");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur diviser
	 */
	public void stockerDiv() {
		if (!arret){
			this.operateurMul.addLast("idiv");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur multiplier
	 */
	public void stockerMul() {
		if (!arret){
			this.operateurMul.addLast("imul");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur et
	 */
	public void stockerAnd() {
		if (!arret){
			this.operateurMul.addLast("iand");
		}
	}

	/**
	 * Fonction permettant de stocker l'opérateur ineg
	 */
	public void stockerOppose(){
		this.opNeg.addLast("ineg");
	}

	/**
	 * Fonction permettant de stocker l'opérateur inot
	 */
	public void stockerNeg() {
		this.opNeg.addLast("inot");
	}

	/**
	 * Fonction permettant de donner l'offset de la variable affectée qu'on affichera par la suite 
	 */
	public void offsetStore() {
		this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();

	}

	/**
	 * Fonction permettant de stocker l'opérateur egal
	 */
	public void stockerEgal() {
		this.testIter="iegal";
	}

	/**
	 * Fonction permettant de stocker l'opérateur different
	 */
	public void stockerDiff() {
		this.testIter="idiff";
	}

	/**
	 * Fonction permettant de stocker l'opérateur strictement inferieur
	 */
	public void stockerInfStrict() {
		this.testIter="iinf";
	}

	/**
	 * Fonction permettant de stocker l'opérateur inferieur ou egal
	 */
	public void stockerInfEgal() {
		this.testIter="iinfegal";
	}

	/**
	 * Fonction permettant de stocker l'opérateur superieur ou egal
	 */
	public void stockerSupEgal() {
		this.testIter="isupegal";
	}

	/**
	 * Fonction permettant de stocker l'opérateur strictement superieur
	 */
	public void stockerSupStrict() {
		this.testIter="isup";
	}

	/**
	 * Fonction permettant d'incrémenter le numero des conditions pour avoir 
	 * des etiquettes differentes dans la traduction
	 */
	public void numCond() {
		this.incrCond ++;
		this.lcond.addLast(incrCond);
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de ecrireEnt
	 */
	public void ecrireEnt(){
		if (!arret){
			if (Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getType() == "ENTIER") {
				this.programme+="ecrireEnt\n";
			} else {
				this.programme+="ecrireBool\n";
			}
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de ecrireChaine
	 */
	public void ecrireChaine() {
		if (!arret){
			this.programme+="ecrireChaine "+YakaTokenManager.chaineLue+"\n";
		} 
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de lireEnt
	 */
	public void lireEnt() {
		if (!arret){
			this.programme+="lireEnt "+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"\n";
			// On récupère l'offset de la variable à lire
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de aLaLigne
	 */
	public void aLaLigne() {
		if (!arret){
			this.programme+="aLaLigne\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de iconst pour les constantes
	 */
	public void iConst(Ident i) {
		if (!arret){
			this.programme+="iconst "+i.getValue()+"\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de iconst pour les entiers lus
	 */
	public void iConst(int i) {
		if (!arret){
			this.programme+="iconst "+i+"\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la traduction immediate de iload
	 */
	public void iLoad(){
		if (!arret){
			this.programme+="iload " + Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue() + "\n";
		}
	}

	/**
	 * Fonction permettant 
	 */
	public void charger(Ident i){
		if (i instanceof IdVar || i instanceof IdParam){
			iLoad();
		}else if(i instanceof IdConst){iConst(i);}
	}

	/**
	 * Fonction permettant de stocker dans programme les itérations 
	 * icrIter est incémenté, il permet d'indiquer le numero de la boucle tantque
	 */
	public void faire() {
		if (!arret){
			this.incrIter++;
			this.liter.addLast(incrIter);
			this.programme+="FAIRE"+this.liter.getLast()+":\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la fin des itérations
	 */
	public void fait() {
		if (!arret){
			this.programme+="goto FAIRE"+this.liter.getLast()+"\nFAIT"+this.liter.pollLast()+":\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme le sinon des conditionnelles
	 */
	public void sinon() {
		if (!arret){
			this.programme+="goto FSI"+this.lcond.getLast()+"\nSINON"+this.lcond.getLast()+":\n";   		
		}
	}


	/**
	 * Fonction permettant de stocker dans programme le fin si des conditionnelles
	 */
	public void fsi() {
		if (!arret){

			this.programme+="FSI"+this.lcond.pollLast()+":\n";

		}
	}

	/**
	 * Fonction permettant de stocker dans programme l'opérateur d'addition
	 */
	public void afficherOperateurAdd(){
		if (!arret){
			this.programme+=this.operateurAdd.pollLast() + "\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme l'opérateur de multiplication
	 */
	public void afficherOperateurMul(){
		if (!arret){
			this.programme+=this.operateurMul.pollLast()+ "\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme istore
	 */
	public void iStore(){
		if (!arret){
			this.programme+="istore " + this.store + "\n";
		}
	}

	/**
	 * ATTENTION 
	 */
	public void afficherCompare(){
		if (!arret){
			this.programme += this.testIter+"\n";
		}
	}

	/**
	 * Foncion permettant de stocker dans programme l'opérateur de négation
	 */
	public void afficherNeg() {
		this.programme+=this.opNeg.pollLast()+"\n";
	}

	/**
	 * Fonction permettant de stocker dans programme le test des itérations
	 */
	public void iter() {
		if (!arret){
			this.programme+="iffaux FAIT"+this.incrIter+"\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme le test des conditionnelles
	 */
	public void cond() {
		if (!arret){
			this.programme+="iffaux SINON"+this.incrCond+"\n";
		}
	}

	/**
	 * Fonction permettant de stocker dans programme la déclaration d'une fonction
	 */
	public void declFonction() {
		if(!arret) {
			this.programme += YakaTokenManager.identLu + ":\n"; 
		}
	}

	/**
	 * Fonction permettant d'incrémenter la taille total des paramètres de la fonction
	 */
	public void incNbParam() {
		this.nbParam++;
	}


	public void fonction() {
		this.fonction = true;
	}

	/**
	 * Fonction permettant de stocker dans programme le code  pour sortir d'une fonction
	 */
	public void finFonction() {
		this.programme += "fermebloc " + this.nbParam*2+"\n\n";
		this.fonction = false;
		this.nbParam=0;
		this.nbVar = 0;
		this.store = 0;
	}

	/**
	 * Fonction permettant de stocker dans programme le code plaçant la valeur de retour de la fonction sur la pile
	 */
	public void retour(){
		this.programme += "ireturn " + (this.nbParam*2+4)+"\n\n";
	}

	/**
	 * Fonction réservant de la place sur la pile pour le retour de la fonction
	 */
	public void reserveRetour() {
		this.nomFonction.addLast(YakaTokenManager.identLu);
		this.programme+= "reserveRetour\n\n";
	}

	/**
	 * Fonction permettant de stocker dans programme l'appel à une fonction
	 */
	public void call(){
		this.programme+= "call " + nomFonction.removeLast()+"\n\n";
	}


	public void afficherMain(){
		this.programme += "main: \n";
	}


	/**
	 * Fonction permettant de générer le programme
	 * @return String : le texte du programme
	 */
	public String genere(){
		return this.programme;
	}


}
