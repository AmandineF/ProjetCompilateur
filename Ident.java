
public abstract class Ident {
	
	//attribut
	protected String type;// prend "BOOLEEN" ou "ENTIER" comme seules valeurs

	//méthode de récupération du type
	public String getType(){
		return type;
	}
	public abstract int getValue();
	public abstract void show(String s);
}                                                   
