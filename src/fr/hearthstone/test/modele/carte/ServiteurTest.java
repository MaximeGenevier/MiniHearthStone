package fr.hearthstone.test.modele.carte;

import java.util.Scanner;

import org.junit.Test;

import fr.hearthstone.main.designpattern.observer.AffichageVieHero;
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
		
		joueur1.setEnemy(joueur2);
		joueur2.setEnemy(joueur1);
		
		AffichageVieHero affichageJ1 = new AffichageVieHero(joueur1.getHero());
		AffichageVieHero affichageJ2 = new AffichageVieHero(joueur2.getHero());
		
		//joueur1.getHero().registerObs(affichageJ1);
		joueur2.getHero().registerObs(affichageJ2);
		
		joueur1.drawCard();
		joueur1.displayCardsInHand();
		int choice = 1;
		Carte card = joueur1.getCardsInHand().get(choice-1);
		joueur1.playCard(card);
		choice = 1;
		card = joueur1.getPlayedCards().get(choice-1);
		((Serviteur)card).attack(joueur1.getEnemy().getHero());		
		
	}

	private void displayCard(Carte card) {
		System.out.println(card.toString());
	}
	
	private int getChoice() {
		// Tant qu'erreur vaut vrai
		boolean error = true;
		Scanner scanner = new Scanner(System.in); // Scanner pour lire les choix de l'utilisateur
		int choix = -1; // Variable pour récupérer le choix de l'utilisateur sous forme d'entier
		while(error) {

			if(scanner.hasNextInt()) {
				choix = scanner.nextInt();
			}else {
				System.out.println("Saisissez le chiffre correspondant à la carte voulue.");
				scanner.next();
				continue;
			}

			error = false;

		}
		return choix;

	}

}
