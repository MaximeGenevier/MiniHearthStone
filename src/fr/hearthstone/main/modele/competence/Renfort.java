package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.designpattern.factory.CartePaladinFactory;
import fr.hearthstone.main.modele.hero.Paladin;

public class Renfort extends Competence{
	public Renfort(Paladin hero){
		super("Renfort", hero);
	}
	
	public void useAbility(){
		this.abilityUsed();
		this.hero.getPlayer().playSpecialCard("RecrueDeLaMainDArgent");
	}
}