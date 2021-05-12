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
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleShowServlet
 */
@WebServlet("/schedule/show")
public class ScheduleShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleShowServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Schedule s = em.find(Schedule.class,Integer.parseInt(request.getParameter("id")));

        em.close();

        if(null == s){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/show.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("schedule",s);
            request.getSession().setAttribute("schedule_id", s.getId());
            request.setAttribute("_token", request.getSession().getId());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/show.jsp");
        rd.forward(request, response);
    }

}
