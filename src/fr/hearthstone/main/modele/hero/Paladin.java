/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;

/**
 * @author Maxime
 *
 */
public class Paladin extends Hero{

	public Paladin(Joueur player) {
		super("Paladin", player);
		this.addAvailableCardName("ChampionFrisselame");
		this.addAvailableCardName("RecrueDeLaMainDArgent");
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
