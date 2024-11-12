<!-- HomePage.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Inventory Management</title>
</head>
<body>
    <h2>Search Product</h2>
    <form action="SearchProductServlet" method="GET">
        <label for="productId">Search by Product ID:</label>
        <input type="text" name="productId" placeholder="Enter Product ID">
        <br>
        <label for="productName">Search by Product Name:</label>
        <input type="text" name="productName" placeholder="Enter Product Name">
        <br><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
