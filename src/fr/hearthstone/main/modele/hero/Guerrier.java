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
public class Guerrier extends Hero{

	public Guerrier(Joueur player) {
		super("Guerrier", player);
		this.addAvailableCardName("AvocatCommisDOffice");
		this.addAvailableCardName("MaitriseDuBlocage");
		this.addAvailableCardName("Tourbillon");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 * Actually not used. Should be implemented with new function like heroes weapons
	 */
	@Override
	public void attack(Cible target) {
		
	}

}
