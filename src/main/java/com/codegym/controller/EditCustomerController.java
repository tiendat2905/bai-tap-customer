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

@WebServlet(name = "EditCustomerController",urlPatterns = "/editCustomer")
public class EditCustomerController extends HttpServlet {

    private final BaseService<Customer> customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer cus = new Customer(id,name,email,address);

        customerService.update(cus);

        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");

        request.setAttribute("customer", cus);
        request.setAttribute("message","Edit customer success!");

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Customer cus = customerService.findById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");
        request.setAttribute("customer", cus);

        dispatcher.forward(request,response);

    }
}
