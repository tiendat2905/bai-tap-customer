package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.BaseService;
import com.codegym.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCustomerController", urlPatterns = "/addCustomer")
public class AddCustomerController extends HttpServlet {

    private final BaseService<Customer> customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(0,name,email,address);
        customerService.save(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("add-customer.jsp");
        Customer cus = new Customer();
        request.setAttribute("customer", cus);
        request.setAttribute("message","Added customer success!");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-customer.jsp");

        Customer cus = new Customer();
        request.setAttribute("customer", cus);

        dispatcher.forward(request, response);
    }
}
