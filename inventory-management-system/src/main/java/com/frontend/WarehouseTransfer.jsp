<!-- WarehouseTransfer.jsp -->
<%@ page import="com.inventory.model.Warehouse" %>
<%@ page import="java.util.List" %>
<%
    List<Warehouse> warehouses = (List<Warehouse>) request.getAttribute("warehouses");
    int productId = Integer.parseInt(request.getParameter("productId"));
%>
<!DOCTYPE html>
<html>
<head>
    <title>Warehouse Transfer</title>
</head>
<body>
    <h2>Select Destination Warehouse</h2>
    <form action="TransferProductServlet" method="POST">
        <input type="hidden" name="productId" value="<%= productId %>">
        <label for="warehouseId">Warehouse:</label>
        <select name="warehouseId">
            <%
                for (Warehouse warehouse : warehouses) {
                    out.println("<option value='" + warehouse.getWarehouseId() + "'>" + warehouse.getName() + "</option>");
                }
            %>
        </select>
        <input type="submit" value="Transfer">
    </form>
</body>
</html>
