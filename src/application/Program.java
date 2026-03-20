package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("##### TESTE: FindById implementation ######");
        Seller seller = sellerDao.findById(1);
        System.out.println(seller);

        System.out.println(" ");
        System.out.println("##### TESTE: FindByDepartment implementation ######");
        Department dep = new Department(11, null);
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        sellers.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("##### TESTE: FindAll timplementation ######");
        List<Seller> list = sellerDao.findAll();
        list.forEach(System.out::println);
    }
}