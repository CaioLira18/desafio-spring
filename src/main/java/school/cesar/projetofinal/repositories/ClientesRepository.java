package school.cesar.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import school.cesar.projetofinal.entities.Client;



public interface ClientesRepository extends JpaRepository<Client, Long> {
    
}
