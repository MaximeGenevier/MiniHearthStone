package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.CompetenceState;
import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.designpattern.state.EtatIndisponible;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.hero.Hero;

/**
 * @author Maxime GENEVIER
 * 
 * Compétence abstraite : chaque héro à une compétence qui lui est propre
 * 
 * La compétence connait son héro, son cout, son nom, sa description, et son état courrant
 * 
 * Elle a deux états possibles : disponible et indisponible
 *
 */
public abstract class Competence{
	
	protected Hero 				hero;			// Le héro a qui appartient la compétence
	protected int 				abilityCost;	// Le cout de la compétence : universel et vaut 2
	protected String 			name;			// Nom de la compétence
	protected String 			description;	// Description de la compétence
	protected CompetenceState 	disableState;	// Etat indisponible
	protected CompetenceState 	enableState;	// Etat disponible
	protected CompetenceState 	state;			// Etat courant
	
	/**
	 * @param name String nom de la compétence
	 * @param hero Hero héro propriétaire de la compétence	
	 * @param description String description de la compétence
	 */
	public Competence(String name, Hero hero, String description){
		this.abilityCost = 2;
		this.name = name;
		this.hero = hero;
		this.description = description;
		this.disableState = new EtatIndisponible(this);
		this.enableState = new EtatDisponible(this);
		
		this.state = enableState; // Par défaut la compétence est disponible
	}
	
	/**
	 * State change l'etat à indisponible
	 */
	public void abilityUsed() {
		state.abilityUsed();
	}

	/**
	 * State change l'etat à disponible
	 */
	public void abilityReloaded() {
		state.abilityReloaded();
	}
	
	/**
	 * Change l'etat à indisponible 
	 */
	public void changeStateDisable() {
		this.state = disableState;
	}
	
	/**
	 * Change l'etat à disponible
	 */
	public void changeStateEnable() {
		this.state = enableState;
	}
	
	
	/**
	 * Utilise la compétence, lorsqu'elle n'a pas besoin de cible : Renfort
	 */
	public abstract void useAbility();
	/**
	 * Utilise la compétence, lorsqu'elle a besoin d'une cible : Boule de feu
	 * @param target Cible cible de la compétence
	 */
	public void useAbility(Cible target) {
		
	}

	/**
	 * @return
	 */
	public CompetenceState getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(CompetenceState state) {
		this.state = state;
	}
	
	public String describe() {
		return "[COMPETENCE]" + "\t{NOM} = " + this.name + "\t{DESCRIPTION} = " + this.description;
	}
	
}