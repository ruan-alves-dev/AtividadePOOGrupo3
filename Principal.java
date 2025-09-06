package view;

import controller.TarefaControle;
import model.Tarefa;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    private static final Scanner leitorEntrada = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        TarefaControle controleDeTarefas = new TarefaControle();
        int opcaoEscolhida = -1;

        while (opcaoEscolhida != 0) {
            exibirMenu();
            opcaoEscolhida = lerInteiro("Escolha uma opção: ");

            if (opcaoEscolhida == 1) {
                criarTarefaFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 2) {
                listarTarefasFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 3) {
                concluirTarefaFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 4) {
                reabrirTarefaFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 5) {
                atualizarTarefaFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 6) {
                excluirTarefaFluxo(controleDeTarefas);
            } else if (opcaoEscolhida == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== TO DO LIST =====");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("4 - Reabrir tarefa");
        System.out.println("5 - Atualizar tarefa");
        System.out.println("6 - Excluir tarefa");
        System.out.println("0 - Sair");
        System.out.println();
    }

    private static void criarTarefaFluxo(TarefaControle controle) {
        System.out.print("Título da tarefa: ");
        String titulo = leitorEntrada.nextLine();
        System.out.print("Descrição da tarefa (opcional): ");
        String descricao = leitorEntrada.nextLine();

        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título não pode ser vazio.");
            return;
        }

        Tarefa criada = controle.criarTarefa(titulo.trim(), descricao);
        System.out.println("Tarefa criada com sucesso:");
        System.out.println(criada);
    }

    private static void listarTarefasFluxo(TarefaControle controle) {
        List<Tarefa> tarefas = controle.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println();
        System.out.println("===== LISTA DE TAREFAS =====");
        int indice = 0;
        while (indice < tarefas.size()) {
            System.out.println(tarefas.get(indice));
            indice = indice + 1;
        }
    }

    private static void concluirTarefaFluxo(TarefaControle controle) {
        int id = lerInteiro("Informe o identificador da tarefa para concluir: ");
        boolean ok = controle.concluirTarefa(id);
        if (ok) {
            System.out.println("Tarefa concluída.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void reabrirTarefaFluxo(TarefaControle controle) {
        int id = lerInteiro("Informe o identificador da tarefa para reabrir: ");
        boolean ok = controle.reabrirTarefa(id);
        if (ok) {
            System.out.println("Tarefa reaberta.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void atualizarTarefaFluxo(TarefaControle controle) {
        int id = lerInteiro("Informe o identificador da tarefa para atualizar: ");
        System.out.print("Novo título (deixe em branco para manter): ");
        String novoTitulo = leitorEntrada.nextLine();
        System.out.print("Nova descrição (deixe em branco para manter): ");
        String novaDescricao = leitorEntrada.nextLine();

        boolean alterouAlgo = false;
        if (novoTitulo != null && !novoTitulo.trim().isEmpty()) {
            alterouAlgo = true;
        }
        if (novaDescricao != null && !novaDescricao.trim().isEmpty()) {
            alterouAlgo = true;
        }
        if (!alterouAlgo) {
            System.out.println("Nada para atualizar.");
            return;
        }

        boolean ok = controle.atualizarTarefa(id, novoTitulo, novaDescricao);
        if (ok) {
            System.out.println("Tarefa atualizada.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void excluirTarefaFluxo(TarefaControle controle) {
        int id = lerInteiro("Informe o identificador da tarefa para excluir: ");
        boolean ok = controle.excluirTarefa(id);
        if (ok) {
            System.out.println("Tarefa excluída.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String textoDigitado = leitorEntrada.nextLine();
            try {
                int valorConvertido = Integer.parseInt(textoDigitado.trim());
                return valorConvertido;
            } catch (NumberFormatException excecao) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}

