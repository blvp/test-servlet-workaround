package example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pavel on 29.09.2014.
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //тут мы обрабатываем параметры из формы, которая задана на страничке  loginPage.jsp
        String login = req.getParameter("login");
        String pwd = req.getParameter("password");
        if(login == null || login.equals("")){
            String error = "fields must not be null";
            req.setAttribute("error", error);//потом на .jsp можно будет его получить таким образом ${error}
            getServletContext().getRequestDispatcher("/loginPage").forward(req,resp);
        } else {
            req.setAttribute("success", login);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/loginSuccess.jsp").forward(req, resp);
        }
    }
}
