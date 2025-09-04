package controller;

import model.Tarefa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarefaControle {
    private final List<Tarefa> listaDeTarefas = new ArrayList<>();
    private int proximoIdentificador = 1;

    public Tarefa criarTarefa(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa(proximoIdentificador, titulo, descricao);
        listaDeTarefas.add(novaTarefa);
        proximoIdentificador = proximoIdentificador + 1;
        return novaTarefa;
    }

    public List<Tarefa> listarTarefas() {
        return Collections.unmodifiableList(listaDeTarefas);
    }

    public Tarefa buscarTarefaPorId(int identificador) {
        int indice = 0;
        while (indice < listaDeTarefas.size()) {
            Tarefa tarefaAtual = listaDeTarefas.get(indice);
            if (tarefaAtual.getIdentificador() == identificador) {
                return tarefaAtual;
            }
            indice = indice + 1;
        }
        return null;
    }

    public boolean concluirTarefa(int identificador) {
        Tarefa tarefa = buscarTarefaPorId(identificador);
        if (tarefa == null) {
            return false;
        }
        tarefa.concluir();
        return true;
    }

    public boolean reabrirTarefa(int identificador) {
        Tarefa tarefa = buscarTarefaPorId(identificador);
        if (tarefa == null) {
            return false;
        }
        tarefa.reabrir();
        return true;
    }

    public boolean atualizarTarefa(int identificador, String novoTitulo, String novaDescricao) {
        Tarefa tarefa = buscarTarefaPorId(identificador);
        if (tarefa == null) {
            return false;
        }
        if (novoTitulo != null) {
            String tituloTratado = novoTitulo.trim();
            if (!tituloTratado.isEmpty()) {
                tarefa.setTituloDaTarefa(tituloTratado);
            }
        }
        if (novaDescricao != null) {
            tarefa.setDescricaoDaTarefa(novaDescricao.trim());
        }
        return true;
    }

    public boolean excluirTarefa(int identificador) {
        int indice = 0;
        while (indice < listaDeTarefas.size()) {
            Tarefa tarefaAtual = listaDeTarefas.get(indice);
            if (tarefaAtual.getIdentificador() == identificador) {
                listaDeTarefas.remove(indice);
                return true;
            }
            indice = indice + 1;
        }
        return false;
    }
}
