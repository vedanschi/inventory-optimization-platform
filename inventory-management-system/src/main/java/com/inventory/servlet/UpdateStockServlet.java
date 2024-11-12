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

@WebServlet("/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {

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
            int quantityToAdd = Integer.parseInt(request.getParameter("quantity"));
            
            ProductDAO productDAO = new ProductDAO();
            productDAO.updateQuantity(productId, quantityToAdd);
            
            response.sendRedirect("ProductDetails.jsp?productId=" + productId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateStockServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
