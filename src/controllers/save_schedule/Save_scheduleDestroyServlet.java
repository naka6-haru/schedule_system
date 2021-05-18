package controllers.save_schedule;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Save_schedule;
import models.Schedule_date;
import utils.DBUtil;

/**
 * Servlet implementation class Save_scheduleDestroyServlet
 */
@WebServlet("/save_schedule/destroy")
public class Save_scheduleDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save_scheduleDestroyServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Save_schedule ss = em.find(Save_schedule.class, Integer.parseInt(request.getParameter("id")));

        Schedule_date sd = ss.getSchedule_date();

        em.getTransaction().begin();
        em.remove(ss);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/save_schedule/index?id=" + sd.getId());
    }
}
