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
public class Mage extends Hero{

	public Mage(Joueur player) {
		super("Mage", player);
		this.addAvailableCardName("Mouton");
		this.addAvailableCardName("Reflet");
		this.addAvailableCardName("ExplosionDesArcanes");
		this.addAvailableCardName("ImageMiroir");
		this.addAvailableCardName("Metamorphose");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 * Actually not used. Should be implemented with new function like heroes weapons
	 */
	@Override
	public void attack(Cible target) {
		
	}
	

}