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
 * @author Maxime GENEVIER
 *
 * Classe principale de l'application
 *
 */
public class MiniHearthstone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("BIENVENUE SUR HEARTHSTONE\nSuite à des problèmes techniques nous avons perdu\n"
				+ "l interface graphique du jeu. Blizzard travaille sur la résolution de ce problème.\n\n");
		
		Joueur playerOne = selectHeroPlayer(); // Créé 2 joueurs
		Joueur playerTwo = selectHeroPlayer();
		playerOne.setEnemy(playerTwo); // Définit les ennemis
		playerTwo.setEnemy(playerOne);
		
		ControleurJeu controleur = new ControleurJeu(playerOne, playerTwo); // Créé le controleur de jeu
		controleur.gameBegins(); // Début du jeu
		
	}
	
	/**
	 * Créé un joueur, ajoute le héro choisi
	 * @return Joueur joueur créé
	 */
	private static Joueur selectHeroPlayer() {
		Joueur joueur = new Joueur("");
		joueur.setHero(chooseHero(joueur));
		return joueur;
	}
	
	
	/**
	 * Récupère le héro choisi par le joueur passé en paramètre
	 * @param player Joueur en cours de création
	 * @return Hero héro choisi
	 */
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
	
	/**
	 * Récupère le choix du joueur
	 * @return
	 */
	@SuppressWarnings("resource")
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
