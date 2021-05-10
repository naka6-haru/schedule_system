package controllers.schedule_date;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule_date;

/**
 * Servlet implementation class Schedule_dateNewServlet
 */
@WebServlet("/schedule_date/new")
public class Schedule_dateNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Schedule_dateNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("schedule_date", new Schedule_date());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule_dates/new.jsp");
        rd.forward(request, response);
    }

}
