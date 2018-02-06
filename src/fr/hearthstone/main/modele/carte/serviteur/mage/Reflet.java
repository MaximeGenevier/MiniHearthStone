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
public class Reflet extends Serviteur{

	public Reflet(Joueur player) {
		this.name = "Reflet";
		this.manaCost = 0;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 0;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
