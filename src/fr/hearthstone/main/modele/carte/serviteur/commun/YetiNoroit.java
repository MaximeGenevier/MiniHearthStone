/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.commun;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class YetiNoroit extends Serviteur{

	public YetiNoroit(Joueur player) {
		this.name = "Yéti noroit";
		this.manaCost = 4;
		this.maxHealth = 5;
		this.currentHealth = this.maxHealth;
		this.attack = 4;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
