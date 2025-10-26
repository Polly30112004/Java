<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Результат</title></head>
<body>
    <h2>Студент найден:</h2>
    <p>ID: ${param.id}</p>
    <p>Имя: ${param.nickname}</p>
    <p>Возраст: ${param.age}</p>
    <p>Оценка: ${param.grade}</p>
    <br><a href="Home.jsp">На главную</a>
</body>
</html>