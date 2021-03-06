/**
 * YVMasm est la classe permettant de g�n�rer le code en assembleur accompagn� du code YVM en commentaire
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
public class YVMasm extends YVM {

	//Attribut
	int cpt = 0;

	//M�thodes

	/**
	 * affiche l'ent�te du programme
	 */
	public void entete() {
		this.programme += ";entete\n";
		if (!arret){
			this.programme += "extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc\n.model SMALL\n.586\n.CODE\n\n";	
		}
	}

	/**
	 * affiche la traduction de ouvrePrinc
	 */
	public void ouvrePrinc() {
		if (!arret){
			if(fonction = false){
				this.programme+=";ouvrePrinc\nmov bp,sp\nsub sp,"+this.nbVar+"\n\n";
			} else {
				this.programme+=";ouvbloc "+this.nbVar+"\nenter "+this.nbVar+",0\n";
			}
		}
	}


	/**
	 * Affiche la traduction d'une chaine de caract�res
	 */
	public void ecrireChaine() {
		this.programme += ";ecrireChaine\n";
		if (!arret){
			String s = YakaTokenManager.chaineLue.substring(0,YakaTokenManager.chaineLue.length()-1);
			this.programme+=".DATA\nmess"+cpt+" DB "+s+"$"+'"'+"\n";
			this.programme+=".CODE\nlea dx,mess"+cpt+"\npush dx\ncall ecrch\n\n";
			cpt++;
		}
	}

	/**
	 * Affiche la traduction de lireEnt
	 */
	public void lireEnt() {
		this.programme += ";lireEnt\n";
		if (!arret){
			if(Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()<0){
				this.programme+="lea dx,[bp"+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"]\npush dx\ncall lirent\n\n";
			}else{
				this.programme+="lea dx,[bp+"+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"]\npush dx\ncall lirent\n\n";
			}
		}
	}

	/**
	 * passe � la ligne suivante
	 */
	public void aLaLigne() {
		this.programme += ";aLaLigne\n";
		if (!arret){
			this.programme+="call ligsuiv\n\n";
		}
	}

	/**
	 * push la constante correspondant � l'Ident en param�tre sur la pile
	 * @param Ident : i
	 */
	public void iConst(Ident i) {
		this.programme += ";iConst\n";
		if (!arret){
			this.programme+="push word ptr "+i.getValue()+"\n\n";
		}
	}

	/**
	 * push l'entier lu sur la pile
	 */
	public void iConst(int i) {
		this.programme += ";iConst\n";
		if (!arret){
			this.programme+="push word ptr "+i+"\n\n";
		}
	}

	/**
	 * push l'Ident lu sur la pile
	 * @param Ident : i
	 */
	public void iLoad(){
		this.programme += ";iLoad\n";
		if (!arret){
			if(Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()<0){
				this.programme+="push word ptr [bp" + Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue() + "]\n\n";
			}else{
				this.programme+="push word ptr [bp+" + Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue() + "]\n\n";
			}
		}
	}

	/**
	 * Affiche la traduction de l'op�rateur d'addition dans tous les cas possibles
	 * 
	 */
	public void afficherOperateurAdd(){
		if (!arret){
			switch(this.operateurAdd.pollLast()){
			case "iadd": this.programme+=";iadd\npop bx\npop ax\nadd ax,bx\npush ax\n\n"; break;
			case "isub": this.programme+=";isub\npop bx\npop ax\nsub ax,bx\npush ax\n\n"; break;
			case "ior" : this.programme+=";ior\npop ax \npop bx\nor ax,bx \npush ax\n\n"; break;
			default : this.programme+="ERREUR YVMasm\n";
			}
		}
	}

	/**
	 * Affiche la traduction de l'op�rateur de multiplication dans tous les cas possibles
	 * 
	 */
	public void afficherOperateurMul(){
		if (!arret){
			switch(this.operateurMul.pollLast()){
			case "idiv": this.programme+=";idiv\npop bx\npop ax\ncwd\n idiv bx\npush ax\n\n"; break;
			case "imul": this.programme+=";imul\npop bx\npop ax\nimul bx\npush ax\n\n"; break;
			case "iand": this.programme+=";iand\npop ax \npop bx \nand ax,bx  \npush ax \n\n"; break;
			default : this.programme+="ERREUR YVMasm";
			}
		}
	}

	/**
	 * Affiche la traduction de iStore
	 * 
	 */
	public void iStore(){
		this.programme += ";iStore\n";
		if (!arret){
			if(this.store<0){
				this.programme+="pop ax\nmov word ptr [bp" + this.store + "],ax\n\n";
			}else{
				this.programme+="pop ax\nmov word ptr [bp+" + this.store + "],ax\n\n";
			}
		}
	}

	/**
	 * Cherche la valeur de l'offset de la variable affect�e 
	 * 
	 */
	public void offsetStore() {
		this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();
	}

	/**
	 * Affiche la traduction de ecrireEnt
	 * 
	 */
	public void ecrireEnt(){
		if(!arret){
			if (Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getType() == "ENTIER") {
				this.programme+=";ecrireEnt\n";
				this.programme+="call ecrent\n\n";
			} else {
				this.programme+=";ecrireBool\n";
				this.programme += "call ecrbool\n\n";
			}
		}
	}

	/**
	 * Affiche la traduction de l'op�rateur de n�gation dans tous les cas possibles
	 * 
	 */
	public void afficherNeg() {
		if(!arret){
			switch(this.opNeg.pollLast()){
				case "inot": this.programme+=";ineg\npop ax\nnot ax \npush ax\n\n"; break;
				case "ineg": this.programme+=";inot\npop ax\nmov bx,-1 \nimul bx \n push ax\n\n"; break;
			}
		}
	}

	/**
	 * Affiche la traduction de l'op�rateur de comparaison dans tous les cas possibles
	 * 
	 */
	public void afficherCompare(){
		if(!arret){
			switch(this.testIter){
				case "iegal" : this.programme+=";iegal\npop bx\npop ax\ncmp ax,bx\njne $+6\npush -1\njmp $+4\npush 0\n\n"; break;
				case "idiff" : this.programme+=";idiff\npop bx\npop ax\ncmp ax,bx\nje $+6\npush -1\njmp $+4\npush 0\n\n"; break;
				case "iinf" :  this.programme+=";iinf\npop bx\npop ax\ncmp ax,bx\njge $+6\npush -1\njmp $+4\npush 0\n\n"; break;
				case "iinfegal" : this.programme+=";iinfegal\npop bx\npop ax\ncmp ax,bx\njg $+6\npush -1\njmp $+4\npush 0\n\n"; break;
				case "isupegal" :this.programme+=";isupegal\npop bx\npop ax\ncmp ax,bx\njl $+6\npush -1\njmp $+4\npush 0\n\n"; break;
				case "isup" : this.programme+=";isup\npop bx\npop ax\ncmp ax,bx\njle $+6\npush -1\njmp $+4\npush 0\n\n"; break;
			}
		}
	}


	/**
	 * Affiche la traduction du d�but des it�rations
	 * 
	 */
	public void faire() {
		if (!arret){
			this.incrIter++;
			this.liter.addLast(incrIter);
			this.programme+="FAIRE"+this.liter.getLast()+":\n";
			// icrIter est inc�ment�, il permet d'indiquer le numero de la boucle tantque
		}
	}

	/**
	 * Affiche la traduction de la fin des it�rations
	 * 
	 */   
	public void fait() {
		if (!arret){

			this.programme+=";goto FAIRE"+this.liter.getLast()+"\njmp FAIRE"+this.liter.getLast()+"\n\nFAIT"+this.liter.pollLast()+":\n";

		}
	}

	/**
	 * Affiche la traduction des tests des it�rations
	 * 
	 */
	public void iter(){
		if(!arret){
			this.programme+= ";iffaux FAIT"+this.liter.getLast()+"\npop ax\ncmp ax,0\nje FAIT"+this.liter.getLast()+"\n\n";
		}
	}


	/**
	 * Affiche la traduction des tests de debut des conditionnelles
	 * 
	 */
	public void cond() {
		if (!arret){
			this.programme+=";iffaux SINON"+this.lcond.getLast()+"\npop ax\ncmp ax,0\nje SINON"+this.lcond.getLast()+"\n\n";
		}
	}

	/**
	 * Affiche la traduction du sinon des conditionnelles
	 * 
	 */
	public void sinon() {
		if (!arret){

			this.programme+=";goto FSI"+this.lcond.getLast()+"\njmp FSI"+this.lcond.getLast()+"\n\nSINON"+this.lcond.getLast()+":\n";

		}
	}

	/**
	 * Affiche la traduction de la fin des conditionnelles
	 * 
	 */
	public void fsi() {
		if (!arret){

			this.programme+="FSI"+this.lcond.pollLast()+":\n\n";

		}
	}
	// Fonctions

	/**
	 * Fonction permettant de stocker dans programme la d�claration d'une fonction
	 */
	public void declFonction() {
		if(!arret) {
			this.programme += YakaTokenManager.identLu + ":\n"; 
		}
	}

	/**
	 * Fonction permettant de stocker dans programme le code  pour sortir d'une fonction
	 */
	public void finFonction() {
		if(!arret){
			this.programme += ";fermebloc " + this.nbParam*2+"\n";
			this.programme += "leave\nret "+this.nbParam*2+"\n\n";
			this.fonction = false;
			this.nbParam=0;
			this.nbVar = 0;
		}
	}


	/**
	 * Fonction permettant de stocker dans programme le code pla�ant la valeur de retour de la fonction sur la pile
	 */
	public void retour(){
		this.programme += ";ireturn ";
		if(!arret){
			this.programme += (this.nbParam*2+4)+"\n";
			this.programme += "pop ax\nmov [bp+"+(this.nbParam*2+4)+"],ax\n\n";
		}
	}


	/**
	 * Fonction r�servant de la place sur la pile pour le retour de la fonction
	 */
	public void reserveRetour() {
		this.nomFonction.addLast(YakaTokenManager.identLu);
		if(!arret){
			//System.out.println("ajout Fonction : "+YakaTokenManager.identLu);
			this.nomFonction.addLast(YakaTokenManager.identLu);
			this.programme += ";reserveRetour\n";
			this.programme += "sub sp,2\n\n";
		}
	}


	/**
	 * Fonction permettant de stocker dans programme l'appel � une fonction
	 */
	public void call(){
		this.programme += ";call ";
		if(!arret){
			this.programme += nomFonction.getLast()+"\ncall "+ nomFonction.removeLast()+"\n\n";
		}
	}

	/**
	 * Affiche la traduction de la fin du programme
	 * 
	 */


	public void afficherMain(){
		if(!arret){
			this.programme += "debut :\nSTARTUPCODE\n\nmain:\n";
		}
	}
	public void queue() {
		this.programme += ";queue\n";
		if (!arret){
			this.programme+="nop\nEXITCODE\nend";
			//Ecriture.ecrireString(this.programme);
		}
	}

}