public class YVM {
        protected String programme;
        protected String testIter;
        protected String operateurAdd, operateurMul, opNeg;
        protected int nbVar=2, store, incrIter, incrCond;
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
        		this.nbVar = 2;
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
        
        //concernant les itérations
        public void stockerEgal() {
        	this.testIter="iegal";
        }
        
         public void stockerDiff() {
        	this.testIter="idiff";
        }
        
         public void stockerInfStrict() {
        	this.testIter="iinf";
        }
        
        public void stockerInfEgal() {
        	this.testIter="iinfegal";
        }
       
        public void stockerSupEgal() {
        	this.testIter="isupegal";
        }
        
        public void stockerSupStrict() {
        	this.testIter="isup";
        }
        
        public void numCond() {
        	this.incrCond ++;
        }
        
        /* Traduction imédiate */
        
        public void ecrireEnt(){
        	if (!arret){
        		this.programme+="ecrireEnt\n";
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
        		// On récupère l'offset de la variable à lire
        	}
        }
        
        public void aLaLigne() {
        	if (!arret){
        		this.programme+="aLaLigne\n";
        	}
        }
               
        public void iConst(Ident i) {
        	if (!arret){
        		this.programme+="iconst "+i.getValue()+"\n";
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
        	}else {iConst(i);}
        }
        
         public void faire() {
        	if (!arret){
        		this.incrIter++;
        		this.programme+="FAIRE"+this.incrIter+":\n";
        		// icrIter est incémenté, il permet d'indiquer le numero de la boucle tantque
        	}
        }
        
         public void fait() {
        	if (!arret){
   
        		this.programme+="goto FAIRE"+this.incrIter+"\nFAIT"+this.incrIter+":\n";
        		
        	}
        }
        
        public void sinon() {
        	if (!arret){
   
        		this.programme+="goto FSI"+this.incrCond+"\nSINON"+this.incrCond+":\n";
        		
        	}
        }
        
        public void fsi() {
        	if (!arret){
   
        		this.programme+="FSI"+this.incrCond+":\n";
        		
        	}
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
        public void afficherCompare(){}
        
        public void afficherNeg() {
        	this.programme+=this.opNeg+"\n";
        }
        
        public void iter() {
        	if (!arret){
        		this.programme+=this.testIter+"\niffaux FAIT"+this.incrIter+"\n";
        	}
        }
         public void cond() {
         	 if (!arret){
         	 	 this.programme+=this.testIter+"\niffaux SINON"+this.incrCond+"\n";
        	 }
        }
        
        public String genere(){
        	return programme;
        }
     
       
}
