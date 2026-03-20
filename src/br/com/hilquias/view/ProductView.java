package br.com.hilquias.view;
import br.com.hilquias.controller.ProdutoController;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductView {

    public void productView () throws SQLException {
        ProdutoController controller = new ProdutoController();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("---BEM-VINDO(A)---");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - LISTAR PRODUTOS");
            System.out.println("3 - BUSCAR PRODUTO POR ID");
            System.out.println("4 - ATUALIZAR PRODUTO");
            System.out.println("5 - EXCLUIR PRODUTO");
            System.out.println("0 - SAIR");
            System.out.println("ESCOLHA UMA DAS OPÇÕES:");
            byte op = input.nextByte();

            switch (op) {
                case 1 -> controller.addProduct();
                case 2 -> controller.viewProduct();
                case 3 -> controller.viewProductID();
                case 4 -> controller.modifyProduct();
                case 5 -> controller.removeProduct();
                case 0 -> System.exit(0);

            }
        }
    }

}
