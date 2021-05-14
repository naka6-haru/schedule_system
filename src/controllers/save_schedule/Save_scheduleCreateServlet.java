package controllers.save_schedule;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Save_schedule;
import models.Schedule_date;
import models.User;
import models.validators.Save_scheduleValidator;
import utils.DBUtil;

/**
 * Servlet implementation class Save_scheduleCreateServlet
 */
@WebServlet("/save_schedule/create")
public class Save_scheduleCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save_scheduleCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Save_schedule ss = new Save_schedule();
            User u = (User)request.getSession().getAttribute("user");
            Schedule_date sd = (Schedule_date)request.getSession().getAttribute("schedule_date");

            ss.setUser(u);
            ss.setSchedule_date(sd);
            ss.setMonday1(request.getParameter("monday1"));
            ss.setMonday2(request.getParameter("monday2"));
            ss.setTuesday1(request.getParameter("tuesday1"));
            ss.setTuesday2(request.getParameter("tuesday2"));
            ss.setWednesday1(request.getParameter("wednesday1"));
            ss.setWednesday2(request.getParameter("wednesday2"));
            ss.setThursday1(request.getParameter("thursday1"));
            ss.setThursday2(request.getParameter("thursday2"));
            ss.setFriday1(request.getParameter("friday1"));
            ss.setFriday2(request.getParameter("friday2"));
            ss.setSaturday1(request.getParameter("saturday1"));
            ss.setSaturday2(request.getParameter("saturday2"));
            ss.setSunday1(request.getParameter("sunday1"));
            ss.setSunday2(request.getParameter("sunday2"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            ss.setCreated_at(currentTime);

            List<String> errors = Save_scheduleValidator.validate(ss);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("schedule", ss);
                request.setAttribute("schedule_date", sd);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/save_schedule/new.jsp");
                rd.forward(request, response);
            }else{

                em.getTransaction().begin();
                em.persist(ss);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "保存が完了しました。");

                response.sendRedirect(request.getContextPath() + "/schedule_date/index");
            }
        }
    }

}
