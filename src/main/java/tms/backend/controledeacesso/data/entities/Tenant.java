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
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "domain", length = 254, nullable = false, unique = true)
    private String domain;

    @Column(name = "schema_dbms", length = 30, nullable = false, unique = true)
    private String schemaDbms;
}
