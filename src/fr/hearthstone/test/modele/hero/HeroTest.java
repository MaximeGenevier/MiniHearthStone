package fr.hearthstone.test.modele.hero;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.hearthstone.main.modele.hero.Guerrier;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;

public class HeroTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void heroMethodsTest() {
		Hero mage = new Mage();
		
		mage.beAttacked(15);
		mage.increaseArmor(6);
		mage.beAttacked(16);
		mage.beAttacked(10);
		
		Hero paladin = new Paladin();
		Hero guerrier = new Guerrier();
	}

}
