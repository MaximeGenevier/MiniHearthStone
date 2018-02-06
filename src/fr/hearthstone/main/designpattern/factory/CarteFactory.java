/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime
 *
 */
public abstract class CarteFactory {

	public Carte drawCard(String name, Joueur player) {
		Carte card = this.makeCard(name, player);
		return card;
	}
	
	protected abstract Carte makeCard(String name, Joueur player);
	
}
