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
 * Possède provocation
 *
 */
public class SoldatDuComteDeLOr extends Serviteur{

	/**
	 * @param player
	 */
	public SoldatDuComteDeLOr(Joueur player) {
		this.name = "Soldat du comté de l'or";
		this.manaCost = 1;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 1;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
