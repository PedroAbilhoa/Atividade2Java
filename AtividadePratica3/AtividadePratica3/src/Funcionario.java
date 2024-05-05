abstract class Funcionario {
    private String nome;
    private int matricula;

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}

class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        // Exemplo de cálculo de salário para gerente
        return 5000 + bonusAnual;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando com a equipe: " + equipe);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso da equipe: " + equipe);
    }
}

class Desenvolvedor extends Funcionario implements Trabalhavel {
    private String[] tecnologias;

    public Desenvolvedor(String nome, int matricula, String[] tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
        // Exemplo de cálculo de salário para desenvolvedor
        return 3000 + (tecnologias.length * 500);
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando nas tecnologias: " + String.join(", ", tecnologias));
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso do desenvolvimento");
    }
}

class Estagiario extends Funcionario implements Trabalhavel {
    private int horasDeTrabalho;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasDeTrabalho, String supervisor) {
        super(nome, matricula);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {
        // Exemplo de cálculo de salário para estagiário
        return horasDeTrabalho * 10;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário trabalhando com supervisor: " + supervisor);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso do estágio");
    }
}

interface Trabalhavel {
    void trabalhar();
    void relatarProgresso();
}