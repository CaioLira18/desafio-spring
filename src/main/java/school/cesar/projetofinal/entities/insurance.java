package school.cesar.projetofinal.entities;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

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

@Data
@Entity
@NoArgsConstructor // Construtores
@AllArgsConstructor // Construtores
@Builder // Builder = Padrão de Projeto

public class insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "risk", nullable = false)
    private int risk;

    @Column(name = "analysis", nullable = false)
    private String analysis;

    @Column(name = "observation", nullable = true) // nullable = true --> Explicita que pode ser um campo vazio. O Sistema nao precisa esperar um input
    private String observation;

    @Column(name = "createdAt", nullable = false)
    private Data createdAt;

    @Column(name = "validatedAt", nullable = false)
    private Data validatedAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}