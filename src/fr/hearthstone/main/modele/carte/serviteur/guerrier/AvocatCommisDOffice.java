/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.guerrier;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class AvocatCommisDOffice extends Serviteur{

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
