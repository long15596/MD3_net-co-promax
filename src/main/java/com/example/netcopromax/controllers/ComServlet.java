package com.example.netcopromax.controllers;

import com.example.netcopromax.models.Com;
import com.example.netcopromax.services.ComService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ComServlet", value = "/computers")
public class ComServlet extends HttpServlet {
    ComService comService = new ComService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCom(request, response);
                break;
            default:
                showListPage(request, response);
        }
    }

    private void deleteCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        comService.delete(id);
        response.sendRedirect("computers");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("computer/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Com  com = comService.findById(id);
        request.setAttribute("mayCanSua", com);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("computer/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("computer/computers.jsp");
        List<Com> comList = comService.showAll();
        request.setAttribute("danhSachMay", comList);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                createCom(req, resp);
                break;
            case "edit":
                editCom(req, resp);
                break;
        }
    }

    private void editCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        comService.update(id, new Com(id, name, price));
        resp.sendRedirect("/computers");
    }

    private void createCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        comService.add(new Com(id, name, price));
        resp.sendRedirect("/computers");
    }

}