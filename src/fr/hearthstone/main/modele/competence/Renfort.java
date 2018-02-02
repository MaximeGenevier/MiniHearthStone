package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.modele.hero.Paladin;

public class Renfort extends Competence{
	public Renfort(Paladin hero){
		super("Renfort", hero);
	}
	
	public void useAbility(){
		// Create new minion, used factory?
	}
}