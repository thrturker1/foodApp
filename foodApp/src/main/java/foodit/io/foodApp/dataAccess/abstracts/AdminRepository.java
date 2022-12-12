package foodit.io.foodApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodit.io.foodApp.entites.concretes.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
