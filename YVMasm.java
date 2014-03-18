
public class YVMasm extends YVM {
	int cpt = 0;
	public YVMasm() {

	}

	public void entete() {
		if (!arret){
			this.programme="extrn lirent:proc, ecrent:proc\n extrn ecrbool:proc\n extrn ecrch:proc, ligsuiv:proc\n .model SMALL\n .586\n .CODE\n debut :\n STARTUPCODE\n";	
		}
	}


	public void incVar(){
		if (!arret){
			this.nbVar+=2;
		}
	}

	public void ouvrePrinc() {
		if (!arret){
			this.programme+="mov bp,sp\n sub sp,"+this.nbVar+"\n";
		}
	}

	public void ecrireChaine() {
		if (!arret){
			String s = YakaTokenManager.chaineLue.substring(0,YakaTokenManager.chaineLue.length-2);
			this.programme+=".DATA\n mess"+cpt+" DB "+s+"$"+'"'+"\n";
			this.programme+=".CODE\n lea dx,mess"+cpt+"\n push dx\n call ecrch\n";
			cpt++;
		}
	}

	public void lireEnt() {
		if (!arret){
			this.programme+="lea dx,[bp"+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"]\n push dx\n call lirent\n";
		}
	}

	public void aLaLigne() {
		if (!arret){
			this.programme+="call ligsuiv\n";
		}
	}

	public void iConst() {
		if (!arret){
			this.programme+="push word ptr "+YakaTokenManager.entierLu+"\n";
		}
	}

	public void iLoad(){
		if (!arret){
			this.programme+="push word ptr [bp" + Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue() + "]\n";
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
		case "iadd": this.programme+="pop bx\n pop ax\n add ax,bx\n push ax\n"; break;
		case "isub": this.programme+="pop bx\n pop ax\n sub ax,bx\n push ax\n"; break;
		case "ior" : this.programme+="pop ax \n pop bx or ax,bx \n push ax\n"; break;
		default : this.programme+="ERREUR YVMasm";
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
			case "idiv": this.programme+="pop bx\n pop ax\n cwd\n idiv bx\n push ax\n"; break;
			case "imul": this.programme+="pop bx\n pop ax\n imul bx\n push ax\n"; break;
			case "iand": this.programme+="pop ax \n pop bx \n and ax,bx  \n push ax \n"; break;
			default : this.programme+="ERREUR YVMasm";
			}
		}
	}
	public void iStore(){
		if (!arret){
			this.programme+="pop ax\n mov word ptr [bp+" + this.store + "],ax\n";
		}
	}

	public void offsetStore() {
		this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();

	}

	public void ecrireEnt(){
		this.programme+="call ecrent\n";
	}

	public void stockerOppose(){
		this.opNeg="ineg";
	}

	public void stockerNeg() {
		this.opNeg="inot";
	}
	
	public void afficherNeg() {
		switch(this.opNeg){
		case "ineg": this.programme+="pop ax\n not ax \n push ax\n"; break;
		case "inot": this.programme+="pop ax\n mov bx,-1 \n imul bx \n push ax\n"; break;
	}
	}


	public void queue() {
		if (!arret){
			this.programme+="nop\n EXITCODE\n End debut\n";
			System.out.println(this.programme);
		}
	}

}