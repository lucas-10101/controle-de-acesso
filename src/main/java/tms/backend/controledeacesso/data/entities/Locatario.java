package tms.backend.controledeacesso.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "locatarios")
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "nome", length = 64, nullable = false, unique = true)
    private String nome;

    @Column(name = "dominio", length = 254, nullable = false, unique = true)
    private String dominio;

    @Column(name = "esquema_sgbd", length = 30, nullable = false, unique = true)
    private String esquemaSGBD;
}
