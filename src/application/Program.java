package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department dept = new Department(1 ,"TI");
        Seller seller1 = new Seller(1, "kayke", "kayke.simao@gmail.com", new Date(), 3500.00, dept);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller1);
    }
}