package com.example.figureshop.controller;

import com.example.figureshop.entity.Product;
import com.example.figureshop.model.MySqlProductModel;
import com.example.figureshop.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditProductServlet extends HttpServlet {
    private ProductModel productModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ProductId = req.getParameter("ProductId");

        Product product = productModel.findById(ProductId);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("product", product);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String ProductId = req.getParameter("ProductId");
        Product existingProduct = productModel.findById(ProductId);
        if(existingProduct == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            String ProductName = req.getParameter("ProductName");
            String Description = req.getParameter("Description");
            String CategoryId = req.getParameter("CategoryId");
            String stringStandardCost = req.getParameter("StandardCost");
            System.out.println(ProductName);
            Product product = new Product(ProductId, ProductName, Description, CategoryId, StandardCost);

            if (productModel.update(ProductId, product) != null) {
                resp.sendRedirect("/admin/products/list");
            } else {
                req.setAttribute("product", product);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }
        }
    }
}
