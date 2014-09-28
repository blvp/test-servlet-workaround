package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pavel on 29.09.2014.
 */

public class LoginPage extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //короче здесь тупо отрисовка логин пейджа
        getServletContext().getRequestDispatcher("/WEB-INF/pages/loginPage.jsp").forward(req, resp);
    }
}
