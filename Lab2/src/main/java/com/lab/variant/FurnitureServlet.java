package com.lab.variant;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;


@WebServlet("/furniture")
public class FurnitureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Furniture furniture = new Furniture("Диван", "https://www.divani.ua/images/thumbnails/1002/670/detailed/1354/22069_9399105.jpg", "Кутовий диван", "230см");
        Gson gson = new Gson();
        String json = gson.toJson(furniture);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}