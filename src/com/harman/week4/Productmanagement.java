package com.harman.week4;

import java.sql.*;
import java.util.Scanner;

public class Productmanagement {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int option;
        while(true) {
            System.out.println("Select an option: ");
            System.out.println("1.Add a products: ");
            System.out.println("2.view all products: ");
            System.out.println("3.Search a product using product  code: ");
            System.out.println("4.Update product details using product Code: ");
            System.out.println("5.Delete a product  using product Code: ");
            System.out.println("6.Display all the details of products  whose price  is greater than 50000: ");
            System.out.println("7.Display the count of total number of products  in the company: ");
            System.out.println("8.Display all the product details in alphabetical order: ");
            System.out.println("9.Exit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        String product_code, product_name, brand, price, model, year_of_manufacture, expiry_date;
                        System.out.println("enter the product_code: ");
                        product_code = in.next();
                        System.out.println("enter the product_name: ");
                        product_name = in.next();
                        System.out.println("enter the brand: ");
                        brand = in.next();
                        System.out.println("enter the price: ");
                        price = in.next();
                        System.out.println("enter the model: ");
                        model = in.next();
                        System.out.println("enter the year_of_manufacture: ");
                        year_of_manufacture = in.next();
                        System.out.println("enter the expiry_date: ");
                        expiry_date = in.next();

                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`( `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacture`, `expiry_date`) VALUES(" + product_code + ",'" + product_name + "','" + brand + "'," + price + ",'" + model + "'," + year_of_manufacture + "," + expiry_date + ")");
                        System.out.println("inserted successfully");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("view all products:");

                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacture`, `expiry_date` FROM `products` WHERE 1");
                        while (rs.next()) {
                            System.out.println("product_code= " + rs.getInt("product_code"));
                            System.out.println("product_name= " + rs.getString("product_name"));
                            System.out.println("brand= " + rs.getString("brand"));
                            System.out.println("price= " + rs.getInt("price"));
                            System.out.println("model= " + rs.getString("model"));
                            System.out.println("year_of_manufacture= " + rs.getInt("year_of_manufacture"));
                            System.out.println("expiry_date= " + rs.getInt("expiry_date"));
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {

                        int productcode;
                        System.out.println("enter the productcode to be search:");
                        productcode = in.nextInt();
                        Connection c =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `product_code`="+productcode);
                        while (rs.next()) {
                            System.out.println("product_name= " + rs.getString("product_name"));
                            System.out.println("brand= " + rs.getString("brand"));
                            System.out.println("price= " + rs.getInt("price"));
                            System.out.println("model= " + rs.getString("model"));
                            System.out.println("year_of_manufacture= " + rs.getInt("year_of_manufacture"));
                            System.out.println("expiry_date= " + rs.getInt("expiry_date"));
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {

                        int product_code;
                        System.out.println("enter the productcode to be update:");
                        product_code = in.nextInt();

                        String  product_name, brand, price, model, year_of_manufacture, expiry_date;
                        System.out.println("enter the product_name: ");
                        product_name = in.next();
                        System.out.println("enter the brand: ");
                        brand = in.next();
                        System.out.println("enter the price: ");
                        price = in.next();
                        System.out.println("enter the model: ");
                        model = in.next();
                        System.out.println("enter the year_of_manufacture: ");
                        year_of_manufacture = in.next();
                        System.out.println("enter the expiry_date: ");
                        expiry_date = in.next();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `products` SET `product_name`='"+product_name+"',`brand`='"+brand+"',`price`="+price+",`model`='"+model+"',`year_of_manufacture`="+year_of_manufacture+",`expiry_date`="+expiry_date+" WHERE `product_code`="+product_code);

                        System.out.println("updated successfully");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 5:
                    try {
                        int product_code;
                        System.out.println("enter the productcode to be deleted: ");
                        product_code=in.nextInt();
                        Connection c =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("DELETE FROM `products` WHERE `product_code`="+product_code);
                        System.out.println("deleted successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }break;
                case 6:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT * FROM `products` WHERE `price`>50000");
                        while (rs.next())
                        {
                            System.out.println("product_code= " + rs.getInt("product_code"));
                            System.out.println("product_name= " + rs.getString("product_name"));
                            System.out.println("brand= " + rs.getString("brand"));
                            System.out.println("model= " + rs.getString("model"));
                            System.out.println("year_of_manufacture= " + rs.getInt("year_of_manufacture"));
                            System.out.println("expiry_date= " + rs.getInt("expiry_date"));
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 7:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT count(*) FROM `products`");
                        rs.next();
                        int count=rs.getInt(1);
                        System.out.println("the total count of the products= "+count);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 8:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs=stmt.executeQuery("SELECT `product_code`, `product_name`, `brand`, `price`, `model`, `year_of_manufacture`, `expiry_date` FROM `products` WHERE 1 order by product_name asc");
                        while(rs.next())
                        {
                            System.out.println("product_code= " + rs.getInt("product_code"));
                            System.out.println("product_name= " + rs.getString("product_name"));
                            System.out.println("brand= " + rs.getString("brand"));
                            System.out.println("price= " + rs.getInt("price"));
                            System.out.println("model= " + rs.getString("model"));
                            System.out.println("year_of_manufacture= " + rs.getInt("year_of_manufacture"));
                            System.out.println("expiry_date= " + rs.getInt("expiry_date"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("invaild option");


            }
        }

    }
}
