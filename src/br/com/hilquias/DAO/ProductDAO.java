package br.com.hilquias.DAO;
import br.com.hilquias.model.Product;
import br.com.hilquias.connection.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void registerProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (name, price, stock) VALUES (?, ?, ?)";

        PreparedStatement ps = Connection.connect().prepareStatement(sql);

        ps.setString(1, product.getName());
        ps.setBigDecimal(2, product.getPrice());
        ps.setInt(3, product.getStock());

        ps.execute();
        ps.close();
    }

    public void listProduct() throws SQLException {
        List<Product> lista = new ArrayList<>();

        String sql = "SELECT * FROM product";

        PreparedStatement ps = Connection.connect().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setStock(rs.getInt("stock"));

            System.out.println(product);

            lista.add(product);
        }
        rs.close();
        ps.close();

    }

    public Product searchId(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = ?";

        PreparedStatement ps = Connection.connect().prepareStatement(sql);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Product product = new Product();
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("price"));
            System.out.println(rs.getString("stock"));

            rs.close();
            ps.close();

            return product;
        }

        rs.close();
        ps.close();
        return null;
    }

    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET name = ?, price = ?, stock = ? WHERE id = ?";

        PreparedStatement ps = Connection.connect().prepareStatement(sql);;

        ps.setString(1, product.getName());
        ps.setBigDecimal(2, product.getPrice());
        ps.setInt(3, product.getStock());
        ps.setInt(4, product.getId());

        ps.executeUpdate();
        ps.close();

    }

    public void deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";


        PreparedStatement ps = Connection.connect().prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        ps.close();

    }
}
