public class YVM {
        private String programme;
        private int nbVar=2;
        private boolean arret;
        
        public void entete() {
                this.programme="entete\n";
        }
        
        public void incVar(){
        	this.nbVar+=2;
        }
        
        public void ouvrePrinc() {
                this.programme+="ouvrePrinc "+this.nbVar+"\n";
        }
        
        public void ecrireChaine() {
        	this.programme+="ecrireChaine "+YakaTokenManager.chaineLue+"\n";
        }
        
        public void lireEnt() {
        	this.programme+="lireEnt "+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"\n";
        }
        
        public void aLaLigne() {
        	this.programme+="aLaLigne\n";
        }
        
        public void traduction() {
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
        	this.programme+="queue\n";
        	System.out.println(this.programme);
        }
       
}
