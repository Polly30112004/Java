<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Успех</title></head>
<body>
    <h2>Операция успешна!</h2>
    <p>
        <%
            String msg = request.getParameter("msg");
            if ("Insert".equals(msg)) out.print("Студент добавлен!");
            else if ("Update".equals(msg)) out.print("Студент обновлён!");
            else if ("Delete".equals(msg)) out.print("Студент удалён!");
            else if ("NotFound".equals(msg)) out.print("Студент не найден!");
            else out.print("Ошибка!");
        %>
    </p>
    <br><a href="Home.jsp">На главную</a>
</body>
</html>