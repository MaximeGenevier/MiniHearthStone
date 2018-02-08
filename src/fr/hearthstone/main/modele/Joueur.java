package fr.hearthstone.main.modele;

import java.util.ArrayList;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.hero.Hero;

public class Joueur {

	private String name;
	private Hero hero;
	private Joueur enemy;
	private ArrayList<Carte> cardsInHand;
	private ArrayList<Carte> playedCards;
	
	public Joueur(String name) {
		this.name = name;
		this.cardsInHand = new ArrayList<>();
		this.playedCards = new ArrayList<>();
	}
	
	public void drawCard() {
		// Créé un nombre aléatoire compris entre l'indice 0 et la taille maximum de la liste
		int random = 0 + (int)(Math.random() * ((this.getHero().getAvailableCardsName().size() - 0)));
		// Ajoute la carte créée avec la fabrique
		Carte card = this.getHero().getFactory().drawCard(this.getHero().getAvailableCardsName().get(random), this);
		System.out.println("Vous piochez : \n" + card.describe());
		this.cardsInHand.add(card);
	}
	
	public void playSpecialCard(String cardName) {
		if(this.playedCards.size() < 5) {
			Carte card = this.getHero().getFactory().drawCard(cardName, this);
			this.playedCards.add(card);
		}else {
			System.out.println("Vous ne pouvez pas jouer plus de serviteur.");
		}
	}
	
	public void playCard(Carte card) {
		if(this.playedCards.size() < 5) {
			if(this.getHero().useMana(card.getManaCost())) {
				this.playedCards.add(card);
				this.cardsInHand.remove(card);
			}
		} else {
			System.out.println("Vous ne pouvez pas jouer plus de serviteur.");
		}
	}
	
	public void removeHandCard(Carte card) {
		this.getCardsInHand().remove(card);
	}
	
	public void removePlayedCard(Carte card) {
		this.getPlayedCards().remove(card);
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
	
	public ArrayList<Carte> getPlayedCards() {
		return playedCards;
	}

	public void setPlayedCards(ArrayList<Carte> playedCards) {
		this.playedCards = playedCards;
	}
	
	public void displayPlayedCards() {
		int i = 1;
		for(Carte card : playedCards) {
			System.out.println(i + ". ");
			if(card.getClass().isAssignableFrom(Serviteur.class)) {
				System.out.println(((Serviteur)card).describe());
			}else {
				System.out.println(card.describe());
			}
			i++;
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
