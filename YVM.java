public class YVM {
        private String programme;
        private int nbVar=2;
        private boolean arret = false;
        
        public void stop(boolean b){
		//arret du programme si b = false
		if(b){}
		else{
			arret = true;
		}
	}
        
        public void entete() {
        	if (arret) break;
                this.programme="entete\n";
        }
        
        public void incVar(){
        	if (arret) break;
        	this.nbVar+=2;
        }
        
        public void ouvrePrinc() {
        	if (arret) break;
                this.programme+="ouvrePrinc "+this.nbVar+"\n";
        }
        
        public void ecrireChaine() {
        	if (arret) break;
        	this.programme+="ecrireChaine "+YakaTokenManager.chaineLue+"\n";
        }
        
        public void lireEnt() {
        	if (arret) break;
        	this.programme+="lireEnt "+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"\n";
        }
        
        public void aLaLigne() {
        	if (arret) break;
        	this.programme+="aLaLigne\n";
        }
        
        public void traduction() {
        	if (arret) break;
        	this.var();
        	this.calcul();
        	this.ecrireEnt();
        }
        
        public void var(){
        }
        
        public void calcul(){
        }
        
        public void ecrireEnt(){
        }
        
        public void iConst() {
        }
        
        public void iLoad(){
        }
        
        public void iAdd() {
        }
        
        public void iDiv() {
        }
        
        public void iSub(){
        }
        
        public void iOr(){
        }
        
        public void iMul() {
        }
        
        public void iAnd() {
        }
        
        public void oppose(){
        }
        
        public void neg() {
        }
        
        public void queue() {
        	if (arret) break;
        	this.programme+="queue\n";
        	System.out.println(this.programme);
        }
       
}
