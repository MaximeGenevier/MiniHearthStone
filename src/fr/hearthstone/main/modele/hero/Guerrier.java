/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.designpattern.factory.CarteGuerrierFactory;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.competence.Armure;

/**
 * @author Maxime GENEVIER
 * 
 * Guerrier : type de héro avec la compétence Armure
 *
 */
public class Guerrier extends Hero{

	/**
	 * @param player
	 */
	public Guerrier(Joueur player) {
		super("Guerrier", player);
		this.ability = new Armure(this);
		this.factory = new CarteGuerrierFactory();
		
		// Cartes propres au guerrier
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
