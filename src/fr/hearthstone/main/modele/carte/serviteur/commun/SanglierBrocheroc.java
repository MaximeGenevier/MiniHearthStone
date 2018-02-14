/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.commun;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur concret commun
 *
 */
public class SanglierBrocheroc extends Serviteur{

	/**
	 * @param player
	 */
	public SanglierBrocheroc(Joueur player) {
		this.name = "Sanglier brocheroc";
		this.manaCost = 1;
		this.maxHealth = 1;
		this.currentHealth = this.maxHealth;
		this.attack = 1;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
