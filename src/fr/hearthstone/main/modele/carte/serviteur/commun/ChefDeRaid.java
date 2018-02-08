package fr.hearthstone.main.modele.carte.serviteur.commun;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

public class ChefDeRaid extends Serviteur{

	public ChefDeRaid(Joueur player) {
		this.name = "Chef de raid";
		this.manaCost = 3;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 2;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

	@Override
	public void proceed() {
		for(Carte card : this.getPlayer().getCardsInHand()) {
			((Serviteur)card).increaseAttack(1);
		}
	}

}
