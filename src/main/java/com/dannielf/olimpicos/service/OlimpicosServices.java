package com.dannielf.olimpicos.service;

import com.dannielf.olimpicos.dao.CustomerDao;
import com.dannielf.olimpicos.dao.EmployeeDao;
import com.dannielf.olimpicos.dao.ServiceDao;
import com.dannielf.olimpicos.domain.Customer;
import com.dannielf.olimpicos.domain.Employee;
import com.dannielf.olimpicos.domain.Service;
import com.dannielf.olimpicos.service.interfaces.IOlimpicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;


/**
 * Clase tipo Servicio para el manejo de GYM Olimpicos
 *
 * @version 1.0.0 2022-04-02
 * @author Daniel Granados
 * @since 1.0.0
 */
@org.springframework.stereotype.Service
public class OlimpicosServices implements IOlimpicos {

    /**
     * Repositorio de cliente
     */
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ServiceDao serviceDao;


    /**
     * Devuelve una lista de cliente con todos los cliente del sistema
     *
     * @return
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Override
    @Transactional(readOnly = true)
    public List<Customer> getListCus() {
        return (List<Customer>) customerDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getListEmp() {
        return (List<Employee>) employeeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Service> getListServ() {
        return (List<Service>) serviceDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> searchCus(String data) {
        var customer = customerDao.findByUsername(data);
        var answer = new HashSet<Customer>();
        answer.addAll(customer);
        return answer.stream().toList();
    }

    /**
     * Crea un cliente en el sistema
     *
     * @param customer Objeto del cliente a crear
     * @return Objeto del cliente creado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        customer.setCreatedAt(Instant.now());
        return customerDao.save(customer);
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(Instant.now());
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public Service createService(Service service) {
        service.setCreatedAt(Instant.now());
        return serviceDao.save(service);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Integer id, Customer customer) {
        customer.setId(id);
        customer.setUpdatedAt(Instant.now());
        return customerDao.save(customer);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Integer id, Employee employee) {
        employee.setId(id);
        employee.setUpdatedAt(Instant.now());
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public Service updateService(Integer id, Service service) {
        service.setId(id);
        service.setUpdatedAt(Instant.now());
        return serviceDao.save(service);
    }

    /**
     * Actualiza el nombre de un cliente
     *
     * @param id Identificador del cliente a actualizar
     * @param customer Objeto del cliente a actualizar
     * @return Objeto del cliente actualizado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Override
    @Transactional
    public Customer updateFullName(Integer id, Customer customer) {
        customer.setId(id);
        customer.setUpdatedAt(Instant.now());
        customerDao.updateFullName(id, customer.getFullName());
        return customer;
    }

    @Override
    @Transactional
    public Customer updatePassword(Integer id, Customer customer) {
        customer.setId(id);
        customer.setUpdatedAt(Instant.now());
        customerDao.updatePassword(id, customer.getPassword());
        return customer;
    }

    @Override
    @Transactional
    public Employee updateFullName(Integer id, Employee employee) {
        employee.setId(id);
        employee.setUpdatedAt(Instant.now());
        employeeDao.updateFullName(id, employee.getFullName());
        return employee;
    }

    @Override
    @Transactional
    public Employee updatePhone(Integer id, Employee employee) {
        employee.setId(id);
        employee.setUpdatedAt(Instant.now());
        employeeDao.updatePhone(id, employee.getPhone());
        return employee;
    }

    @Override
    @Transactional
    public Service updateName(Integer id, Service service) {
        service.setId(id);
        service.setUpdatedAt(Instant.now());
        serviceDao.updateName(id, service.getName());
        return service;
    }

    @Override
    @Transactional
    public Service updateActive(Integer id, Service service) {
        service.setId(id);
        service.setUpdatedAt(Instant.now());
        serviceDao.updateActive(id, service.getActive());
        return service;
    }


    /**
     * Borra un cliente del sistema
     *
     * @param id Identificación del cliente a borrar
     * @return Objeto del cliente borrado
     *
     * @author Daniel Granados
     * @since 1.0.0
     */
    @Override
    @Transactional
    public Customer deleteCustomer(Integer id) {
        var customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customerDao.delete(customer.get());
            return customer.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Integer id) {
        var employee = employeeDao.findById(id);
        if (employee.isPresent()) {
            employeeDao.delete(employee.get());
            return employee.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Service deleteService(Integer id) {
        var service = serviceDao.findById(id);
        if (service.isPresent()) {
            serviceDao.delete(service.get());
            return service.get();
        } else {
            return null;
        }
    }
}
