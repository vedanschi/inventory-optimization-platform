<!-- ProductDetails.jsp -->
<%@ page import="com.inventory.model.Product" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details</h2>
    <p><strong>Product ID:</strong> <%= product.getProductId() %></p>
    <p><strong>Product Name:</strong> <%= product.getProductName() %></p>
    <p><strong>Type:</strong> <%= product.getType() %></p>
    <p><strong>Quantity:</strong> <%= product.getQuantity() %></p>
    <p><strong>Warehouse:</strong> <%= product.getWarehouseId() %></p>

    <h3>Update Quantity</h3>
    <form action="UpdateStockServlet" method="POST">
        <input type="hidden" name="productId" value="<%= product.getProductId() %>">
        <label for="quantity">Add Stock:</label>
        <input type="number" name="quantity" required>
        <input type="submit" value="Add Stock">
    </form>

    <h3>Ship to Different Warehouse</h3>
    <form action="WarehouseTransfer.jsp" method="POST">
        <input type="hidden" name="productId" value="<%= product.getProductId() %>">
        <input type="submit" value="Ship">
    </form>
</body>
</html>
