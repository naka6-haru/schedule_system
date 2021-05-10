package controllers.schedule_date;

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
import models.validators.Schedule_dateValidator;
import utils.DBUtil;

/**
 * Servlet implementation class Schedule_dateCreateServlet
 */
@WebServlet("/schedule_date/create")
public class Schedule_dateCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Schedule_dateCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Schedule_date s = new Schedule_date();

            s.setSchedule_start(request.getParameter("schedule_start"));
            s.setSchedule_last(request.getParameter("schedule_last"));

            List<String> errors = Schedule_dateValidator.validate(s);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("schedule_date", s);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedule_dates/new.jsp");
                rd.forward(request, response);
            }else{
                em.getTransaction().begin();
                em.persist(s);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/schedule_date/index");
            }
        }
    }

}
