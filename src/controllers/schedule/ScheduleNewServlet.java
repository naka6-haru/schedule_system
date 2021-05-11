package controllers.schedule;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import models.Schedule_date;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleNewServlet
 */
@WebServlet("/schedule/new")
public class ScheduleNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Schedule_date s = em.find(Schedule_date.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("schedule_date", s);
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("schedule", new Schedule());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/new.jsp");
        rd.forward(request, response);
    }

}
