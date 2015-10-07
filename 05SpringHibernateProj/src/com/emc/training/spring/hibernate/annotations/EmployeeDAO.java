package com.emc.training.spring.hibernate.annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO
{
    @Autowired
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template)
    {
        this.template = template;
    }

    // @Transactional(propagation = Propagation.REQUIRED)
    public void addEmployee(Employee e)
    {
        template.save(e);
        if (e.getEmployeeId() > 102)
        {
            throw new RuntimeException("invalid employee id");
        }
    }

    public List<Employee> getAllEmployees()
    {
        String query = "select e from Employee as e";
        return template.find(query);
    }

    public Employee findEmployee(int id)
    {
        return template.get(Employee.class, id);
    }
}
