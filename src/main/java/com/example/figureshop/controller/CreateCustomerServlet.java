package com.example.figureshop.controller;

import com.example.figureshop.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String CusId = req.getParameter("CusId");
        String fullName = req.getParameter("fullName");
        String Image = req.getParameter("Image");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(fullName);
        Customer customer = new Customer(CusId, fullName, Image, phone);
        HashMap<String, String> errors = new HashMap<>();
        if (stringBirthday != null && stringBirthday.length() > 0) {
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            customer.setDob(birthday);
        }

        if (CusId == null || CusId.length() == 0) {
            errors.put("CusId", "Please enter CusId");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter fullname");
        }
        if (Image == null || Image.length() == 0) {
            errors.put("Image", "Please upload Image");

            if (phone == null || phone.length() == 0) {
                errors.put("phone", "Please enter phone");
            }
            if (errors.size() > 0) {
                req.setAttribute("customer", customer);
                req.setAttribute("action", 1);
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
                return;
            }
            if (customerModel.save(customer) != null) {
                resp.sendRedirect("/admin/customers/list");
            } else {
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            }
        }
    }
}