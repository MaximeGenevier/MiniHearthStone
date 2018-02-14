/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime GENEVIER
 * 
 * Factory abstraite
 * 
 * Permet de fabriquer des cartes selon le héro du joueur 
 * (voir les autres classes du package factory)
 * 
 * La méthode drawCard recoit en paramètre le nom de la carte à 
 * fabriquer et le joueur qui tire cette carte et renvoie la carte
 * fabriquée
 * 
 * Elle appelle la méthode privée qui créé la carte avec les mêmes 
 * paramètres
 *
 */
public abstract class CarteFactory {

	public Carte drawCard(String name, Joueur player) {
		Carte card = this.makeCard(name, player); // Créé la carte
		return card;
	}
	
	protected abstract Carte makeCard(String name, Joueur player);
	
}
