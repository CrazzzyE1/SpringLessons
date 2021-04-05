package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private List<Product> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h3>Создание нового продукта:</h3>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Введите название: <input type='text' name='title'><br><br>");
        resp.getWriter().println("Введите цену: <input type='text' name='cost'><br><br>");
        resp.getWriter().println("<input type='submit'>");
        resp.getWriter().println("</form>");

        String title = req.getParameter("title");
        String costStr = req.getParameter("cost");

        System.out.println(title);
        System.out.println(costStr);

       if(title != null && costStr != null) {
           int cost;
           try{
               cost = Integer.parseInt(costStr);
               list.add(new Product(cost, title));
           } catch (IllegalArgumentException e) {
               System.out.println("Wrong cost");
           }

        }
        for (Product p : list) {
            resp.getWriter().println("<p>" + p.getId() + ". " + p.getTitle() + " - Cost: " + p.getCost() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
