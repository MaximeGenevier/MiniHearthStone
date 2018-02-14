/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

import fr.hearthstone.main.designpattern.decorator.Charge;
import fr.hearthstone.main.designpattern.decorator.Provocation;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.commun.ChefDeRaid;
import fr.hearthstone.main.modele.carte.serviteur.commun.ChevaucheurDeLoup;
import fr.hearthstone.main.modele.carte.serviteur.commun.SanglierBrocheroc;
import fr.hearthstone.main.modele.carte.serviteur.commun.SoldatDuComteDeLOr;
import fr.hearthstone.main.modele.carte.serviteur.commun.YetiNoroit;
import fr.hearthstone.main.modele.carte.serviteur.mage.Mouton;
import fr.hearthstone.main.modele.carte.serviteur.mage.Reflet;
import fr.hearthstone.main.modele.carte.sort.mage.ExplosionDesArcanes;
import fr.hearthstone.main.modele.carte.sort.mage.ImageMiroir;
import fr.hearthstone.main.modele.carte.sort.mage.Metamorphose;

/**
 * @author Maxime GENEVIER
 * 
 * Factory concrète pour le mage
 * Permet de créer les cartes communes
 * et celles propres au mage
 */
public class CarteMageFactory extends CarteFactory{

	@Override
	protected Carte makeCard(String name, Joueur player) {
		
		Carte card;
		
		switch(name) {
			case "ChefDeRaid" :
				card = new ChefDeRaid(player);
				break;
			case "ChevaucheurDeLoup" :
				card = new Charge( new ChevaucheurDeLoup(player));
				break;
			case "SanglierBrocheroc" :
				card = new SanglierBrocheroc(player);
				break;
			case "SoldatDuComteDeLor" :
				card = new Provocation(new SoldatDuComteDeLOr(player));
				break;
			case "YetiNoroit" : 
				card = new YetiNoroit(player);
				break;
			case "Mouton" : 
				card = new Mouton(player);
				break;
			case "Reflet" :
				card = new Provocation(new Reflet(player));
				break;
			case "ExplosionDesArcanes" :
				card = new ExplosionDesArcanes(player);
				break;
			case "ImageMiroir" : 
				card = new ImageMiroir(player);
				break;
			case "Metamorphose" : 
				card = new Metamorphose(player);
				break;
			default : 
				return null;
		}
		
		return card;
	}

}
