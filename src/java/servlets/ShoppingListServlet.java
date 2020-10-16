/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        -If username already exists forward to shoppingList
        -If not exists, send to register
        -If logout parameter, invalidate
         */
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }

        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        -Show the shopping list with the username provided
        -Allow log out
        
         */
        HttpSession session = request.getSession();
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");
        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        String action = request.getParameter("action");

        switch (action) {
            case "register": //the register.jsp form has the parameter action=register
                session.setAttribute("username", request.getParameter("usernameInput"));

                request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
                break;

            case "add": //the shoppingList.jsp form add button has the parameter action=add
                String itemName = request.getParameter("itemNameInput");
                if (itemName == null || itemName.isEmpty()) {
                    request.setAttribute("addError", true);
                    request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                            .forward(request, response);

                } else {
                    itemList.add(itemName);
                    session.setAttribute("itemList", itemList);
                    request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                            .forward(request, response);
                }
                break;

            case "delete":
                String deleteItem = request.getParameter("deleteItem");
                itemList.remove(itemList.indexOf(deleteItem));
                request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                            .forward(request, response);
                break;

            default:
        }
    }

}
