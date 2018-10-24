package com.nozomi.training.certgen;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    public static final String HIKE = "hike";
    public static final String DURATION = "duration";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String YEAR = "year";
    public static final String NUMHIKERS = "numHikers";
    public static final String DATE = "ADate";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        Calculator calc = (Calculator) session.getAttribute(HIKE);
        if (calc == null) {
            calc = new Calculator();
            session.setAttribute(HIKE, calc);
            session.setAttribute(DATE, calc);
            session.setAttribute(DURATION, calc);
            session.setAttribute(NUMHIKERS, calc);
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            String hike = request.getParameter(HIKE);
            String date = request.getParameter(DATE);
            String duration = request.getParameter(DURATION);
            String numHikers = request.getParameter(NUMHIKERS);

            if (calc.runChecks(date, duration, hike, numHikers)) {
                calc.setHike(hike);
                calc.setDate(date);
                calc.setDuration(duration);
                calc.setNumHikers(numHikers);

                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/result.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/retry.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
