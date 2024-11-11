package com.inventory.servlet;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        ProductDAO productDAO = new ProductDAO();
        Product product = null;

        // Search by Product ID
        if (productId != null && !productId.isEmpty()) {
            product = productDAO.getProductById(Integer.parseInt(productId));
        }
        // Search by Product Name
        else if (productName != null && !productName.isEmpty()) {
            product = productDAO.getProductByName(productName);
        }

        if (product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
        } else {
            response.getWriter().println("Product not found.");
        }
    }
}
