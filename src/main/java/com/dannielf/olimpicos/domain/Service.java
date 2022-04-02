package com.dannielf.olimpicos.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * Entidad del servicio
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "service")
public class Service implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id", nullable = false)
    private Integer id;

    @Column(name = "serv_name", nullable = false, length = 45)
    private String name;

    @Column(name = "serv_active", nullable = false, length = 10)
    private String active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}