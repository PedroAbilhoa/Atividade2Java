import java.util.Scanner;

public class InterfaceUsuario {
    private SistemaGerenciamento sistema;
    private Scanner scanner;

    public InterfaceUsuario() {
        sistema = new SistemaGerenciamento();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Mostrar todos os funcionários");
            System.out.println("4. Buscar funcionário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    mostrarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarFuncionario() {
        System.out.println("\n==== Adicionar Funcionário ====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 

        
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        System.out.print("Opção: ");
        int opcaoTipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcaoTipo) {
            case 1:
                System.out.print("Bônus anual: ");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("Equipe: ");
                String equipe = scanner.nextLine();
                sistema.adicionarFuncionario(new Gerente(nome, matricula, bonusAnual, equipe));
                break;
            case 2:
                System.out.print("Quantidade de tecnologias que domina: ");
                int quantidadeTecnologias = scanner.nextInt();
                scanner.nextLine(); 
                String[] tecnologias = new String[quantidadeTecnologias];
                for (int i = 0; i < quantidadeTecnologias; i++) {
                    System.out.print("Tecnologia " + (i + 1) + ": ");
                    tecnologias[i] = scanner.nextLine();
                }
                sistema.adicionarFuncionario(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.print("Horas de trabalho: ");
                int horasDeTrabalho = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Supervisor: ");
                String supervisor = scanner.nextLine();
                sistema.adicionarFuncionario(new Estagiario(nome, matricula, horasDeTrabalho, supervisor));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void removerFuncionario() {
        System.out.println("\n==== Remover Funcionário ====");
        System.out.print("Digite o nome ou matrícula do funcionário: ");
        String termo = scanner.nextLine();
        Funcionario funcionario = sistema.buscarFuncionario(termo);
        if (funcionario != null) {
            sistema.removerFuncionario(funcionario);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void mostrarFuncionarios() {
        System.out.println("\n==== Lista de Funcionários ====");
        if (sistema.getFuncionarios().isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            sistema.mostrarFuncionarios();
        }
    }

    private void buscarFuncionario() {
        System.out.println("\n==== Buscar Funcionário ====");
        System.out.print("Digite o nome ou matrícula do funcionário: ");
        String termo = scanner.nextLine();
        Funcionario funcionario = sistema.buscarFuncionario(termo);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getMatricula());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        interfaceUsuario.exibirMenu();
    }
}