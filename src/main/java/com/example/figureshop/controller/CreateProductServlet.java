package com.example.figureshop.controller;

import com.example.figureshop.entity.Product;
import com.example.figureshop.model.MySqlProductModel;
import com.example.figureshop.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form product.
        req.setAttribute("product", new product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/product/formproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String ProductId = req.getParameter("ProductId");
        String ProductName = req.getParameter("ProductName");
        String Description = req.getParameter("Description");
        String CategoryId = req.getParameter("CategoryId");
        String stringStandardCost = req.getParameter("StandardCost");
        String stringListPrice = req.getParameter("ListPrice");
        System.out.println(ProductId);
        Product product = new Product(ProductId, ProductName, Description, CategoryId);
        HashMap<String, String> errors = new HashMap<>();

        if (ProductId == null || ProductId.length() == 0) {
            errors.put("ProductId", "Please enter ProductId");
        }
        if (ProductName == null || ProductName.length() == 0) {
            errors.put("ProductName", "Please enter ProductName");
        }
        if (Description == null || Description.length() == 0) {
            errors.put("Description", "Please enter Description");
        }
        if (CategoryId == null || CategoryId.length() == 0) {
            errors.put("CategoryId", "Please enter CategoryId");
        }
        if (errors.size() > 0) {
            req.setAttribute("product", product);
            req.setAttribute("action", 1);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/product/formproduct.jsp").forward(req, resp);
            return;
        }
        if (productModel.save(product) != null) {
            resp.sendRedirect("/admin/products/list");
        } else {
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }
}
