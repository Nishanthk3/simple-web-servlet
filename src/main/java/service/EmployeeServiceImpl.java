package service;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private CompanyService companyService;

    @Inject
    @Named("TestServiceImpl")
    private TestService testService;

    @Inject
    @Named("TestServiceImpl2")
    private TestService testService2;

    @Override
    public String getName(String name) {

        System.out.println("Company Object :" + companyService + "    -    " + name + "    -    "  + companyService.getName("Called thru EmployeeService.CompanyService Object"));
        System.out.println("Test Object :" + testService + "    -    " + name + "    -    "  + testService.getName("Called thru EmployeeService.TestService Object"));
        System.out.println("Test 2 Object :" + testService2 + "    -    " + name + "    -    "  + testService2.getName("Called thru EmployeeService.TestService2 Object"));
        return name;
    }
}
