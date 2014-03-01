import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2/27/14.
 */
@WebServlet("/city/*")
public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("YAY, I'm here - "+getServletName());
        req.getServletContext().getRequestDispatcher("/city.ftl").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        if(req.getRequestURI().endsWith("clear")){
            req.getSession().setAttribute("city", null);
            resp.sendRedirect("/");
            return;
        } else {
            String matter = req.getParameter("regionId");
            req.getSession().setAttribute("city", matter);
            resp.sendRedirect("/");
            return;
        }
    }
}
