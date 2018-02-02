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
import fr.hearthstone.main.modele.carte.serviteur.guerrier.AvocatCommisDOffice;
import fr.hearthstone.main.modele.carte.sort.guerrier.MaitriseDuBlocage;
import fr.hearthstone.main.modele.carte.sort.guerrier.Tourbillon;

/**
 * @author Maxime
 *
 */
public class CarteGuerrierFactory extends CarteFactory{

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
			case "AvocatCommisDOffice" :
				card = new AvocatCommisDOffice();
				break;
			case "MaitriseDuBlocage" :
				card = new MaitriseDuBlocage();
				break;
			case "Tourbillon" :
				card = new Tourbillon();
				break;
			default : 
				return null;
		}
		
		return card;
	}

}
