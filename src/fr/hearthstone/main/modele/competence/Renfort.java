package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Paladin;

public class Renfort extends Competence{
	public Renfort(Paladin hero){
		super("Renfort", hero);
	}
	
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) {
			if(this.hero.getCurrentMana() >= this.abilityCost){
				this.abilityUsed();
				this.hero.getPlayer().playSpecialCard("RecrueDeLaMainDArgent");
			}else{
				System.out.println("Vous n'avez pas assez de mana");
			}
		}
	}
}