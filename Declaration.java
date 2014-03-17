public class Declaration{
	
	private static String identAStocker;
	private static String typeAStocker;
        private static int entierAStocker;
        private static int offset;
        
        
        public void stockerIdent(){
        	this.identAStocker = YakaTokenManager.identLu;
        }
        
        public void stockerEntier(int n){
        	this.entierAStocker = n;
        }
        
        public void stockerType(String type){
        	this.typeAStocker = type;
        }
        
        public void calculerOffset(){
        	this.offset = this.offset-2;
        }
        
        public void remplirTableauVar(){
        	IdVar idVar =  new IdVar(this.typeAStocker,this.offset);
  	   	Yaka.tabIdent.rangeIdent(this.identAStocker,idVar);
  	}
  	
  	 public void remplirTableauConst(){
        	IdConst idConst = new IdConst(this.typeAStocker,this.entierAStocker);	
   	        Yaka.tabIdent.rangeIdent(this.identAStocker, idConst);
  	}
	
}