package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("##### TESTE1: FindById implementation ######");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println(" ");
        System.out.println("##### TESTE2: FindByDepartment implementation ######");
        Department dep = new Department(11, null);
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        sellers.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("##### TESTE3: FindAll timplementation ######");
        List<Seller> list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("##### TESTE4: insert timplementation ######");
        Department ti = new Department(5, null);
        sellerDao.insert(new Seller(null, "linus", "linus.torvald@gmail.com", new Date(), 50000.0, ti));
        System.out.println("Insertion okay id");

        System.out.println(" ");
        System.out.println("##### TESTE5: update timplementation ######");
        Seller theBest = sellerDao.findById(7);
        theBest.setBaseSalary(32000.0);
        sellerDao.update(theBest);
        System.out.println("Update okaye id = " + theBest.getId());
    }
}