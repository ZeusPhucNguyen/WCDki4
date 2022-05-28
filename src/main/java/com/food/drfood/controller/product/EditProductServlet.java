package com.food.drfood.controller.product;

import com.food.drfood.entity.Product;
import com.food.drfood.entity.myenum.ProductStatus;
import com.food.drfood.model.CategoryModel;
import com.food.drfood.model.MySqlCategoryModel;
import com.food.drfood.model.MySqlProductModel;
import com.food.drfood.model.ProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    public EditProductServlet(){
        this.productModel = new MySqlProductModel();
        this.categoryModel=new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if (product==null){
            req.setAttribute("message","Product not found!");
            req.getRequestDispatcher("/errors/404.jsp").forward(req,resp);
        }else{
            req.setAttribute("obj",product);
            req.setAttribute("categories",categoryModel.findAll());
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct = productModel.findById(id);
        if (existingProduct==null){
            req.setAttribute("message","Product not found!");
            req.getRequestDispatcher("/errors/404.jsp").forward(req,res);
        }else{
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String name= req.getParameter("name");
            Double price = Double.valueOf(req.getParameter("price"));
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            String detail = req.getParameter("detail");
            int status  = Integer.parseInt(req.getParameter("status"));
            System.out.println(name);
            Product product = new Product();
            product.setName(name);
            product.setCategoryId(categoryId);
            product.setStatus(ProductStatus.of(status));
            product.setDetail(detail);
            product.setPrice(price);
            product.setDescription(description);
            product.setThumbnail(thumbnail);
            if (!product.isValid()){
                req.setAttribute("obj", product);
                req.setAttribute("categories",categoryModel.findAll());
                req.setAttribute("action",2);
                req.setAttribute("errors",product.getErrors());
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req,res);
            }
            if (productModel.update(id,product)!=null){
                res.sendRedirect("/admin/products/list");
            }else{
                req.setAttribute("categories",categoryModel.findAll());
                req.setAttribute("obj",product);
                req.setAttribute("action",2);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req,res);
            }
        }

    }
}
