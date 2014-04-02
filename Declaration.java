public class Declaration{
	
	/* ça se passe de commentaires ! Mais on va faire un effort*/
	
	private static String identAStocker;
	private static String typeAStocker;
	private static String[] typeParam= new String[100];
        private static int entierAStocker;
        private static int offset, compterParam = -1;
        
       /*Pour chaque constante ou variable, on stocke son type, son nom et sa valeur ( offset pour les variables)*/
        
        
        public void stockerIdent(){
        	this.identAStocker = YakaTokenManager.identLu;
        }//nom
        
        public void stockerEntier(int n){
        	this.entierAStocker = n;
        }//valeur pour les constantes
        
        public void stockerType(String type){
        	this.typeAStocker = type;
        }//type
        
        public void calculerOffset(){
        	this.offset = this.offset-2;
        }//incrémentation de l'offset pour les variables
        
        public void stockerTypeParam(){
	       	compterParam++; 
	       	this.typeParam[compterParam] = this.typeAStocker;
	}
	public int getNbParam() {
	 	return compterParam;
	}
	        

        
        /* On regroupe finalement toutes les informations dans un tableau qu'on pourra afficher */
      
        public void remplirTableauVar(){
        	IdVar idVar =  new IdVar(this.typeAStocker,this.offset);
  	   	Yaka.tabIdent.rangeIdent(this.identAStocker,idVar);
  	}
  	
  	 public void remplirTableauConst(){
        	IdConst idConst = new IdConst(this.typeAStocker,this.entierAStocker);	
   	        Yaka.tabIdent.rangeIdent(this.identAStocker, idConst);
  	}
  	
  	public void remplirTableauGlobaux(){
  		IdFonction idFonction = new IdFonction(this.typeAStocker,this.typeParam);
  		Yaka.tabIdent.rangeIdentGlobaux(this.identAStocker, idFonction);
	}
}