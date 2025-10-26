<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Главная</title></head>
<body>
    <h2 align="center">УПРАВЛЕНИЕ СТУДЕНТАМИ</h2>
    <table align="center">
        <tr>
            <td>Добавить:</td>
            <td><input type="button" value="Добавить" onclick="window.location.href='Insert.jsp'" /></td>
        </tr>
        <tr>
            <td>Обновить:</td>
            <td><input type="button" value="Обновить" onclick="window.location.href='Update.jsp'" /></td>
        </tr>
        <tr>
            <td>Удалить:</td>
            <td><input type="button" value="Удалить" onclick="window.location.href='Delete.jsp'" /></td>
        </tr>
        <tr>
            <td>Найти:</td>
            <td><input type="button" value="Найти" onclick="window.location.href='Select.jsp'" /></td>
        </tr>
    </table>
</body>
</html>