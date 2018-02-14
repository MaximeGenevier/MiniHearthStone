/**
 * 
 */
package fr.hearthstone.main.controleur;

import java.util.Scanner;

import fr.hearthstone.main.designpattern.observer.AffichageVieHero;
import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;
import fr.hearthstone.main.modele.hero.Mage;

/**
 * @author maxime
 * 
 * Classe qui gère le déroulement du jeu
 *
 */
public class ControleurJeu {

	private Joueur playerOne;
	private Joueur playerTwo;
	private AffichageVieHero displayPlayerOne;
	private AffichageVieHero displayPlayerTwo;
	private int	round;
	private Scanner scanner;
	
	public ControleurJeu(Joueur pOne, Joueur pTwo) {
		this.playerOne = pOne;
		this.playerTwo = pTwo;
		
		displayPlayerOne = new AffichageVieHero(playerOne.getHero());
		displayPlayerTwo = new AffichageVieHero(playerTwo.getHero());
		
		playerOne.getHero().registerObs(displayPlayerOne);
		playerTwo.getHero().registerObs(displayPlayerTwo);
		
		this.round = 1;
		scanner = new Scanner(System.in); // Scanner pour lire les choix de l'utilisateur
		initGame();
	}
	
	
	/**
	 * Initialise la partie
	 * Détermine quel joueur commence, et lui fait piocher 3 cartes
	 * L'autre joueur pioche 4 cartes
	 */
	private void initGame() {
		int random = 0 + (int)(Math.random() * 2);
		if(random == 0) {
			System.out.println(playerOne.toString());
			playerOne.setShouldPlay(true);
			for(int i = 0; i < 3; i++) {
				playerOne.drawCard();
			}
			System.out.println(playerTwo.toString());
			for(int i = 0; i < 4; i++) {
				playerTwo.drawCard();
			}			
		}else {
			System.out.println(playerTwo.toString());
			playerTwo.setShouldPlay(true);
			for(int i = 0; i < 3; i++) {
				playerTwo.drawCard();
			}
			System.out.println(playerOne.toString());
			for(int i = 0; i < 4; i++) {
				playerOne.drawCard();
			}
		}
	}
	
	/**
	 * Appelée pour débuter le jeu
	 * Tant que les deux joueurs ont des PV le jeu continue
	 */
	public void gameBegins() {
		while(playerOne.getHero().getCurrentHealth() > 0 && playerTwo.getHero().getCurrentHealth() > 0) {
			System.out.println("Tour " + round);
			roundBegins();
			round++;
		}
		gameEnds();
	}
	
	/**
	 * A la fin du jeu on demande au joueur s'il veut recommencer
	 */
	private void gameEnds() {
		System.out.println("Voulez vous rejouer?\n1. Oui\n2. Non\n");
		int choice = recoverPlayerChoice();
		if(choice == 1) {
			initGame();
		}else {
			scanner.close();
		}
	}
	
	/**
	 * Début d'un tour
	 * Affiche le joueur et autorise l'attaque des serviteurs de son plateau
	 * Propose 5 options au joueur
	 * Poser une carte
	 * Joueur un serviteur
	 * Utiliser sa compétence héroique
	 * Afficher son héro
	 * Passer son tour
	 * 
	 * Chaque choix renvoie à une action précise
	 */
	private void roundBegins() {
		Joueur playerThatSPlaying = getPlayerThatShouldPlay();
		playerThatSPlaying.drawCard();
		for(Carte minion : playerThatSPlaying.getPlayedCards()) {
			((Serviteur)minion).setCanAttack(true);
		}
		System.out.println("A votre tour " + playerThatSPlaying.getName() + "!");
		System.out.println(playerThatSPlaying.getHero());
		System.out.println("1. Poser une carte\n2. Jouer un serviteur\n3. Compétence héroïque\n4. Afficher héro\n5. Passer le tour");
		int choice = recoverPlayerChoice();
		while(choice != 5) {
			if(choice == 1) {
				placeCard(playerThatSPlaying);
			}else if(choice == 2){
				playCard(playerThatSPlaying);
			}else if(choice == 3) {
				playAbility(playerThatSPlaying);
			}else if(choice == 4) {
				System.out.println("Votre héro : ");
				System.out.println(playerThatSPlaying.getHero().describe()); // Affiche le héro
				System.out.println("Votre main : \n");
				playerThatSPlaying.displayCardsInHand(); // Affiche la main du joueur
				System.out.println("Votre plateau : \n");
				playerThatSPlaying.displayPlayedCards(); // Affiche le plateau du joueur	
			}else {
				continue;
			}
			System.out.println("1. Poser une carte\n2. Jouer une carte\n3. Compétence héroïque\n4. Afficher héro\n5. Passer le tour");
			choice = recoverPlayerChoice();
		}
		roundEnds(playerThatSPlaying);
	}
	
	/**
	 * @param playerThatSPlaying joueur en train de jouer
	 * 
	 * Termine le tour du joueur : incrémente son mana de 1 et le recharge, reinitialise sa compétence héroique (STATE)
	 * met à jour le joueur qui doit joueur
	 */
	private void roundEnds(Joueur playerThatSPlaying) {
		playerThatSPlaying.roundSEnd();
		updatePlayerThatShouldPlay();

	}
	
	/**
	 * @param playerThatSPlaying joueur en train de jouer
	 * 
	 * Affiche les cartes de la main 
	 * Récupère le choix du joueur
	 * pose un serviteur ou active un sort selon le choix du joueur
	 */
	private void placeCard(Joueur playerThatSPlaying) {
		System.out.println("-1. Retour");
		System.out.println("Choisissez une carte : ");
		playerThatSPlaying.displayCardsInHand();
		int choice = recoverPlayerChoice();
		while(choice != -1) {
			try {
				try {
					Serviteur minion = (Serviteur)playerThatSPlaying.getCardsInHand().get(choice-1);
					playerThatSPlaying.playMinion(minion);
				}catch(ClassCastException exc) {
					Sort spell = (Sort)playerThatSPlaying.getCardsInHand().get(choice-1);
					System.out.println("Choisissez la cible : ");
					playerThatSPlaying.getEnemy().displayTargetable();
					choice = recoverPlayerChoice() - 1;
					Cible target = (Cible)playerThatSPlaying.getEnemy().getTargetable().get(choice-1);
					playerThatSPlaying.playSpell(spell, target);
				}
			}catch (IndexOutOfBoundsException exc) {
				System.out.println("Vous devez choisir un nombre correspondant à l'un des indices.");
			}
			System.out.println("-1. Retour");
			System.out.println("Choisissez une carte : ");
			playerThatSPlaying.displayCardsInHand();
			choice = recoverPlayerChoice();
		}
	}
	
	/**
	 * @param playerThatSPlaying joueur qui joue
	 * 
	 */
	private void playCard(Joueur playerThatSPlaying) {
		System.out.println("-1. Retour");
		System.out.println("Choisissez un serviteur : ");
		playerThatSPlaying.displayPlayedCards();
		int choice = recoverPlayerChoice();
		while(choice != -1) {
			try {
				Carte card = playerThatSPlaying.getPlayedCards().get(choice-1);
				System.out.println("Choisissez la cible : ");
				playerThatSPlaying.getEnemy().displayTargetable();
				choice = recoverPlayerChoice() - 1;
				try {
					((Serviteur)card).attack(playerThatSPlaying.getEnemy().getTargetable().get(choice));
				}catch(IndexOutOfBoundsException exc) {
					System.out.println("Vous devez choisir un nombre correspondant à l'une des cibles possible.");
				}
			}catch(IndexOutOfBoundsException exc) {
				System.out.println("Vous devez choisir un nombre correspondant à l'un des indices de vos serviteurs.");
			}
			System.out.println("-1. Retour");
			System.out.println("Choisissez un serviteur : ");
			playerThatSPlaying.displayPlayedCards();
			choice = recoverPlayerChoice();
		}
	}
	
	private void playAbility(Joueur playerThatSPlaying) {
		if(playerThatSPlaying.getHero().getClass().equals(Mage.class)) {
			if(playerThatSPlaying.getHero().getAbility().getState().getClass().equals(EtatDisponible.class)) {
				Cible target = getTarget(playerThatSPlaying);
				playerThatSPlaying.getHero().getAbility().useAbility(target);
			}else {
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}else {
			playerThatSPlaying.getHero().getAbility().useAbility();
		}
	}
	
	private Cible getTarget(Joueur playerThatSPlaying){
		System.out.println("1. Alliés");
		System.out.println("2. Ennemis");
		int choice = recoverPlayerChoice();
		while(choice != 1 && choice != 2){
			System.out.println("Choix incorrect");
			System.out.println("1. Alliés");
			System.out.println("2. Ennemis");
			choice = recoverPlayerChoice();
		}
		System.out.println("Choisissez l'indice de la cible");
		Cible target;
		if(choice == 1){
			System.out.println("0. ");
			playerThatSPlaying.getHero().describe();
			playerThatSPlaying.displayPlayedCards();
			choice = recoverPlayerChoice();
			while(choice < 0 && choice > playerThatSPlaying.getPlayedCards().size()){
				System.out.println("Choix incorrect");
				choice = recoverPlayerChoice();
			}
			if(choice == 0){
				target = ((Cible)playerThatSPlaying.getHero());
			}else{
				target = ((Cible)playerThatSPlaying.getPlayedCards().get(choice - 1));
			}
		}else{
			playerThatSPlaying.getEnemy().displayTargetable();
			choice = recoverPlayerChoice();
			while(choice < 0 && choice > playerThatSPlaying.getEnemy().getTargetable().size()){
				System.out.println("Choix incorrect");
				choice = recoverPlayerChoice();
			}
			target = playerThatSPlaying.getEnemy().getTargetable().get(choice - 1);
		}
		return target;
	}
	
	private Joueur getPlayerThatShouldPlay() {
		if(playerOne.isShouldPlay()) {
			return playerOne;
		}else {
			return playerTwo;
		}
	}
	
	private Joueur getPlayerWillPlayed() {
		if(!playerOne.isShouldPlay()) {
			return playerOne;
		}else {
			return playerTwo;
		}
	}
	
	private void updatePlayerThatShouldPlay() {
		Joueur hasPlayed = getPlayerThatShouldPlay();
		Joueur willPlayed = getPlayerWillPlayed();
		hasPlayed.setShouldPlay(false);
		willPlayed.setShouldPlay(true);
	}
	
	private int recoverPlayerChoice() {
		boolean error = true;
		int choice = -1; // Variable pour récupérer le choix de l'utilisateur sous forme d'entier
		while(error) {	// Tant que error vaut vrai
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();
			}else {
				System.out.println("Choisissez une carte : ");
				scanner.next();
				continue;
			}
			error = false;
		}
		return choice;
	}
	
}
