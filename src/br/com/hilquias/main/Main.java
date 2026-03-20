package br.com.hilquias.main;
import br.com.hilquias.view.ProductView;
import java.sql.SQLException;

public class Main {
    static void main() throws SQLException {
        ProductView view = new ProductView();
        view.productView();

    }
}
