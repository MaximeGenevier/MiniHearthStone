/**
 * 
 */
package fr.hearthstone.main.vue;

import java.util.Scanner;

import fr.hearthstone.main.controleur.ControleurJeu;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.hero.Guerrier;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;

/**
 * @author maxime
 *
 */
public class MiniHearthstone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*Joueur joueur1 = new Joueur("Arthas Menethil");
		Joueur joueur2 = new Joueur("Antonidas");
		
		Hero paladin = new Paladin(joueur1);
		Hero mage = new Mage(joueur2);
		
		joueur1.setHero(paladin);
		joueur2.setHero(mage);
		
		joueur1.setEnemy(joueur2);
		joueur2.setEnemy(joueur1);*/
		
		Joueur playerOne = selectHeroPlayer();
		Joueur playerTwo = selectHeroPlayer();
		playerOne.setEnemy(playerTwo);
		playerTwo.setEnemy(playerOne);
		
		ControleurJeu controleur = new ControleurJeu(playerOne, playerTwo);
		controleur.gameBegins();
		
	}
	
	private static Joueur selectHeroPlayer() {
		Joueur joueur = new Joueur("");
		joueur.setHero(chooseHero(joueur));
		return joueur;
	}
	
	private static Hero chooseHero(Joueur player) {
		System.out.println("Choisissez un héro : \n1. Guerrier\n2. Mage\n3. Paladin");
		int choice = recoverPlayerChoice();
		while(choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Choisissez un héro : \n1. Guerrier\n2. Mage\n3. Paladin");
			choice = recoverPlayerChoice();
		}
		if(choice == 1) {
			player.setName("Aggramar le Vengeur");
			return new Guerrier(player);
		}else if(choice == 2) {
			player.setName("Malygos le Lieur de Sorts");
			return new Mage(player);
		}else{
			player.setName("Grand Exarque Turalyon");
			return new Paladin(player);
		}
		
	}
	
	private static int recoverPlayerChoice() {
		Scanner scanner = new Scanner(System.in);
		boolean error = true;
		int choice = -1; // Variable pour récupérer le choix de l'utilisateur sous forme d'entier
		while(error) {	// Tant que error vaut vrai
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();
			}else {
				System.out.println("Choisissez un héro : ");
				scanner.next();
				continue;
			}
			error = false;
		}
		return choice;
	}

}
