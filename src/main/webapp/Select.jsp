<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Найти</title></head>
<body>
    <h2>Найти студента</h2>
    <form action="select" method="get">
        ID: <input type="number" name="id" required><br><br>
        <input type="submit" value="Найти">
    </form>
    <br><input type="button" value="На главную" onclick="window.location.href='Home.jsp'" />
</body>
</html>