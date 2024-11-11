package com.inventory.servlet;

import com.inventory.dao.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TransferProductServlet")
public class TransferProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int newWarehouseId = Integer.parseInt(request.getParameter("warehouseId"));

        ProductDAO productDAO = new ProductDAO();
        productDAO.transferProduct(productId, newWarehouseId);

        response.sendRedirect("ProductDetails.jsp?productId=" + productId);
    }
}
