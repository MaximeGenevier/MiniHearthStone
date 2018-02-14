package fr.hearthstone.main.modele.carte.serviteur.commun;

import java.util.ArrayList;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur concret commun
 * Ce serviteur increment l'attaque des serviteurs alliés de 1
 *
 */
public class ChefDeRaid extends Serviteur{

	private ArrayList<Serviteur> minionsAssisted; // Alliés dont l'attaque a été augmenté pour ne pas impacté tout les serviteurs lors de la mort
	
	/**
	 * @param player
	 */
	public ChefDeRaid(Joueur player) {
		this.name = "Chef de raid";
		this.manaCost = 3;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 2;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
		
		minionsAssisted = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.serviteur.Serviteur#proceed()
	 */
	@Override
	public void proceed() {
		for(Carte card : this.getPlayer().getPlayedCards()) {
			((Serviteur)card).increaseAttack(1);
			minionsAssisted.add(((Serviteur)card));
		}
		this.decreaseAttack(1);
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.serviteur.Serviteur#die()
	 */
	@Override
	public void die() {
		for(Carte card : this.getPlayer().getCardsInHand()) {
			if(minionsAssisted.contains(((Serviteur)card))){ // Si le serviteur courrant est dans la liste des serviteurs assistés
				((Serviteur)card).decreaseAttack(1);	// décremente l'attaque de 1
			}
		}
		super.die();
	}

}
