package webservlet;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import service.CompanyService;
import service.EmployeeService;
import service.TestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello", "/bid"})
public class SimpleServlet extends HttpServlet {

    private EmployeeService employeeService;

    private CompanyService companyService;

    private TestService testService;

    private TestService testService2;


    @Override
    public void init() throws ServletException {
        super.init();
        // Get the Guice injector from the ServletContext
        Injector injector = (Injector) getServletContext().getAttribute(Injector.class.getName());
        // Use the injector to get an instance of the ServiceInterface
        employeeService = injector.getInstance(EmployeeService.class);
        companyService = injector.getInstance(CompanyService.class);
        testService = injector.getInstance(Key.get(TestService.class, Names.named("TestServiceImpl")));
        testService2 = injector.getInstance(Key.get(TestService.class, Names.named("TestServiceImpl2")));
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String str = "Hello, welcome to bid server";
        resp.setContentType("text/html");
        resp.getWriter().println(str);
        System.out.println("Employee Object :" + employeeService + "    -    " + employeeService.getName("Called thru EmployeeService Object"));
        System.out.println("Company Object : " + companyService + "    -    " + companyService.getName("Called thru CompanyService Service Object"));
        System.out.println("Test Object :" + testService + "    -    " + testService.getName("Called thru TestService Object"));
        System.out.println("Test 2 Object :" + testService2 + "    -    " + testService2.getName("Called thru TestService 2 Object"));
    }
}
