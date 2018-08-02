package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//exemple Single table
//@DiscriminatorValue("Experience")

//exemple de
@AttributeOverride(name="name",column=@Column(name="nom_etp"))
public class Experience extends Toto {
//@Id

	
private String type ;

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public Experience() {
	super();
	// TODO Auto-generated constructor stub
}
public Experience(String type) {
	super();
	this.type = type;
}


}
