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

@Table(name = "foods")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String foodName;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "prize")
	private double prize;
	
	@Column(name = "alergens")
	private String alergens;
	
	@Column(name = "company")
	private String companyName;
	
	@Column(name = "type")
	private String foodType;
	
	@Column(name = "image")
	private String image;
}
