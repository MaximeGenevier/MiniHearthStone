package fr.hearthstone.main.modele;

import java.util.ArrayList;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.hero.Hero;

public class Joueur {

	private String name;
	private Hero hero;
	private ArrayList<Carte> cardsInHand;
	
	public Joueur(String name) {
		this.name = name;
	}
	
	public Carte drawCard(CarteFactory factory) {
		// Créé un nombre aléatoire compris entre l'indice 0 et la taille maximum de la liste
		int random = 0 + (int)(Math.random() * ((this.getHero().getAvailableCardsName().size() - 0)));
		// Renvoie la carte créée avec la fabrique
		return factory.drawCard(this.getHero().getAvailableCardsName().get(random), this);
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
	
	public String describe() {
		String desc = "[JOUEUR] {NOM} = " + this.getName();
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
