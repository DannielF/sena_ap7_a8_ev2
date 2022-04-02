package com.dannielf.olimpicos.dao;

import com.dannielf.olimpicos.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio para la entidad empleado
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    /**
     * Actualiza el nombre de un empleado basado en su identificador
     *
     * @param id Identificador del empleado
     * @param fullName Nuevo nombre del empleado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Employee emp " +
            "set emp.fullName = :fullName, " +
            "emp.updatedAt = CURRENT_TIMESTAMP where emp.id = :id")
    public void updateFullName(
            @Param(value = "id") Integer id,
            @Param(value = "fullName") String fullName
    );

    /**
     * Actualiza el telefono de un empleado basado en su identificador
     *
     * @param id Identificador del empleado
     * @param phone Nuevo telefono del empleado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Employee emp " +
            "set emp.phone = :phone, " +
            "emp.updatedAt = CURRENT_TIMESTAMP where emp.id = :id")
    public void updatePhone(
            @Param(value = "id") Integer id,
            @Param(value = "phone") String phone
    );
}