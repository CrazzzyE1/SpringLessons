package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/productsNew")
public class ProductsServletNew extends HttpServlet {
    private List<Product> list;
    private Random rnd;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        rnd = new Random();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h3>Генерация 10 новых продуктов:</h3>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("<input type='submit' name='Generate'>");
        resp.getWriter().println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        for (int i = 0; i < 10; i++) {
            list.add(new Product(rnd.nextInt(10), "ProductName" + i));
        }
        for (Product p : list) {
            resp.getWriter().println("<p> Product Id: " + p.getId() + " - Name: " + p.getTitle() + " - Cost: " + p.getCost() + "</p>");
        }
        list.clear();
    }
}
