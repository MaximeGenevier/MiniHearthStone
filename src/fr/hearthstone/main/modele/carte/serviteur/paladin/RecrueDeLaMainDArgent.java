/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.paladin;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class RecrueDeLaMainDArgent extends Serviteur{

	public RecrueDeLaMainDArgent(Joueur player) {
		this.name = "Recrue de la main d'argent";
		this.manaCost = 0;
		this.maxHealth = 1;
		this.currentHealth = this.maxHealth;
		this.attack = 1;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
