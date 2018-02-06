package fr.hearthstone.test.modele.carte;

import org.junit.Test;

import fr.hearthstone.main.designpattern.decorator.ServiteurDecorator;
import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.designpattern.factory.CarteMageFactory;
import fr.hearthstone.main.designpattern.factory.CartePaladinFactory;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;

public class ServiteurTest {

	
	@Test
	public void factoryServiteurTest() {
		
		Joueur joueur1 = new Joueur("Joueur 1");
		
		Hero paladin = new Paladin(joueur1);
		joueur1.setHero(paladin);
		
		Joueur joueur2 = new Joueur("Joueur 2");
		
		Hero mage = new Mage(joueur2);
		joueur2.setHero(mage);
		
		CarteFactory factoryJ1 = new CartePaladinFactory();
		CarteFactory factoryJ2 = new CarteMageFactory();
		
		for(int i = 0; i < 15; i++) {
		
			Carte drawCardJ1 = joueur1.drawCard(factoryJ1);
			displayCard(drawCardJ1);
			Carte drawCardJ2 = joueur2.drawCard(factoryJ2);
			displayCard(drawCardJ2);
		
		}

	}
	
	private void displayCard(Carte card) {
		
		Class<?> classe = card.getClass().getSuperclass();
		if(classe.equals(ServiteurDecorator.class)) {
			classe = classe.getSuperclass();
		}
		
		if(classe.equals(Sort.class)){
			System.out.println(((Sort)card).toString());
		}else {
			System.out.println(((Serviteur)card).toString());
		}
	}

}
