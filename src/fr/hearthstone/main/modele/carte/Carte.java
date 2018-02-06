/**
 * 
 */
package fr.hearthstone.main.modele.carte;

import fr.hearthstone.main.modele.Joueur;

/**
 * @author Maxime
 *
 */
public abstract class Carte {

	protected String name;
	protected int manaCost;
	protected Joueur player;
	
	public Carte() {
		super();
	}
	
	public Carte(String name, int manaCost, Joueur player) {
		super();
		this.name = name;
		this.manaCost = manaCost;
		this.player = player;
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

	/**
	 * @return the player
	 */
	public Joueur getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Joueur player) {
		this.player = player;
	}
	
	public String describe() {
		String desc = this.getPlayer().toString() + "\n" + this.getPlayer().getHero().toString() 
				+ "\n" + "[CARTE]\t{NOM} = " + this.getName() + "\n\t{COUT} = " + this.getManaCost();
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
