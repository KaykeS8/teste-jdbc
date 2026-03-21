package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("##### TESTE 1 FindBYId implementation");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println(departmentDao.findById(5));

        System.out.println("##### TESTE 1 Insert implementation");
        departmentDao.insert(new Department(null, "Marketing"));
        System.out.println("Insert completed");


        System.out.println("##### TESTE 3 FindAll implementation");
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);

        System.out.println("##### TESTE 4 Update implementation");
        Department markt = departmentDao.findById(11);
        markt.setName("Cozinha");
        departmentDao.update(markt);
        System.out.println("Update with successfully");

        System.out.println("##### TESTE 5 Update implementation");
        departmentDao.deleteById(11);
        System.out.println("Deleted with successfully");
    }
}