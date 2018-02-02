/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime
 *
 */
public abstract class CarteFactory {

	public Carte pickCard(String name) {
		Carte card = this.makeCard(name);
		return card;
	}
	
	public abstract Carte makeCard(String name);
	
}
