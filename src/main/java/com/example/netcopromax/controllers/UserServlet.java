package com.example.netcopromax.controllers;

import com.example.netcopromax.models.Com;
import com.example.netcopromax.models.User;
import com.example.netcopromax.services.ComService;
import com.example.netcopromax.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
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
        userService.delete(id);
        response.sendRedirect("users");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("khachCanSua", user);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/users.jsp");
        List<User> userList = userService.showAll();
        request.setAttribute("danhSachKhach", userList);
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        double money = Double.parseDouble(req.getParameter("money"));
        userService.update(id, new User(id, name, username, password, money));
        resp.sendRedirect("/users");
    }

    private void createCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        double money = Double.parseDouble(req.getParameter("money"));
        userService.add(new User(id, name, username, password, money));
        resp.sendRedirect("/users");
    }

}