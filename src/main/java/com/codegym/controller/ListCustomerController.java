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
import java.util.List;

@WebServlet(name = "ListCustomerController",urlPatterns = "/")
public class ListCustomerController extends HttpServlet {

    private final BaseService<Customer> customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-customer.jsp");
        List<Customer> list = customerService.findAll();
        request.setAttribute("customer",list);
        dispatcher.forward(request,response);
    }
}
