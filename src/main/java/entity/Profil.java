package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;

@Entity
// @NamedQueries({
// @NamedQuery(name="Country.findAll",
// query="SELECT c FROM Country c"),
// @NamedQuery(name="Country.findByName",
// query="SELECT c FROM Country c WHERE c.name = :name"),
// })
// @NamedNativeQueries({
// @NamedNativeQuery(name = "selectAuthorNames", query = "SELECT a.firstname,
// a.lastname FROM Author a"),
// @NamedNativeQuery(name = "selectAuthorEntities", query = "SELECT a.id,
// a.version, a.firstname, a.lastname FROM Author a", resultClass =
// Author.class),
// @NamedNativeQuery(name = "selectAuthorValue", query = "SELECT a.id,
// a.firstname, a.lastname, count(b.id) as numBooks FROM Author a JOIN
// BookAuthor ba on a.id = ba.authorid JOIN Book b ON b.id = ba.bookid GROUP BY
// a.id", resultSetMapping = "AuthorValueMapping")
// })
// @SqlResultSetMapping(
public class Profil {
	@Id
	// @GeneratedValue()
	private int id;
	private String type;
	@OneToMany(mappedBy = "profil")
	@OrderBy("name")
	private List<User> user;
	@ManyToMany(mappedBy = "profil")
	private List<Fonction> fonction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Fonction> getFonction() {
		return fonction;
	}

	public Profil(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFonction(List<Fonction> fonction) {
		this.fonction = fonction;
	}

	@Override
	public String toString() {
		return "Profil [id=" + id + ", type=" + type + "]";
	}

}
