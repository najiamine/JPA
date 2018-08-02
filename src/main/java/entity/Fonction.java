package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Fonction {
	@Id //@GeneratedValue()
	private int id;
	private String role ;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "profil_fonction", joinColumns = { @JoinColumn(name = "fonction_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "profil_ID") })
	private List<Profil> profil;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Profil> getProfil() {
		return profil;
	}

	public void setProfil(List<Profil> profil) {
		this.profil = profil;
	}

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(int id,String role) {
		super();
		this.id = id;
		this.role=role;
	}

		
	
	

}
