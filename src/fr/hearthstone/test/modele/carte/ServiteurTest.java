package fr.hearthstone.test.modele.carte;

import org.junit.Test;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.designpattern.factory.CarteGuerrierFactory;
import fr.hearthstone.main.designpattern.factory.CarteMageFactory;
import fr.hearthstone.main.designpattern.factory.CartePaladinFactory;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.hero.Guerrier;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;
import sun.security.provider.DSAPublicKeyImpl;

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

		Carte carteJ1 = joueur1.drawCard(factoryJ1);
		Carte carteJ2 = joueur2.drawCard(factoryJ2);
		System.out.println("BEFOR ANYTHING");
		displayCard(carteJ1);
		displayCard(carteJ2);
		for (int i = 0; i < 5; i++) {
			System.out.println("BEFORE ATTACK");
			displayCard(carteJ2);
			((Serviteur) carteJ1).attack(((Serviteur) carteJ2));
			System.out.println("AFTER ATTACK");
			displayCard(carteJ2);
		}
	}

	private void displayCard(Carte card) {
		System.out.println(card.toString());
	}

}
