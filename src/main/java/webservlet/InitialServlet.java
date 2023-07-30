package webservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class InitialServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String str = "Welcome to Servlet program";
        resp.setContentType("text/html");
        resp.getWriter().println(str);
        System.out.println("Welcome to Servlet Application on Tomcat Server");
    }
}
