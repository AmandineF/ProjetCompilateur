
public abstract class Ident {
	
	//attribut
	protected String type;// prend "BOOLEEN" ou "ENTIER" comme seules valeurs

	//m�thode de r�cup�ration du type
	public String getType(){
		return type;
	}
	public abstract int getValue();
	public abstract void show(String s);
}                                                   
