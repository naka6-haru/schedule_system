package controllers.submit_schedule;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class Submit_scheduleIndexServlet
 */
@WebServlet("/submit_schedule/index")
public class Submit_scheduleIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit_scheduleIndexServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Schedule_date sd = em.find(Schedule_date.class,Integer.parseInt(request.getParameter("id")));

        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) { }

        List<Schedule> schedule = em.createNamedQuery("getDateAllSchedules",Schedule.class)
                                    .setParameter("schedule_date", sd)
                                    .setFirstResult(20 * (page - 1))
                                    .setMaxResults(20)
                                    .getResultList();

        long schedule_count = (long)em.createNamedQuery("getDateAllSchedulesCount",Long.class)
                                       .setParameter("schedule_date", sd)
                                       .getSingleResult();

        em.close();

        request.setAttribute("schedule_date",sd);
        request.setAttribute("schedule", schedule);
        request.setAttribute("schedule_count", schedule_count);
        request.setAttribute("page", page);

        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/submit_schedule/index.jsp");
        rd.forward(request, response);
    }

}
