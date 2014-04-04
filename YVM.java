public class YVM {
	
		/**
		 * Attribut dans lequel on stocke la partie traduite du programme a afficher à la fin de la lecture
		 */
        protected String programme;
        
        /**
         * Attribut dans lequel on stocke l'opérateur de test des conditionnelles et des itérations
         */
        protected String testIter;
        
        /**
         * Attribut dans lequel on stocke l'opérateur d'addition
         */
        protected String operateurAdd;
        
        /**
         * Attribut dans lequel on stocke l'opérateur de multiplication
         */
        protected String operateurMul;
        
        /**
         * Attribut dans lequel on stocke l'opérateur de négation
         */
        protected String opNeg;
        
        /**
         * Attribut dans lequel on stocke le nombre de variables du programme
         */
        protected int nbVar=2;
        
        /**
         * Attribut dans lequel on stocke l'offset de la variable affectée
         */
        protected int store;
        
        /**
         * Attribut dans lequel on stocke le numero des conditionnelles
         */
        protected int incrIter;
        
        /**
         * Attribut dans lequel on stocke le numero des itérations
         */
        protected int  incrCond;
        
        /**
         * Attribut gérant l'arrêt du programme
         */
        protected boolean arret;

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
        		this.programme="entete\n";
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
        		this.programme+="ouvrePrinc "+this.nbVar+"\n";
        		this.nbVar = 2;
            }
        }
        
       /**
        * Fonction permettant de stocker l'opérateur plus
        */
        public void stockerPlus() {
        	if (!arret){
        		this.operateurAdd = "iadd";
        	}
        }
        
        /**
         * Fonction permettant de stocker l'opérateur moins
         */   
        public void stockerMoins() {
        	if (!arret){
        		this.operateurAdd = "isub";
        	}
        }
        
        /**
         * Fonction permettant de stocker l'opérateur ou
         */
        public void stockerOu() {
        	if (!arret){
        		this.operateurAdd = "ior";
        	}
        }
        
        /**
         * Fonction permettant de stocker l'opérateur diviser
         */
        public void stockerDiv() {
         	 if (!arret){
         	 	 this.operateurMul= "idiv";
         	 }
         }
        
        /**
         * Fonction permettant de stocker l'opérateur multiplier
         */
        public void stockerMul() {
        	if (!arret){
        		this.operateurMul = "imul";
        	}
        }
      
        /**
         * Fonction permettant de stocker l'opérateur et
         */
        public void stockerAnd() {
        	if (!arret){
        		this.operateurMul = "iand";
        	}
        }
        
        /**
         * Fonction permettant de stocker l'opérateur ineg
         */
        public void stockerOppose(){
        	this.opNeg="ineg";
        }
        
        /**
         * Fonction permettant de stocker l'opérateur inot
         */
        public void stockerNeg() {
        	this.opNeg="inot";
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
        }
        
        /**
         * Fonction permettant de stocker dans programme la traduction immediate de ecrireEnt
         */
        public void ecrireEnt(){
        	if (!arret){
        		this.programme+="ecrireEnt\n";
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
        public void iConst() {
        	if (!arret){
        		this.programme+="iconst "+YakaTokenManager.entierLu+"\n";
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
        	if (i instanceof IdVar){
        		iLoad();
        	}else {iConst(i);}
        }
        
        /**
         * Fonction permettant de stocker dans programme les itérations 
         * icrIter est incémenté, il permet d'indiquer le numero de la boucle tantque
         */
         public void faire() {
        	if (!arret){
        		this.incrIter++;
        		this.programme+="FAIRE"+this.incrIter+":\n";
        	}
        }
        
         /**
          * Fonction permettant de stocker dans programme la fin des itérations
          */
         public void fait() {
        	if (!arret){
        		this.programme+="goto FAIRE"+this.incrIter+"\nFAIT"+this.incrIter+":\n";
        	}
        }
        
        /**
         * Fonction permettant de stocker dans programme le sinon des conditionnelles
         */
        public void sinon() {
        	if (!arret){
        		this.programme+="goto FSI"+this.incrCond+"\nSINON"+this.incrCond+":\n";   		
        	}
        }
        
        
        /**
         * Fonction permettant de stocker dans programme le fin si des conditionnelles
         */
        public void fsi() {
        	if (!arret){
   
        		this.programme+="FSI"+this.incrCond+":\n";
        		
        	}
        }
        
        /**
         * Fonction permettant de stocker dans programme l'opérateur d'addition
         */
        public void afficherOperateurAdd(){
        	if (!arret){
        		this.programme+=this.operateurAdd + "\n";
        	}
        }
         
        /**
         * Fonction permettant de stocker dans programme l'opérateur de multiplication
         */
        public void afficherOperateurMul(){
        	if (!arret){
        		this.programme+=this.operateurMul+ "\n";
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
        public void afficherCompare(){}
        
        /**
         * Foncion permettant de stocker dans programme l'opérateur de négation
         */
        public void afficherNeg() {
        	this.programme+=this.opNeg+"\n";
        }
        
        /**
         * Fonction permettant de stocker dans programme le test des itérations
         */
        public void iter() {
        	if (!arret){
        		this.programme+=this.testIter+"\niffaux FAIT"+this.incrIter+"\n";
        	}
        }
        
        /**
         * Fonction permettant de stocker dans programme le test des conditionnelles
         */
         public void cond() {
         	 if (!arret){
         	 	 this.programme+=this.testIter+"\niffaux SINON"+this.incrCond+"\n";
        	 }
        }
        
         /**
          * Fonction permettant de générer le programme
          * @return String : le texte du programme
          */
        public String genere(){
        	return programme;
        }
     
       
}
