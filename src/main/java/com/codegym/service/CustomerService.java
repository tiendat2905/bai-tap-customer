package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements BaseService<Customer>{
    public static Map<Integer, Customer> customers;
    public static int count = 5;
    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Le Van A","email@gmail.com","address1"));
        customers.put(2,new Customer(2,"Le Van A1","email1@gmail.com","address2"));
        customers.put(3,new Customer(3,"Le Van A2","email2@gmail.com","address3"));
        customers.put(4,new Customer(4,"Le Van A3","email3@gmail.com","address4"));
        customers.put(5,new Customer(5,"Le Van A4","email4@gmail.com","address5"));

    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer object) {
        ++count;
        object.setId(count);
        customers.put(object.getId(), object);
    }

    @Override
    public void update(Customer object) {
        customers.put(object.getId(), object);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void delete(int id) {
        customers.remove(id);
    }
}
