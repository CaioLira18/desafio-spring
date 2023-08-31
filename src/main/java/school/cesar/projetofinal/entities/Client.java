package school.cesar.projetofinal.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.cesar.projetofinal.enums.MaritalStatus;

@Data
@Entity
@NoArgsConstructor // Construtores
@AllArgsConstructor // Construtores
@Builder // Builder = Padrão de Projeto
@Table (name = "Client")

public class Client {

    @Id // Indentifica que o atributo que vem logo abaixo é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automatica sequencial das entidades no BD. Vai //
                                                        // criando as "ID´S" Na Tabela.
    @Column(nullable = false, updatable = false, unique = true) // ID nao pode ser nulo, atualozavel,
    private Long id;
    // Dando o nome a coluna p/ "Casar"
    @Column(name = "name", nullable = false)
    private String nome;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "dependents", nullable = false)
    private int dependents;

    @Column(name = "income", nullable = false)
    private double income;

    @Column(name = "marital_status", nullable = false)
    private MaritalStatus maritalStatus; // Baseado na classe "enum" criada para restringir as opçoes

    @Column(name = "house", nullable = false)
    private int house;

    @Column(name = "vehicles", nullable = false)
    private int vehicles;

    @Column(name = "createAt", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now(); // Assim que criar o atributo no BD, ele vai atribuir a ele "Data e Hora"

    @Column(name = "updateAt", nullable = true)
    private Date updateAt;
    
    
    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<house> Houses;

    @OneToMany (mappedBy = "client")
    private List<Vehicle> Vehicles;

    @OneToMany (mappedBy = "client")
    private List<insurance> Insurances;
}
