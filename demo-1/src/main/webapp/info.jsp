<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
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
</html>  