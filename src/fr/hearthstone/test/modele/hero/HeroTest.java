package fr.hearthstone.test.modele.hero;

import static org.junit.Assert.fail;

import org.junit.Test;

public class HeroTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void heroMethodsTest() {
		
		for(int i = 0; i < 30; i++) {
			int random = 0 + (int)(Math.random() * 2);
			System.out.println(random);
		}
	}

}
