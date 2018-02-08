package fr.hearthstone.test.modele.carte;

import org.junit.Test;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.designpattern.factory.CarteMageFactory;
import fr.hearthstone.main.designpattern.factory.CartePaladinFactory;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;

public class ServiteurTest {

	/*
	 * @Test public void factoryServiteurTest() {
	 * 
	 * Joueur joueur1 = new Joueur("Bolvar Fordragon");
	 * 
	 * Hero paladin = new Paladin(joueur1); joueur1.setHero(paladin);
	 * 
	 * Joueur joueur2 = new Joueur("Kadgar");
	 * 
	 * Hero mage = new Mage(joueur2); joueur2.setHero(mage);
	 * 
	 * Joueur joueur3 = new Joueur("Magni Barbe de Bronze");
	 * 
	 * Hero guerrier = new Guerrier(joueur3); joueur3.setHero(guerrier);
	 * 
	 * CarteFactory factoryJ1 = new CartePaladinFactory(); CarteFactory factoryJ2 =
	 * new CarteMageFactory(); CarteFactory factoryJ3 = new CarteGuerrierFactory();
	 * 
	 * for(int i = 0; i < 10; i++) {
	 * 
	 * Carte drawCardJ1 = joueur1.drawCard(factoryJ1); displayCard(drawCardJ1);
	 * 
	 * } for(int i = 0; i < 10; i++) {
	 * 
	 * Carte drawCardJ2 = joueur2.drawCard(factoryJ2); displayCard(drawCardJ2);
	 * 
	 * } for(int i = 0; i < 10; i++) {
	 * 
	 * Carte drawCardJ3 = joueur3.drawCard(factoryJ3); displayCard(drawCardJ3);
	 * 
	 * }
	 * 
	 * }
	 */

	@Test
	public void combatServiteurTest() {
		Joueur joueur1 = new Joueur("Bolvar Fordragon");

		Hero paladin = new Paladin(joueur1);
		joueur1.setHero(paladin);

		Joueur joueur2 = new Joueur("Kadgar");

		Hero mage = new Mage(joueur2);
		joueur2.setHero(mage);

		CarteFactory factoryJ1 = new CartePaladinFactory();
		CarteFactory factoryJ2 = new CarteMageFactory();

		for(int i = 0; i < 10; i++) {
			joueur1.drawCard(factoryJ1);
		}
		joueur1.displayCardsInHand();
	}

	private void displayCard(Carte card) {
		System.out.println(card.toString());
	}

}
