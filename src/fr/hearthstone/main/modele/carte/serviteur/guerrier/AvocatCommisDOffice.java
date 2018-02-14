/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.guerrier;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur concret du guerrier
 * Possède provocation
 *
 */
public class AvocatCommisDOffice extends Serviteur{

	/**
	 * @param player
	 */
	public AvocatCommisDOffice(Joueur player) {
		this.name = "Avocat commis d'office";
		this.manaCost = 2;
		this.maxHealth = 7;
		this.currentHealth = this.maxHealth;
		this.attack = 0;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
