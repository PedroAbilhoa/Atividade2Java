public class Filme {
    private String titulo;
    private int anoLancamento;
    private String diretor;

    public Filme(String titulo, int anoLancamento, String diretor) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}