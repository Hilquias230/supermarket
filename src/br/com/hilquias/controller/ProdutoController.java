package br.com.hilquias.controller;

import br.com.hilquias.DAO.ProductDAO;
import br.com.hilquias.model.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProdutoController {
    Product product = new Product();
    ProductDAO dao = new ProductDAO();
    Scanner input = new Scanner(System.in);

    public void addProduct() throws SQLException {
        System.out.println("NOME:");
        String name = input.next();
        product.setName(name);

        System.out.println("PREÇO:");
        double price = input.nextDouble();
        product.setPrice(price);

        System.out.println("ESTOQUE:");
        int stock = input.nextInt();
        product.setStock(stock);

        dao.registerProduct(product);
    }

    public void viewProduct() throws SQLException {
        dao.listProduct();
    }

    public void viewProductID() throws SQLException {
        System.out.println("DIGITE O ID:");
        int id = input.nextInt();

        dao.searchId(id);
    }

    public void modifyProduct() throws SQLException {
        System.out.println("NOME:");
        String name = input.next();
        product.setName(name);

        System.out.println("PREÇO:");
        double price = input.nextDouble();
        product.setPrice(price);

        System.out.println("ESTOQUE:");
        int stock = input.nextInt();
        product.setStock(stock);

        System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA MUDAR:");
        int id = input.nextInt();
        product.setId(id);

        dao.updateProduct(product);
    }

    public void removeProduct() throws SQLException {
        System.out.println("DIGITE O ID DO PRODUTO QUE DESEJA EXCLUIR:");
        int id = input.nextInt();
        dao.deleteProduct(id);
    }
}
