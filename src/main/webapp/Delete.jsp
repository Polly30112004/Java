<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Удалить</title></head>
<body>
    <h2>Удалить студента</h2>
    <form action="delete" method="post">
        ID: <input type="number" name="id" required><br><br>
        <input type="submit" value="Удалить">
    </form>
    <br><input type="button" value="На главную" onclick="window.location.href='Home.jsp'" />
</body>
</html>