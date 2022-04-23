<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="https://thymeleaf.org">  
<body>
    <table>  
        <tr>  
            <td><h4>User Name: </h4></td>  
            <td><h4 th:text="${user.name}"></h4></td>  
        </tr>  
        <tr>  
            <td><h4>Email ID: </h4></td>  
            <td><h4 th:text="${user.email}"></h4></td>  
        </tr>  
    </table>  
    </body>
</html>  