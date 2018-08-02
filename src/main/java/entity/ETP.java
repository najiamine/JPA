package entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity(name="etp")
//@MappedSuperclass
//Single table 
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="Disc",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("Etp")

//table jointure entra parent et fils 
//@Inheritance(strategy=InheritanceType.JOINED)

//3 eme exemple Table par classe 

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class ETP extends  Toto implements Serializable{

public ETP() {
	super();
	// TODO Auto-generated constructor stub
}

}
