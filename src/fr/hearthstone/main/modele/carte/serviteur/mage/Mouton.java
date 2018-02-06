/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.mage;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class Mouton extends Serviteur{

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
