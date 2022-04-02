package com.dannielf.olimpicos.dao;

import com.dannielf.olimpicos.domain.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositorio para la entidad cliente
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    /**
     * Busca los contactos que contienen X dato por username
     *
     * @param data Dato a buscar
     * @return Listado de clientes encontrados
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Query(value = "SELECT cus " +
            "FROM Customer cus " +
            "WHERE cus.userName LIKE %:data% " +
            "ORDER BY cus.userName ASC")
    public List<Customer> findByUsername(@Param("data") String data);

    /**
     * Actualiza el nombre de un cliente basado en su identificador
     *
     * @param id Identificador del cliente
     * @param fullName Nuevo nombre del cliente
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Customer cus " +
            "set cus.fullName = :fullName, " +
            "cus.updatedAt = CURRENT_TIMESTAMP where cus.id = :id")
    public void updateFullName(
            @Param(value = "id") Integer id,
            @Param(value = "fullName") String fullName
    );

    /**
     * Actualiza el password de un cliente basado en su identificador
     *
     * @param id Identificador del cliente
     * @param password Nuevo del cliente
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Customer cus " +
            "set cus.password = :password, " +
            "cus.updatedAt = CURRENT_TIMESTAMP where cus.id = :id")
    public void updatePassword(
            @Param(value = "id") Integer id,
            @Param(value = "password") String password
    );
}