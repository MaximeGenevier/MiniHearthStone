/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.modele.Cible;

/**
 * @author Maxime
 *
 */
public class Guerrier extends Hero{

	public Guerrier() {
		super("Guerrier");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 * Actually not used. Should be implemented with new function like heroes weapons
	 */
	@Override
	public void attack(Cible target) {
		
	}

}
