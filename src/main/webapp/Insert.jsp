<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Добавить</title></head>
<body>
    <h2>Добавить студента</h2>
    <form action="insert" method="post">
        Имя: <input type="text" name="nickname" required><br><br>  <!-- исправлено -->
        Возраст: <input type="number" name="age" required><br><br>
        Оценка: <input type="number" step="0.1" name="grade" required><br><br>
        <input type="submit" value="Добавить">
    </form>
    <br><input type="button" value="На главную" onclick="window.location.href='Home.jsp'" />
</body>
</html>