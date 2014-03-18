public class YVM {
        private String programme;
        private String operateurAdd, operateurMul;
        private int nbVar=2, store;
        private boolean arret;
        
          public void stop(boolean b){
		//arret du programme si b = false
		if(b){}
		else{
			arret = true;
		}
	}
        public void entete() {
       	if (!arret){
                this.programme="entete\n";
        }
        }
        
        public void incVar(){
       if (!arret){
        	this.nbVar+=2;
       }
        }
        
        public void ouvrePrinc() {
       if (!arret){
                this.programme+="ouvrePrinc "+this.nbVar+"\n";
        }
        }
        
        public void ecrireChaine() {
       if (!arret){
        	this.programme+="ecrireChaine "+YakaTokenManager.chaineLue+"\n";
       } 
       }
        
        public void lireEnt() {
        	if (!arret){
        	this.programme+="lireEnt "+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"\n";
        }
        	}
        
        public void aLaLigne() {
        	if (!arret){
        	this.programme+="aLaLigne\n";
        }
        }
                   
        public void iConst() {
        	if (!arret){
       		this.programme+="iconst "+YakaTokenManager.entierLu+"\n";
        }
        }
        
        public void iLoad(){
        if (!arret){
        	this.programme+="iload " + Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue() + "\n";
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
        	this.programme+=this.operateurAdd + "\n";
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
        	this.programme+=this.operateurMul+ "\n";
        }
        }
        public void iStore(){
        if (!arret){
        	this.programme+="istore " + this.store + "\n";
        }
        }
        
        public void offsetStore() {
        	this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();
        	
        }
        public void ecrireEnt(){
        	this.programme+="ecrireEnt\n";
        }
        public void oppose(){
        }
        
        public void neg() {
        }
        
        public void queue() {
        	if (!arret){
        	this.programme+="queue\n";
        	System.out.println(this.programme);
        }
        }
       
}
