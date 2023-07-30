package webservlet;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new BasicModule());
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
        System.out.println("ServletContextListener has been started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener has been stopped.");
    }

}
