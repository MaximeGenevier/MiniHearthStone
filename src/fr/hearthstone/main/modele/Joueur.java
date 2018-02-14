package fr.hearthstone.main.modele;

import java.util.ArrayList;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;
import fr.hearthstone.main.modele.hero.Hero;


/**
 * @author Maxime GENEVIER
 * 
 * Classe Joueur
 * 
 * Un joueur possède un nom, un héro et un ennemi
 * Il sait s'il doit jouer ou non (attribut shouldPlay)
 * Et connait les cartes de sa main et qu'il a jouer (son plateau)
 * qui sont des ArrayList de Carte
 *
 */
/**
 * @author E178130U
 *
 */
public class Joueur {

	private String 				name;			// Nom du joueur : prédéfini dans la classe principale selon le héro choisi
	private Hero 				hero;			// Choisi par le joueur dans la classe principale
	private Joueur 				enemy;			// Ennemi : le second joueur (adversaire)
	private boolean 			shouldPlay;		// Permet de savoir si le joueur doit jouer si c'est au tour de son ennemi
	private ArrayList<Carte> 	cardsInHand;	// Les cartes en main
	private ArrayList<Carte> 	playedCards;	// Les cartes jouer (plateau)
	
	/**
	 * Constructeur
	 * @param name String nom du joueur
	 * Les autres attributs sont initialisés par défaut
	 */
	public Joueur(String name) {
		this.name 			= name;				
		this.shouldPlay 	= false;				// Le joueur qui commence est déterminé aléatoirement par le controleur dans ControleurJeu
		this.cardsInHand 	= new ArrayList<>();	// Les listes sont initialisées vides
		this.playedCards 	= new ArrayList<>();
	}
	
	/**
	 * Permet au joueur de piocher une carte 
	 * aléatoire et de l'ajouter dans sa main
	 * (ArrayList cardsInHand)
	 */
	public void drawCard() {
		int random = 0 + (int)(Math.random() * ((this.getHero().getAvailableCardsName().size()))); 						// Créé un nombre aléatoire compris entre l'indice 0 et la taille maximum de la liste
		Carte card = this.getHero().getFactory().drawCard(this.getHero().getAvailableCardsName().get(random), this); 	// Ajoute la carte créée avec la fabrique
		System.out.println("Vous piochez : \n" + card.describe());
		this.cardsInHand.add(card);
	}
	
	/**
	 * Permet d'ajouter une carte spéciale sur le terrain
	 * Appelée lorsque qu'un serviteur qui ne peut pas être 
	 * pioché doit être instancié sur le plateau
	 * Par exemple ImageMiroir qui créé 2 images miroirs sur le plateau
	 * 
	 * @param cardName String nom de la carte
	 * @param factory CarteFactory factory à utiliser
	 */
	public void playSpecialCard(String cardName, CarteFactory factory) {
		if(this.playedCards.size() < 8) {
			Carte card = factory.drawCard(cardName, this);
			this.playedCards.add(card);
		}else {
			System.out.println("Vous ne pouvez pas jouer plus de serviteur.");
		}
	}
	
	/**
	 * Ajoute un serviteur aux cartes jouées (playedCards)
	 * et le retire de la main
	 * @param minion
	 */
	public void playMinion(Serviteur minion) {
		if(this.playedCards.size() < 8) {
			if(this.getHero().useMana(minion.getManaCost())) {
				this.playedCards.add(minion);
				this.cardsInHand.remove(minion);
				minion.proceed(); // Déclenche l'effet de la carte (ChefDeRaid) notamment
			}
		} else {
			System.out.println("Vous ne pouvez pas jouer plus de serviteur.");
		}
	}
	
	
	/**
	 * Utilise un sort et le retire de la main
	 * @param spell
	 * @param target
	 */
	public void playSpell(Sort spell, Cible target){
		spell.useSpell(target);
		this.cardsInHand.remove(spell);
	}
	
	
	/**
	 * Enlève une carte de la main
	 * @param card
	 */
	public void removeHandCard(Carte card) {
		this.getCardsInHand().remove(card);
	}
	
	
	/**
	 * Enlève une carte du plateau
	 * @param card
	 */
	public void removePlayedCard(Carte card) {
		this.getPlayedCards().remove(card);
	}
	
	
	/**
	 * Appelée lorsque le tour du joueur se termine
	 * Remet l'attribut des serviteurs canAttack à vrai
	 * Incrémente et recharge le mana
	 * Recharche la compétence héroique
	 */
	public void roundSEnd() {
		if(this.getPlayedCards().size() != 0) {
			for(Carte card : this.getPlayedCards()) {
				((Serviteur) card).setCanAttack(true);
			}
		}
		this.getHero().increaseMaxMana();
		this.getHero().getAbility().abilityReloaded();
	}
	
	
	/**
	 * Récupère les cartes avec provocation
	 * @return
	 */
	private ArrayList<Carte> getTanks() {
		ArrayList<Carte> tanksMinions = new ArrayList<>();
		for(Carte card : playedCards) {
			if(((Serviteur)card).isShouldBeAttack()) {
				tanksMinions.add(card);
			}
		}
		return tanksMinions;
	}
	
	/**
	 * Affiche les serviteurs ciblables et le héro si 
	 * aucun serviteur n'a provocation
	 * @return
	 */
	public ArrayList<Cible> getTargetable(){
		ArrayList<Cible> targetables = new ArrayList<>();
		ArrayList<Carte> shouldBeTargetCards = getTanks(); // Récupère les serviteurs avec provocation
		
		if(shouldBeTargetCards.size() > 0) { // Si il y a des serviteurs avec provocation, retourne cette liste
			for (Carte carte : shouldBeTargetCards) {
				Serviteur target = ((Serviteur)carte);
				targetables.add(target);
			}
		}else { // Sinon affiche le hero et le plateau du joueur
			targetables.add(this.getHero());
			for (Carte carte : playedCards) {
				Serviteur target = ((Serviteur)carte);
				targetables.add(target);
			}
		}
		return targetables;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * @param hero the hero to set
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Joueur getEnemy() {
		return enemy;
	}

	public void setEnemy(Joueur enemy) {
		this.enemy = enemy;
	}
	
	public boolean isShouldPlay() {
		return shouldPlay;
	}

	public void setShouldPlay(boolean shouldPlay) {
		this.shouldPlay = shouldPlay;
	}

	/**
	 * @return the cardsInHand
	 */
	public ArrayList<Carte> getCardsInHand() {
		return cardsInHand;
	}

	/**
	 * @param cardsInHand the cardsInHand to set
	 */
	public void setCardsInHand(ArrayList<Carte> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public ArrayList<Carte> getPlayedCards() {
		return playedCards;
	}

	public void setPlayedCards(ArrayList<Carte> playedCards) {
		this.playedCards = playedCards;
	}
	
	/**
	 * Gère l'affichage des cartes de la main du joueur
	 */
	public void displayCardsInHand() {
		int i = 1;
		for(Carte card : cardsInHand) {
			System.out.println(i + ". ");
			if(card.getClass().isAssignableFrom(Serviteur.class)) {
				System.out.println(((Serviteur)card).describe());
			}else {
				System.out.println(card.describe());
			}
			i++;
		}
	}
	
	/**
	 * Gère l'affichage du plateau du joueur
	 */
	public void displayPlayedCards() {
		int i = 1;
		for(Carte card : playedCards) {
			System.out.println(i + ". ");
			System.out.println(((Serviteur)card).describe());
			i++;
		}
	}
	
	/**
	 * Gère l'affichage des cibles possibles
	 */
	public void displayTargetable() {
		ArrayList<Cible> targetablesCards = getTargetable();
		for(int i = 0; i < targetablesCards.size(); i++) {
			try {
				Carte card = (Carte)targetablesCards.get(i);
				System.out.println((i + 1) + ".\n");
				System.out.println(card.describe());
			}catch(ClassCastException exc) {
				Hero hero = (Hero)targetablesCards.get(i);
				System.out.println((i + 1) + ".\n");
				System.out.println(hero.describe());
			}
		}
	}

	public String describe() {
		String desc = "[JOUEUR] {NOM} = " + this.getName();
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
