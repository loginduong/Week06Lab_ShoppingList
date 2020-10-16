<%-- 
    Document   : shoppingList
    Created on : Oct 14, 2020, 9:26:07 AM
    Author     : 760483
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping list</h1>
        <p>Hello, ${username}   <a href="ShoppingList?action=logout">Logout</a>    </p>

        <h1>List</h1>
        <p>
        <form method="post" action="ShoppingList?action=add">
            <label>
                Add item: <input type="text" name="itemNameInput"><input type="submit" value="Add">
            </label>
        </form>
        <c:if test="${addError} == true">
            <span>
                Error adding item.
            </span>
        </c:if>
        <form method="post" action="ShoppingList?action=delete">
            <c:forEach items="${itemList}" var="item">
                <label><input type="radio" name="deleteItem" value="${item}">${item}</label><br/>
            </c:forEach>
                <input type="submit" value="Delete">
        </form>
    </body>
</html>
