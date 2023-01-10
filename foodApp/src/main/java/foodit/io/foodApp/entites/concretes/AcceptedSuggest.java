package foodit.io.foodApp.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "AcceptedSuggest")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcceptedSuggest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String acceptedName;
	
	@Column(name = "alergens")
	private String acceptedAlergen;
}
