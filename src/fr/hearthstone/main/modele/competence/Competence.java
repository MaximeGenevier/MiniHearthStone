package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.CompetenceState;
import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.designpattern.state.EtatIndisponible;
import fr.hearthstone.main.modele.hero.Hero;

public abstract class Competence{
	
	protected Hero hero;
	protected int abilityCost;
	protected String name;
	protected CompetenceState disableState;
	protected CompetenceState enableState;
	protected CompetenceState state;
	
	public Competence(String name, Hero hero){
		this.abilityCost = 2;
		this.name = name;
		this.hero = hero;
		
		this.disableState = new EtatIndisponible(this);
		this.enableState = new EtatDisponible(this);
		
		this.state = enableState;
	}
	
	public void abilityUsed() {
		state.abilityUsed();
	}

	public void abilityReloaded() {
		state.abilityReloaded();
	}
	
	public void changeStateDisable() {
		this.state = disableState;
	}
	
	public void changeStateEnable() {
		this.state = enableState;
	}
	
	public abstract void useAbility();
}