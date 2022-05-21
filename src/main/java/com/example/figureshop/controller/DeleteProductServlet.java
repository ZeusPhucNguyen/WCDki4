package com.example.figureshop.controller;

import com.example.figureshop.entity.Product;
import com.example.figureshop.model.MySqlProductModel;
import com.example.figureshop.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DeleteProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ProductId = req.getParameter("ProductId");

        Product product = ProductModel.findById(ProductId);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = productModel.delete(ProductId); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/products/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
