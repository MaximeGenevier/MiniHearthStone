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
 * Créé lorsque le mage utilise ImageMiroir
 * Possède Provocation
 *
 */
public class Reflet extends Serviteur{

	/**
	 * @param player
	 */
	public Reflet(Joueur player) {
		this.name = "Image miroir";
		this.manaCost = 0;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 0;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
