package model;

public class Tarefa {
    private int identificador;
    private String tituloDaTarefa;
    private String descricaoDaTarefa;
    private boolean tarefaConcluida;

    public Tarefa(int identificador, String tituloDaTarefa, String descricaoDaTarefa) {
        this.identificador = identificador;
        this.tituloDaTarefa = tituloDaTarefa;
        this.descricaoDaTarefa = descricaoDaTarefa;
        this.tarefaConcluida = false;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getTituloDaTarefa() {
        return tituloDaTarefa;
    }

    public void setTituloDaTarefa(String novoTitulo) {
        this.tituloDaTarefa = novoTitulo;
    }

    public String getDescricaoDaTarefa() {
        return descricaoDaTarefa;
    }

    public void setDescricaoDaTarefa(String novaDescricao) {
        this.descricaoDaTarefa = novaDescricao;
    }

    public boolean isTarefaConcluida() {
        return tarefaConcluida;
    }

    public void concluir() {
        this.tarefaConcluida = true;
    }

    public void reabrir() {
        this.tarefaConcluida = false;
    }

    @Override
    public String toString() {
        String statusTexto;
        if (tarefaConcluida) {
            statusTexto = "CONCLUÍDA";
        } else {
            statusTexto = "ABERTA";
        }

        String descricaoExibida;
        if (descricaoDaTarefa == null || descricaoDaTarefa.isBlank()) {
            descricaoExibida = "(sem descrição)";
        } else {
            descricaoExibida = descricaoDaTarefa;
        }

        return "#" + identificador + " | [" + statusTexto + "] - " + tituloDaTarefa + "\n    " + descricaoExibida;
    }
}
