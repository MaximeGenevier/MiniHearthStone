/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

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
 * @author Maxime
 *
 */
public class CarteMageFactory extends CarteFactory{

	@Override
	public Carte makeCard(String name) {
		
		Carte card;
		
		switch(name) {
			case "ChefDeRaid" :
				card = new ChefDeRaid();
				break;
			case "ChevaucheurDeLoup" :
				card = new ChevaucheurDeLoup();
				break;
			case "SanglierBrocheroc" :
				card = new SanglierBrocheroc();
				break;
			case "SoldatDuComteDeLor" :
				card = new SoldatDuComteDeLOr();
				break;
			case "YetiNoroit" : 
				card = new YetiNoroit();
				break;
			case "Mouton" : 
				card = new Mouton();
				break;
			case "Reflet" :
				card = new Reflet();
				break;
			case "ExplosionDesArcanes" :
				card = new ExplosionDesArcanes();
				break;
			case "ImageMiroir" : 
				card = new ImageMiroir();
				break;
			case "Metamorphose" : 
				card = new Metamorphose();
				break;
			default : 
				return null;
		}
		
		return card;
	}

}
