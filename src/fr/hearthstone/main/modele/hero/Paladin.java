/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.designpattern.factory.CartePaladinFactory;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.competence.Renfort;

/**
 * @author Maxime GENEVIER
 * 
 * Paladin : type de héro avec la compétence Renfort
 *
 */
public class Paladin extends Hero{

	/**
	 * @param player
	 */
	public Paladin(Joueur player) {
		super("Paladin", player);
		this.ability = new Renfort(this);
		this.factory = new CartePaladinFactory();
		
		// Cartes propres au paladin
		this.addAvailableCardName("ChampionFrisselame");
		this.addAvailableCardName("BenedictionDePuissance");
		this.addAvailableCardName("Consecration");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 * Actually not used. Should be implemented with news functions like heroes weapons
	 */
	public void attack(Cible target) {
		
	}

}
