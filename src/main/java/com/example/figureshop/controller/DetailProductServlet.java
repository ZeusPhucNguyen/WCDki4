package com.example.figureshop.controller;

import com.example.figureshop.entity.Product;
import com.example.figureshop.model.MySqlProductModel;
import com.example.figureshop.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DeleteProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ProductId = req.getParameter("ProductId");

        Product product = productModel.findById(ProductId);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            ArrayList<Product> recentView =
                    (ArrayList<Product>) session.getAttribute("recentView");
            if(recentView == null){
                recentView = new ArrayList<Product>();
            }
            boolean exist = false;
            for (int i = 0 ; i < recentView.size(); i++){
                if (recentView.get(i).getProductId().equals(product.getProductId())){
                    exist = true;
                }
            }
            if(!exist){
                recentView.add(product);
                session.setAttribute("recentView",recentView);
            }
            // nếu có trả về trang detail
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }

    }
}
