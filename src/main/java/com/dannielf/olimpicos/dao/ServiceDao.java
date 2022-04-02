package com.dannielf.olimpicos.dao;

import com.dannielf.olimpicos.domain.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio para la entidad servicio
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface ServiceDao extends CrudRepository<Service, Integer> {

    /**
     * Actualiza el nombre de un servicio basado en su identificador
     *
     * @param id Identificador del servicio
     * @param name Nuevo nombre del servicio
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Service serv " +
            "set serv.name = :name, " +
            "serv.updatedAt = CURRENT_TIMESTAMP where serv.id = :id")
    public void updateName(
            @Param(value = "id") Integer id,
            @Param(value = "name") String name
    );

    /**
     * Actualiza el estado de un servicio basado en su identificador
     *
     * @param id Identificador del cliente
     * @param active Nuevo estado del servicio
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Service serv " +
            "set serv.active = :active, " +
            "serv.updatedAt = CURRENT_TIMESTAMP where serv.id = :id")
    public void updateActive(
            @Param(value = "id") Integer id,
            @Param(value = "active") String active
    );
}