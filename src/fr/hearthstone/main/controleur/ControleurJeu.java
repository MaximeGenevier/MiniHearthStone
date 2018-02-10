/**
 * 
 */
package fr.hearthstone.main.controleur;

import java.util.Scanner;

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
 */
public class ControleurJeu {

	private Joueur playerOne;
	private Joueur playerTwo;
	private int	round;
	private Scanner scanner;
	
	public ControleurJeu(Joueur pOne, Joueur pTwo) {
		this.playerOne = pOne;
		this.playerTwo = pTwo;
		this.round = 1;
		scanner = new Scanner(System.in); // Scanner pour lire les choix de l'utilisateur
		initGame();
	}
	
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
	
	public void gameBegins() {
		while(playerOne.getHero().getCurrentHealth() > 0 && playerTwo.getHero().getCurrentHealth() > 0) {
			System.out.println("Tour " + round);
			roundBegins();
			round++;
		}
		gameEnds();
	}
	
	private void gameEnds() {
		System.out.println("Voulez vous rejouer?\n1. Oui\n2. Non\n");
		int choice = recoverPlayerChoice();
		if(choice == 1) {
			initGame();
		}else {
			scanner.close();
		}
	}
	
	private void roundBegins() {
		Joueur playerThatSPlaying = getPlayerThatShouldPlay();
		System.out.println("A votre tour " + playerThatSPlaying.getName() + "!");
		System.out.println(playerThatSPlaying.getHero());
		while(playerThatSPlaying.getHero().getCurrentMana() > 0) {
			System.out.println("1. Poser une carte\n2. Jouer une carte\n3. Compétence héroïque\n4. Afficher héro\n5. Passer le tour");
			int choice = recoverPlayerChoice();
			if(choice == 1) {
				placeCard(playerThatSPlaying);
			}else if(choice == 2){
				playCard(playerThatSPlaying);
			}else if(choice == 3) {
				playAbility(playerThatSPlaying);
			}else if(choice == 4) {
				System.out.println("Votre héro : ");
				System.out.println(playerThatSPlaying.getHero().describe());
				System.out.println("Votre main : \n");
				playerThatSPlaying.displayCardsInHand();
				System.out.println("Votre plateau : \n");
				playerThatSPlaying.displayPlayedCards();								
			}else if(choice == 5) {
				break;
			}
		}
		roundEnds(playerThatSPlaying);
	}
	
	private void roundEnds(Joueur playerThatSPlaying) {
		playerThatSPlaying.roundSEnd();
		getPlayerWillPlayed().drawCard();
		updatePlayerThatShouldPlay();

	}
	
	private void placeCard(Joueur playerThatSPlaying) {
		System.out.println("Choisissez une carte : ");
		playerThatSPlaying.displayCardsInHand();
		int choice = recoverPlayerChoice() - 1;
		try {
			 
			try {
				Serviteur minion = (Serviteur)playerThatSPlaying.getCardsInHand().get(choice);
				playerThatSPlaying.playMinion(minion);
			}catch(ClassCastException exc) {
				Sort spell = (Sort)playerThatSPlaying.getCardsInHand().get(choice);
				System.out.println("Choisissez la cible : ");
				playerThatSPlaying.getEnemy().displayTargetable();
				choice = recoverPlayerChoice() - 1;
				Cible target = (Cible)playerThatSPlaying.getEnemy().getTargetable().get(choice);
				playerThatSPlaying.playSpell(spell, target);
			}
		}catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Vous devez choisir un nombre correspondant à l'un des indices.");
		}
	}
	
	private void playCard(Joueur playerThatSPlaying) {
		System.out.println("Choisissez un serviteur : ");
		playerThatSPlaying.displayPlayedCards();
		int choice = recoverPlayerChoice() - 1;
		try {
			Carte card = playerThatSPlaying.getPlayedCards().get(choice);
			System.out.println("Choisissez la cible : ");
			playerThatSPlaying.getEnemy().displayTargetable();
			choice = recoverPlayerChoice() - 1;
			try {
				((Serviteur)card).attack(playerThatSPlaying.getEnemy().getTargetable().get(choice));
			}catch(ArrayIndexOutOfBoundsException exc) {
				System.out.println("Vous devez choisir un nombre correspondant à l'une des cibles possible.");
			}
		}catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("Vous devez choisir un nombre correspondant à l'un des indices de vos serviteurs.");
		}
	}
	
	private void playAbility(Joueur playerThatSPlaying) {
		if(playerThatSPlaying.getHero().getClass().equals(Mage.class)) {
			if(playerThatSPlaying.getHero().getAbility().getState().getClass().equals(EtatDisponible.class)) {
				System.out.println("Choisissez la cible : ");
				playerThatSPlaying.getEnemy().displayTargetable();
				int choice = recoverPlayerChoice();
				try {
					playerThatSPlaying.getHero().getAbility().useAbility(playerThatSPlaying.getEnemy().getTargetable().get(choice));
				}catch(ArrayIndexOutOfBoundsException exc) {
					System.out.println("Vous devez choisir un nombre correspondant à l'une des cibles possible.");
				}
			}else {
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}else {
			playerThatSPlaying.getHero().getAbility().useAbility();
		}
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
