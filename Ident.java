/**
 * Ident est la classe g�rant les Idents ; classe abstraite
 * @author Chassing Frank, Bignon Baptiste, Fouillet Amandine, Leparquier Mathilde
 */
public abstract class Ident {

	//attribut
	protected String type;// prend "BOOLEEN" ou "ENTIER" comme seules valeurs

	/**
	 * R�cup�re le type de l'Ident courant
	 * @return string : type (boolean or String)
	 */
	public String getType(){
		return type;
	}

	public abstract int getValue();
	public abstract void show(String s);
}                                                   
