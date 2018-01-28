/**
 * 
 */
package fr.hearthstone.main.modele.carte;

/**
 * @author Maxime
 *
 */
public abstract class Carte {

	private String name;
	private int manaCost;
	
	public Carte(String name, int manaCost) {
		super();
		this.name = name;
		this.manaCost = manaCost;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the manaCost
	 */
	public int getManaCost() {
		return manaCost;
	}

	/**
	 * @param manaCost the manaCost to set
	 */
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
}
