package com.inventory.servlet;

import com.inventory.dao.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/TransferProductServlet")
public class TransferProductServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int newWarehouseId = Integer.parseInt(request.getParameter("warehouseId"));
            
            ProductDAO productDAO = new ProductDAO();
            productDAO.transferProduct(productId, newWarehouseId);
            
            response.sendRedirect("ProductDetails.jsp?productId=" + productId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransferProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
