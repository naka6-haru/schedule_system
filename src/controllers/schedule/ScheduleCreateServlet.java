package controllers.schedule;

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

import models.Schedule;
import models.Schedule_date;
import models.User;
import models.validators.ScheduleValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleCreateServlet
 */
@WebServlet("/schedule/create")
public class ScheduleCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Schedule s = new Schedule();
            Schedule_date sd = em.find(Schedule_date.class, Integer.parseInt(request.getParameter("id")));
            s.setUser((User)request.getSession().getAttribute("login_user"));

            s.setSchedule_date(sd);
            s.setMonday1(request.getParameter("monday1"));
            s.setMonday2(request.getParameter("monday2"));
            s.setTuesday1(request.getParameter("tuesday1"));
            s.setTuesday2(request.getParameter("tuesday2"));
            s.setWednesday1(request.getParameter("wednesday1"));
            s.setWednesday2(request.getParameter("wednesday2"));
            s.setThursday1(request.getParameter("thursday1"));
            s.setThursday2(request.getParameter("thursday2"));
            s.setFriday1(request.getParameter("friday1"));
            s.setFriday2(request.getParameter("friday2"));
            s.setSaturday1(request.getParameter("saturday1"));
            s.setSaturday2(request.getParameter("saturday2"));
            s.setSunday1(request.getParameter("sunday1"));
            s.setSunday2(request.getParameter("sunday2"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            s.setCreated_at(currentTime);

            List<String> errors = ScheduleValidator.validate(s);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("schedule", s);
                request.setAttribute("schedule_date", sd);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule/new.jsp");
                rd.forward(request, response);
            }else{
                em.getTransaction().begin();
                em.persist(s);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/schedule/index?id=" + request.getSession().getAttribute("login_user"));
            }
        }
    }

}
