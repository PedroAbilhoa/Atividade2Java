import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamento {
    private List<Funcionario> funcionarios;

    public SistemaGerenciamento() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void mostrarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() + ", Matrícula: " + f.getMatricula());
        }
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(String termo) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(termo) || String.valueOf(f.getMatricula()).equals(termo)) {
                return f;
            }
        }
        return null;
    }
}
