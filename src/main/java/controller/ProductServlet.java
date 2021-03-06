package controller;

import model.Product;
import service.ProductSevice;
import service.ProductSeviceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductSevice productSevice = new ProductSeviceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if(act == null) {
            act = "";
        }
        switch (act) {
            default:
                showList(request,response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productSevice.findAll();
        request.setAttribute("list",products);
        request.getRequestDispatcher("List.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if(act == null) {
            act = "";
        }
        switch (act) {
            case"searchName":
                searchName(request,response);
                break;
            case"searchprice":
                searchPrice(request,response);
        }
    }

    private void searchPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        int start = Integer.parseInt(request.getParameter("start"));
        int end = Integer.parseInt(request.getParameter("end"));
        List<Product> products = productSevice.findByPrice(start, end);
        request.setAttribute("product", products);
        requestDispatcher.forward(request, response);
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("List.jsp");
        String name = request.getParameter("name");
        List<Product> products = productSevice.findByName(name);
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }
}
