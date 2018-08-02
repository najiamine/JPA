package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@NamedQuery(name = "Order:findAllOrders", query = "select c from User c")
// c where c.name = :fname order By c.name")  on specifie les parametre sur le main 
@Cache(region="cache_entite",usage=CacheConcurrencyStrategy.READ_ONLY)
public class User {
	@Id // @GeneratedValue()
	private int id;
	private String name;
	@ManyToOne // (optional = false) cle foring key obligatoire ou non
	@JoinColumn(name = "Profil_ID")
	private Profil profil;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public User(int id, Profil profil) {
		super();
		this.id = id;
		this.profil = profil;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
