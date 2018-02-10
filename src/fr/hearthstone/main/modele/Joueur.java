package fr.hearthstone.main.modele;

import java.util.ArrayList;

import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;
import fr.hearthstone.main.modele.hero.Hero;

public class Joueur {

	private String name;
	private Hero hero;
	private Joueur enemy;
	private boolean shouldPlay;
	private ArrayList<Carte> cardsInHand;
	private ArrayList<Carte> playedCards;
	
	public Joueur(String name) {
		this.name = name;
		this.shouldPlay = false;
		this.cardsInHand = new ArrayList<>();
		this.playedCards = new ArrayList<>();
	}
	
	public void drawCard() {
		// Créé un nombre aléatoire compris entre l'indice 0 et la taille maximum de la liste
		int random = 0 + (int)(Math.random() * ((this.getHero().getAvailableCardsName().size())));
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
	
	public void playMinion(Serviteur minion) {
		// update method to only use minion
		if(this.playedCards.size() < 5) {
			if(this.getHero().useMana(minion.getManaCost())) {
				this.playedCards.add(minion);
				this.cardsInHand.remove(minion);
				minion.proceed();
			}
		} else {
			System.out.println("Vous ne pouvez pas jouer plus de serviteur.");
		}
	}
	
	public void playSpell(Sort spell, Cible target){
		// use spell
		spell.useSpell(target);
		this.cardsInHand.remove(spell);
	}
	
	public void removeHandCard(Carte card) {
		this.getCardsInHand().remove(card);
	}
	
	public void removePlayedCard(Carte card) {
		this.getPlayedCards().remove(card);
	}
	
	public void roundSEnd() {
		if(this.getPlayedCards().size() != 0) {
			for(Carte card : this.getPlayedCards()) {
				((Serviteur) card).setCanAttack(true);
			}
		}
		this.getHero().increaseMaxMana();
		this.getHero().getAbility().abilityReloaded();
	}
	
	private ArrayList<Carte> getTanks() {
		ArrayList<Carte> tanksMinions = new ArrayList<>();
		for(Carte card : playedCards) {
			if(((Serviteur)card).isShouldBeAttack()) {
				tanksMinions.add(card);
			}
		}
		return tanksMinions;
	}
	
	public ArrayList<Cible> getTargetable(){
		ArrayList<Cible> targetables = new ArrayList<>();
		ArrayList<Carte> shouldBeTargetCards = getTanks();
		
		if(shouldBeTargetCards.size() > 0) {
			for (Carte carte : shouldBeTargetCards) {
				Serviteur target = ((Serviteur)carte);
				targetables.add(target);
			}
		}else {
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
			System.out.println(((Serviteur)card).describe());
			i++;
		}
	}
	
	public void displayTargetable() {
		ArrayList<Carte> targetablesCards = getTanks();
		if(targetablesCards.size() > 0) {
			for(Carte card : targetablesCards) {
				System.out.println(((Serviteur)card).describe());
			}
		}else {
			System.out.println("1. " + this.getHero().describe());
			this.displayPlayedCards();
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
