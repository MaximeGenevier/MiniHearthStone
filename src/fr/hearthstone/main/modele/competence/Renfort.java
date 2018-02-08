package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Paladin;

public class Renfort extends Competence{
	public Renfort(Paladin hero){
		super("Renfort", hero, "Invoque un serviteur Recrue de la Main d’argent 1/1.");
	}
	
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) {
			if(this.hero.useMana(this.abilityCost)){
				this.abilityUsed();
				this.hero.getPlayer().playSpecialCard("RecrueDeLaMainDArgent");
			}else{
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}
	}
}