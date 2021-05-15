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
import utils.DBUtil;

/**
 * Servlet implementation class Save_scheduleEditServlet
 */
@WebServlet("/save_schedule/edit")
public class Save_scheduleEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save_scheduleEditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Save_schedule ss = em.find(Save_schedule.class, Integer.parseInt(request.getParameter("id")));

        em.close();
        if(null == ss){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/save_schedule/edit.jsp");
            rd.forward(request, response);
        }else{

            request.setAttribute("save_schedule", ss);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("save_schedule_id", ss.getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/save_schedule/edit.jsp");
            rd.forward(request, response);
        }
    }
}
