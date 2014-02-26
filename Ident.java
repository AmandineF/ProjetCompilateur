
public abstract class Ident {
	
	//attribut
	protected String type;// prend "boolean" ou "int" comme seules valeurs

	//méthode de récupération du type
	public String getType(){
		return type;
	}
	public abstract int getValue();
	public abstract void show(String s);
}                                                   
