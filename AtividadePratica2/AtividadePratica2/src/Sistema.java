import java.util.Scanner;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Buscar filme");
            System.out.println("3. Editar filme");
            System.out.println("4. Excluir filme");
            System.out.println("5. Listar filmes");
            System.out.println("6. Excluir todos os filmes");
            System.out.println("0. Sair");
            System.out.println("------------");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    ManipuladorFilmes.cadastrarFilme();
                    break;
                case 2:
                    System.out.println("Digite o título do filme a ser buscado:");
                    String tituloBusca = scanner.nextLine();
                    ManipuladorFilmes.buscarFilme(tituloBusca);
                    break;
                case 3:
                    System.out.println("Digite o título do filme a ser editado:");
                    String tituloEdicao = scanner.nextLine();
                    ManipuladorFilmes.editarFilme(tituloEdicao);
                    break;
                case 4:
                    System.out.println("Digite o título do filme a ser excluído:");
                    String tituloExclusao = scanner.nextLine();
                    ManipuladorFilmes.excluirFilme(tituloExclusao);
                    break;
                case 5:
                    ManipuladorFilmes.listarFilmes();
                    break;
                case 6:
                    ManipuladorFilmes.excluirTodosFilmes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}