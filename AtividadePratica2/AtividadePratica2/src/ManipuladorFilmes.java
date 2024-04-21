import java.util.ArrayList;
import java.util.Scanner;

public class ManipuladorFilmes {
    private static ArrayList<Filme> filmes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarFilme() {
        System.out.println("Digite o título do filme:");
        String titulo = scanner.nextLine();
        
        System.out.println("Digite o ano de lançamento do filme:");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Digite o diretor do filme:");
        String diretor = scanner.nextLine();

        filmes.add(new Filme(titulo, anoLancamento, diretor));
        System.out.println("Filme cadastrado com sucesso!");
    }
    
    public static void buscarFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Filme encontrado:");
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Ano de lançamento: " + filme.getAnoLancamento());
                System.out.println("Diretor: " + filme.getDiretor());
                return;
            }
        }
        System.out.println("Filme não encontrado!");
    }

    public static void editarFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Digite o novo título do filme:");
                String novoTitulo = scanner.nextLine();
                System.out.println("Digite o novo ano de lançamento do filme:");
                int novoAno = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                filme.setTitulo(novoTitulo);
                filme.setAnoLancamento(novoAno);
                System.out.println("Digite o novo diretor do filme:");
                String novoDiretor = scanner.nextLine();
                filme.setDiretor(novoDiretor);
                System.out.println("Filme editado com sucesso!");
                return;
            }
        }
        System.out.println("Filme não encontrado!");
    }

    public static void excluirFilme(String titulo) {
        ArrayList<Filme> filmesParaExcluir = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmesParaExcluir.add(filme);
            }
        }
        if (!filmesParaExcluir.isEmpty()) {
            filmes.removeAll(filmesParaExcluir);
            System.out.println("Filme(s) excluído(s) com sucesso!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    public static void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados.");
        } else {
            System.out.println("--- Lista de Filmes ---");
            for (Filme filme : filmes) {
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Ano de lançamento: " + filme.getAnoLancamento());
                System.out.println("Diretor: " + filme.getDiretor());
                System.out.println("----------------------");
            }
        }
    }

    public static void excluirTodosFilmes() {
        filmes.clear();
        System.out.println("Todos os filmes foram excluídos.");
    }
}