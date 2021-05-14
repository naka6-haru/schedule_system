package controllers.save_schedule;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Save_schedule;
import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class Save_scheduleNewServlet
 */
@WebServlet("/save_schedule/new")
public class Save_scheduleNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save_scheduleNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Schedule s = em.find(Schedule.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("schedule", s);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("user", s.getUser());
        request.getSession().setAttribute("schedule_date", s.getSchedule_date());
        request.setAttribute("save_schedule", new Save_schedule());


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/save_schedule/new.jsp");
        rd.forward(request, response);
    }

}
