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
import fr.hearthstone.main.modele.carte.serviteur.guerrier.AvocatCommisDOffice;
import fr.hearthstone.main.modele.carte.sort.guerrier.MaitriseDuBlocage;
import fr.hearthstone.main.modele.carte.sort.guerrier.Tourbillon;

/**
 * @author Maxime
 *
 */
public class CarteGuerrierFactory extends CarteFactory{

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
			case "AvocatCommisDOffice" :
				card = new Provocation(new AvocatCommisDOffice(player));
				break;
			case "MaitriseDuBlocage" :
				card = new MaitriseDuBlocage(player);
				break;
			case "Tourbillon" :
				card = new Tourbillon(player);
				break;
			default : 
				return null;
		}
		
		return card;
	}

}
