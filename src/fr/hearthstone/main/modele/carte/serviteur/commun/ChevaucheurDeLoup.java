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
 * Possède charge et peut attaquer des son utilisation
 *
 */
public class ChevaucheurDeLoup extends Serviteur{

	/**
	 * @param player
	 */
	public ChevaucheurDeLoup(Joueur player) {
		this.name = "Chevaucheur de loup";
		this.manaCost = 3;
		this.maxHealth = 1;
		this.currentHealth = this.maxHealth;
		this.attack = 3;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
