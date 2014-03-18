public class Declaration{
	
	/* �a se passe de commentaires ! Mais on va faire un effort*/
	
	private static String identAStocker;
	private static String typeAStocker;
        private static int entierAStocker;
        private static int offset;
        
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
        }//incr�mentation de l'offset pour les variables
        
        /* On regroupe finalement toutes les informations dans un tableau qu'on pourra afficher */
      
        public void remplirTableauVar(){
        	IdVar idVar =  new IdVar(this.typeAStocker,this.offset);
  	   	Yaka.tabIdent.rangeIdent(this.identAStocker,idVar);
  	}
  	
  	 public void remplirTableauConst(){
        	IdConst idConst = new IdConst(this.typeAStocker,this.entierAStocker);	
   	        Yaka.tabIdent.rangeIdent(this.identAStocker, idConst);
  	}
	
}