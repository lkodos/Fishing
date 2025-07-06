package ru.lkodos.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.service.FishService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/fish")
public class FishServlet extends HttpServlet {

    private final FishService fishService = FishService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8);

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Перечень рыб</h1>");
            writer.write("<ul>");
            fishService.findAll().forEach( fishDto -> {
                writer.write("""
                <li>
                    <a href="">
                </li>
                """);
            });
            writer.write("</ul>");
        }
    }
}
