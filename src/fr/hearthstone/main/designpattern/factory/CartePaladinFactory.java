/**
 * 
 */
package fr.hearthstone.main.designpattern.factory;

import fr.hearthstone.main.designpattern.decorator.Charge;
import fr.hearthstone.main.designpattern.decorator.Provocation;
import fr.hearthstone.main.designpattern.decorator.VolDeVie;
import fr.hearthstone.main.modele.Joueur;
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
 * @author Maxime GENEVIER
 * 
 * Factory concrète pour le paladin
 * Permet de créer les cartes communes
 * et celles propres au paladin
 */
public class CartePaladinFactory extends CarteFactory{

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
			case "ChampionFrisselame" :
				card = new Charge(new VolDeVie(new ChampionFrisselame(player)));
				break;
			case "RecrueDeLaMainDArgent" : 
				card = new RecrueDeLaMainDArgent(player);
				break;
			case "BenedictionDePuissance" :
				card = new BenedictionDePuissance(player);
				break;
			case "Consecration" :
				card = new Consecration(player);
				break;
			default:
				return null;
		}
		
		return card;
	}

}
