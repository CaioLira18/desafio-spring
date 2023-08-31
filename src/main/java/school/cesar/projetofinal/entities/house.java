package school.cesar.projetofinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@NoArgsConstructor // Construtores
@AllArgsConstructor // Construtores
@Builder // Builder = Padrão de Projeto
public class house {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "ownership_status", nullable = false)
    private String ownershipStatus;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @ManyToOne // Relação entre as classes
    @JoinColumn(name = "cliente_id")
    @JsonBackReference  //Forçar a parada da busca
    private Client client;
}
