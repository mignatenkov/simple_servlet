package com.korfax.simple_servlet.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Korfax on 2017-11-21.
 */
public class MainController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private ArrayList<String> lines = new ArrayList<String>();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        log.debug("get!");

        RequestDispatcher rd = request.getRequestDispatcher("views/main.jsp");
        request.setAttribute("lines", linesToString());

        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request,
                          HttpServletResponse response)
    throws ServletException, IOException {
        log.debug("post!");

        String newLine = request.getParameter("new_line");
        lines.add(newLine);

        RequestDispatcher rd = request.getRequestDispatcher("views/main.jsp");
        request.setAttribute("lines", linesToString());
        rd.forward(request, response);
    }

    private String linesToString() {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append(",");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length()-1);
        log.debug(sb.toString());
        return sb.toString();
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.debug("service!");
        super.service(req, res);
    }

}
