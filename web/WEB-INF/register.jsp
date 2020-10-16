<%-- 
    Document   : register
    Created on : Oct 14, 2020, 9:25:57 AM
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
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList?action=register">
            
            <label>Username: 
                <input type="text" name="usernameInput">
            </label>
            <input type="submit" value="Register name">
        </form>
        
    </body>
</html>
