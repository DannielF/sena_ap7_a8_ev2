package com.dannielf.olimpicos.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

/**
 * Entidad del cliente
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id", nullable = false)
    private Integer id;

    @Column(name = "cus_fullname", nullable = false, length = 45)
    private String fullName;

    @Column(name = "cus_username", nullable = false, length = 45)
    private String userName;

    @Column(name = "cus_password", nullable = false, length = 45)
    private String password;

    @Column(name = "cus_document", nullable = false, length = 15)
    private String document;

    @Column(name = "cus_phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}