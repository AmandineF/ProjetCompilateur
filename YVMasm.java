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
			this.programme="extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc\n.model SMALL\n.586\n.CODE\n debut :\nSTARTUPCODE\n\n";	
		}
	}



	public void ouvrePrinc() {
		this.programme += ";ouvrePrinc\n";
		if (!arret){
			this.programme+="mov bp,sp\nsub sp,"+this.nbVar+"\n\n";
		}
	}

	/**
	 * Ecrit une cha�ne de caract�re
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
	 * lit un entier
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
	public void iConst() {
		this.programme += ";iConst\n";
		if (!arret){
			this.programme+="push word ptr "+YakaTokenManager.entierLu+"\n\n";
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

	public void afficherOperateurAdd(){
		if (!arret){
			switch(this.operateurAdd){
			case "iadd": this.programme+=";iadd\npop bx\npop ax\nadd ax,bx\npush ax\n\n"; break;
			case "isub": this.programme+=";isub\npop bx\npop ax\nsub ax,bx\npush ax\n\n"; break;
			case "ior" : this.programme+=";ior\npop ax \npop bx\nor ax,bx \npush ax\n\n"; break;
			default : this.programme+="ERREUR YVMasm\n";
			}
		}
	}

	public void afficherOperateurMul(){
		if (!arret){
			switch(this.operateurMul){
			case "idiv": this.programme+=";idiv\npop bx\npop ax\ncwd\n idiv bx\npush ax\n\n"; break;
			case "imul": this.programme+=";imul\npop bx\npop ax\nimul bx\npush ax\n\n"; break;
			case "iand": this.programme+=";iand\npop ax \npop bx \nand ax,bx  \npush ax \n\n"; break;
			default : this.programme+="ERREUR YVMasm";
			}
		}
	}
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

	public void offsetStore() {
		this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();
	}

	public void ecrireEnt(){
		this.programme += ";ecrireEnt\n";
		this.programme+="call ecrent\n\n";
	}

	
	public void afficherNeg() {
		switch(this.opNeg){
		case "inot": this.programme+=";ineg\npop ax\nnot ax \npush ax\n\n"; break;
		case "ineg": this.programme+=";inot\npop ax\nmov bx,-1 \nimul bx \n push ax\n\n"; break;
	}
	}
	
	public void afficherCompare(){
		switch(this.testIter){
		case "iegal" : this.programme+=";iegal\npop bx\npop ax\ncmp ax,bx\njne $+\n\n"; break;
		case "idiff" : this.programme+=";idiff\npop bx\npop ax\ncmp ax,bx\nje $+\n\n"; break;
		case "iinf" :  this.programme+=";iinf\npop bx\npop ax\ncmp ax,bx\njge $+6\npush -1\njmp $+4\npush 0\n\n"; break;
		case "iinfegal" : this.programme+=";iinfegal\npop bx\npop ax\ncmp ax,bx\njg $+6\npush -1\njmp $+4\npush 0\n\n"; break;
		case "isupegal" :this.programme+=";isupegal\npop bx\npop ax\ncmp ax,bx\njl $+6\npush -1\njmp $+4\npush 0\n\n"; break;
		case "isup" : this.programme+=";isup\npop bx\npop ax\ncmp ax,bx\njle $+6\npush -1\njmp $+4\npush 0\n\n"; break;
		}
	}
	
	//gestion de l'it�ration
	
	public void faire() {
        	if (!arret){
        		this.incrIter++;
        		this.programme+="FAIRE"+this.incrIter+":\n";
        		// icrIter est inc�ment�, il permet d'indiquer le numero de la boucle tantque
        	}
        }
        
         public void fait() {
        	if (!arret){
   
        		this.programme+=";goto FAIRE"+this.incrIter+"\njmp FAIRE"+this.incrIter+"\n\nFAIT"+this.incrIter+":\n";
        		
        	}
        }
	
	public void iter(){
		if(!arret){
			this.programme+= ";iffaux FAIT"+this.incrIter+"\npop ax\ncmp ax,0\nje FAIT"+this.incrIter+"\n\n";
		}
	}
	
	//gestion de la conditionnelle
	
	public void cond() {
		if (!arret){
         	 	 this.programme+=";iffaux SINON"+this.incrCond+"\npop ax\ncmp ax,0\nje SINON"+this.incrCond+"\n\n";
        	 }
        }
        
        public void sinon() {
        	if (!arret){
   
        		this.programme+=";goto FSI"+this.incrCond+"\njmp FSI"+this.incrCond+"\n\nSINON"+this.incrCond+":\n";
        		
        	}
        }
        
        public void fsi() {
        	if (!arret){
   
        		this.programme+="FSI"+this.incrCond+":\n\n";
        		
        	}
        }

        //fin du programme
	public void queue() {
		this.programme += ";queue\n";
		if (!arret){
			this.programme+="nop\nEXITCODE\nEnd debut\n";
			//Ecriture.ecrireString(this.programme);
		}
	}

}