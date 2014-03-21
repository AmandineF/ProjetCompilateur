
public class YVMasm extends YVM {
	int cpt = 0;
	
	
	public YVMasm() {

	}

	public void entete() {
		this.programme += ";entete\n";
		if (!arret){
			this.programme="extrn lirent:proc, ecrent:proc\nextrn ecrbool:proc\nextrn ecrch:proc, ligsuiv:proc\n.model SMALL\n.586\n.CODE\n debut :\nSTARTUPCODE\n\n";	
		}
	}


	public void incVar(){
		if (!arret){
			this.nbVar+=2;
		}
	}

	public void ouvrePrinc() {
		this.programme += ";ouvrePrinc\n";
		if (!arret){
			this.programme+="mov bp,sp\nsub sp,"+this.nbVar+"\n\n";
		}
	}

	public void ecrireChaine() {
		this.programme += ";ecrireChaine\n";
		if (!arret){
			String s = YakaTokenManager.chaineLue.substring(0,YakaTokenManager.chaineLue.length()-1);
			this.programme+=".DATA\nmess"+cpt+" DB "+s+"$"+'"'+"\n";
			this.programme+=".CODE\nlea dx,mess"+cpt+"\npush dx\ncall ecrch\n\n";
			cpt++;
		}
	}

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

	public void aLaLigne() {
		this.programme += ";aLaLigne\n";
		if (!arret){
			this.programme+="call ligsuiv\n\n";
		}
	}

	public void iConst() {
		this.programme += ";iConst\n";
		if (!arret){
			this.programme+="push word ptr "+YakaTokenManager.entierLu+"\n\n";
		}
	}

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

	public void stockerPlus() {
		if (!arret){
			this.operateurAdd = "iadd";
		}
	}

	public void stockerMoins() {
		if (!arret){
			this.operateurAdd = "isub";
		}
	}
	public void stockerOu() {
		if (!arret){
			this.operateurAdd = "ior";
		}
	}

	public void afficherOperateurAdd(){
		if (!arret){
			switch(this.operateurAdd){
		case "iadd": this.programme+=";iadd\npop bx\npop ax\nadd ax,bx\npush ax\n\n"; break;
		case "isub": this.programme+=";isub\npop bx\npop ax\nsub ax,bx\npush ax\n\n"; break;
		case "ior" : this.programme+=";ior\npop ax \npop bx or ax,bx \npush ax\n\n"; break;
		default : this.programme+="ERREUR YVMasm\n";
		}
		}
	}
	public void stockerDiv() {
		if (!arret){
			this.operateurMul= "idiv";
		}
	}

	public void stockerMul() {
		if (!arret){
			this.operateurMul = "imul";
		}
	}

	public void stockerAnd() {
		if (!arret){
			this.operateurMul = "iand";
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

	public void stockerOppose(){
		this.opNeg="ineg";
	}

	public void stockerNeg() {
		this.opNeg="inot";
	}
	
	public void afficherNeg() {
		switch(this.opNeg){
		case "ineg": this.programme+=";ineg\npop ax\nnot ax \npush ax\n\n"; break;
		case "inot": this.programme+=";inot\npop ax\nmov bx,-1 \nimul bx \n push ax\n\n"; break;
	}
	}


	public void queue() {
		this.programme += ";queue\n";
		if (!arret){
			this.programme+="nop\nEXITCODE\nEnd debut\n";
			//Ecriture.ecrireString(this.programme);
		}
	}

}