/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.mage;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur concret du mage
 * Créé lorsque le mage utilise Métamorphose
 * Remplace le serviteur ciblé par le sort par
 * celui ci
 *
 */
public class Mouton extends Serviteur{

	/**
	 * @param player
	 */
	public Mouton(Joueur player) {
		this.name = "Mouton";
		this.manaCost = 0;
		this.maxHealth = 1;
		this.currentHealth = this.maxHealth;
		this.attack = 1;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
