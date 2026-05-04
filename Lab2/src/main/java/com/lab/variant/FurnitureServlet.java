package com.lab.variant;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.util.List;

@WebServlet("/furniture")
public class FurnitureServlet extends HttpServlet {
    private FurnitureService furnitureService = new FurnitureService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Furniture> furnitures = furnitureService.getAllFurnitures();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(furnitures));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Furniture newFurniture = gson.fromJson(req.getReader(), Furniture.class);
        furnitureService.addFurniture(newFurniture);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Furniture updatedFurniture = gson.fromJson(req.getReader(), Furniture.class);
        if (furnitureService.updateFurniture(updatedFurniture)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (furnitureService.deleteFurniture(id)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}