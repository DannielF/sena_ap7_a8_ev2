package com.dannielf.olimpicos.service.interfaces;


import com.dannielf.olimpicos.domain.Customer;
import com.dannielf.olimpicos.domain.Employee;
import com.dannielf.olimpicos.domain.Service;

import java.util.List;

/**
 * Interface para el servicio de GYM Olimpicos
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
public interface IOlimpicos {

    /**
     * Devuelve una lista de clientes con todos los clientes del sistema
     *
     * @return
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    public List<Customer> getListCus();

    public List<Employee> getListEmp();

    public List<Service> getListServ();

    /**
     * Busca un dato dado entre el nombre y/o  username de un cliente
     *
     * @param data Dato a buscar
     * @return Lista de clientes
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    public List<Customer> searchCus(String data);


    /**
     * Crea un cliente en el sistema
     *
     * @param customer Objeto del cliente a crear
     * @return Objeto del cliente creado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    public Customer createCustomer(Customer customer);

    public Employee createEmployee(Employee employee);

    public Service createService(Service service);

    /**
     * Actualiza una tupla completa de un cliente
     *
     * @param id Identificador del cliente a actualizar
     * @param customer Objeto del cliente a actualizar
     * @return Objeto del cliente actualizado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    Customer updateCustomer(Integer id, Customer customer);

    Employee updateEmployee(Integer id, Employee employee);

    Service updateService(Integer id, Service service);

    /**
     * Actualiza el nombre de un cliente basado en su identificador
     *
     * @param id Identificador del cliente a actualizar
     * @param customer Objeto del cliente a actualizar
     * @return Objeto del cliente actualizado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    public Customer updateFullName(Integer id, Customer customer);

    public Customer updatePassword(Integer id, Customer customer);

    public Employee updateFullName(Integer id, Employee employee);

    public Employee updatePhone(Integer id, Employee employee);

    public Service updateName(Integer id, Service service);

    public Service updateActive(Integer id, Service service);

    /**
     * Borra un cliente del sistema basado en su identificador
     *
     * @param id Identificación del cliente a borrar
     * @return Objeto del cliente borrado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    public Customer deleteCustomer(Integer id);

    public Employee deleteEmployee(Integer id);

    public Service deleteService(Integer id);
}
