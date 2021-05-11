package controllers.schedule;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule_date;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleIndexServlet
 */
@WebServlet("/schedule/index")
public class ScheduleIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleIndexServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) { }

        List<Schedule_date> schedule_dates= em.createNamedQuery("getAllSchedule_dates",Schedule_date.class)
                                     .setFirstResult(15 * (page - 1))
                                     .setMaxResults(15)
                                     .getResultList();

        long schedule_date_count = (long)em.createNamedQuery("getSchedule_datesCount",Long.class)
                                       .getSingleResult();


        em.close();

        request.setAttribute("schedule_dates", schedule_dates);
        request.setAttribute("schedule_date_count", schedule_date_count);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/index.jsp");
        rd.forward(request, response);
    }

}
