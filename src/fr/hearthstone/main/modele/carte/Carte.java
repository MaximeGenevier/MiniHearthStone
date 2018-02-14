/**
 * 
 */
package fr.hearthstone.main.modele.carte;

import fr.hearthstone.main.modele.Joueur;

/**
 * @author Maxime GENEVIER
 * 
 * Carte abstraite 
 * Une carte connait son nom, sa description, son cout et le 
 * joueur a laquelle elle appartient
 *
 */
public abstract class Carte {

	protected String 	name;			// Le nom de la carte
	protected String 	description;	// La description
	protected int 		manaCost;		// Le cout en mana
	protected Joueur 	player;			// Le joueur de la carte
	
	/**
	 * Constructeur vide
	 */
	public Carte() {
		super();
	}
	
	/**
	 * @param name
	 * @param manaCost
	 * @param player
	 * @param description
	 */
	public Carte(String name, int manaCost, Joueur player, String description) {
		super();
		this.name = name;
		this.manaCost = manaCost;
		this.player = player;
		this.description = description;
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
		String desc = "[CARTE]\t{NOM} = " + this.getName() + "\n\t{COUT} = " + this.getManaCost() 
			+ "\t{DESCRIPTION} = " + this.description + "\n";
		return desc;
	}
	
	@Override
	public String toString() {
		return this.getPlayer().toString() + "\n" + this.getPlayer().getHero().toString() 
				+ "\n" + this.describe();
	}
	
}
