package school.cesar.projetofinal.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HouseRepository<House> extends JpaRepository<House, Long> {
    
}
