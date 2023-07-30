package webservlet;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import service.*;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        /**
         By default, Guice injects a new and separate instance of an object for each dependency
         (similar to the prototype scope in Spring), whereas Spring provides singletons by default.
         */
        bind(EmployeeService.class).to(EmployeeServiceImpl.class);
        bind(CompanyService.class).to(CompanyServiceImpl.class).in(Scopes.SINGLETON); // single instance throughout the application when injected thru Scopes.SINGLETON
        bind(TestService.class).annotatedWith(Names.named("TestServiceImpl")).to(TestServiceImpl.class);
        bind(TestService.class).annotatedWith(Names.named("TestServiceImpl2")).to(TestServiceImpl2.class);
    }
}
