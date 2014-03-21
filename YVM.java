public class YVM {
        protected String programme;
        protected String operateurAdd, operateurMul, opNeg;
        protected int nbVar=2, store;
        protected boolean arret;

        
        public void stop(boolean b){
		//arret du programme si b = false
	if(b){}
		else{
			arret = true;
		}
	}
	/* Fonction permetant de gérer la traduction de debut et de fin du progamme*/
        public void entete() {
        	if (!arret){
        		this.programme="entete\n";
                }
        }
           
        public void queue() {
        	if (!arret){
			this.programme+="queue\n";
			//Ecriture.ecrireString(this.programme);
		}
        }
        
        public void incVar(){
        	if (!arret){
        		this.nbVar+=2;  // On incrémente de 2 la valeur qui s'affiche derrière ouvrePrinc à chaque variable lue
        	}
        }
        
        public void ouvrePrinc() {
        	if (!arret){
        		this.programme+="ouvrePrinc "+this.nbVar+"\n";
        	}
        }
        /* Fonction permettant de stocker les informations lues et traduite plus tard */
        
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
        
        public void stockerOppose(){
        	this.opNeg="ineg";
        }
        
        public void stockerNeg() {
        	this.opNeg="inot";
        }
        
         public void offsetStore() {
        	this.store=Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue();
        	// Pour l'affectation, on cherche l'offset de la variable affectée qu'on affichera plus tard 
        }
        
        /* Traduction imédiate */
        
        public void ecrireEnt(){
        	this.programme+="ecrireEnt\n";
        }
        
        public void ecrireChaine() {
        	if (!arret){
        		this.programme+="ecrireChaine "+YakaTokenManager.chaineLue+"\n";
        	} 
        }
        
        public void lireEnt() {
        	if (!arret){
        		this.programme+="lireEnt "+ Yaka.tabIdent.chercheIdent(YakaTokenManager.identLu).getValue()+"\n";
        		// On récupère l'offset de la variable à lire
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
        public void charger(Ident i){
        	if (i instanceof IdVar){
        		iLoad();
        	}else {iConst();}
        }
        
        /* Réutilisation des éléments stockés */
        
        public void afficherOperateurAdd(){
        	if (!arret){
        		this.programme+=this.operateurAdd + "\n";
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
        
        public void afficherNeg() {
        	this.programme+=this.opNeg+"\n";
        }
        
        public String genere(){
        	return programme;
        }
     
       
}
