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
import fr.hearthstone.main.modele.carte.serviteur.paladin.ChampionFrisselame;
import fr.hearthstone.main.modele.carte.serviteur.paladin.RecrueDeLaMainDArgent;
import fr.hearthstone.main.modele.carte.sort.paladin.BenedictionDePuissance;
import fr.hearthstone.main.modele.carte.sort.paladin.Consecration;

/**
 * @author Maxime
 *
 */
public class CartePaladinFactory extends CarteFactory{

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
			case "ChampionFrisselame" :
				card = new ChampionFrisselame();
				break;
			case "RecrueDeLaMainDArgent" : 
				card = new RecrueDeLaMainDArgent();
				break;
			case "BenedictionDePuissance" :
				card = new BenedictionDePuissance();
				break;
			case "Consecration" :
				card = new Consecration();
				break;
			default:
				return null;
		}
		
		return card;
	}

}
