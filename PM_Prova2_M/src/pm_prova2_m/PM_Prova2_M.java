package pm_prova2_m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PM_Prova2_M {

    static List<Veiculo> veiculos = new ArrayList<>();
    static List<Aluguel> alugueis = new ArrayList<>();

    public static void main(String[] args) {
        popularDados();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= SISTEMA DE ALUGUEL =======");
            System.out.println("1. Associar veículo a um aluguel");
            System.out.println("2. Exibir todos os veículos");
            System.out.println("3. Exibir todos os alugueis");
            System.out.println("4. Exibir veículos disponíveis");
            System.out.println("5. Avaliar um objeto avaliável");
            System.out.println("6. Realizar inspeção em veículo");
            System.out.println("7. Remover veículos em manutenção");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> associarVeiculo(sc);
                case 2 -> exibirTodosVeiculos();
                case 3 -> exibirTodosAlugueis();
                case 4 -> exibirVeiculosDisponiveis();
                case 5 -> avaliarObjeto(sc);
                case 6 -> realizarInspecao(sc);
                case 7 -> removerVeiculosManutencao();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    // ── Pré-popula 3 veículos e 2 alugueis ──────────────────────────────────
    static void popularDados() {
        Carro carro = new Carro("ABC-1234", "Fiat Pulse", 2022, 150.0, 18000, StatusVeiculo.DISPONIVEL, 4);
        Moto moto = new Moto("DEF-5678", "Honda CB 500", 2021, 80.0, 32000, StatusVeiculo.DISPONIVEL, 500);
        Van van = new Van("GHI-9012", "Renault Master", 2020, 300.0, 55000, StatusVeiculo.MANUTENCAO, 15);

        veiculos.add(carro);
        veiculos.add(moto);
        veiculos.add(van);

        AluguelBasico basico = new AluguelBasico("João Silva", 3, 450.0, StatusAluguel.ATIVO);
        AluguelExecutivo executivo = new AluguelExecutivo("Maria Souza", 5, 1500.0, StatusAluguel.ATIVO,
                "Carlos Motorista");

        basico.adicionarVeiculo(carro);
        executivo.adicionarVeiculo(moto);

        alugueis.add(basico);
        alugueis.add(executivo);

        System.out.println("Dados iniciais carregados com sucesso!");
    }

    // ── Funcionalidade 1 ─────────────────────────────────────────────────────
    static void associarVeiculo(Scanner sc) {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("Escolha o aluguel:");
        for (int i = 0; i < alugueis.size(); i++)
            System.out.println(i + " - " + alugueis.get(i).getNomeCliente());
        int idxA = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolha o veículo:");
        for (int i = 0; i < veiculos.size(); i++)
            System.out.println(i + " - " + veiculos.get(i).getModelo() + " [" + veiculos.get(i).getPlaca() + "]");
        int idxV = sc.nextInt();
        sc.nextLine();

        Aluguel a = alugueis.get(idxA);
        Veiculo v = veiculos.get(idxV);

        if (a instanceof AluguelBasico)
            ((AluguelBasico) a).adicionarVeiculo(v);
        else if (a instanceof AluguelPremium)
            ((AluguelPremium) a).adicionarVeiculo(v);
        else if (a instanceof AluguelExecutivo)
            ((AluguelExecutivo) a).adicionarVeiculo(v);

        v.setStatus(StatusVeiculo.ALUGADO);
        System.out.println("Veículo associado com sucesso!");
    }

    // ── Funcionalidade 2 ─────────────────────────────────────────────────────
    static void exibirTodosVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
            System.out.println();
        }
    }

    // ── Funcionalidade 3 ─────────────────────────────────────────────────────
    static void exibirTodosAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
            System.out.println();
        }
    }

    // ── Funcionalidade 4 ─────────────────────────────────────────────────────
    static void exibirVeiculosDisponiveis() {
        boolean achou = false;
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                v.exibirDetalhes();
                System.out.println();
                achou = true;
            }
        }
        if (!achou)
            System.out.println("Nenhum veículo disponível no momento.");
    }

    // ── Funcionalidade 5 ─────────────────────────────────────────────────────
    static void avaliarObjeto(Scanner sc) {
        List<Avaliavel> avaliaveis = new ArrayList<>();

        for (Veiculo v : veiculos)
            if (v instanceof Avaliavel)
                avaliaveis.add((Avaliavel) v);
        for (Aluguel a : alugueis)
            if (a instanceof Avaliavel)
                avaliaveis.add((Avaliavel) a);

        if (avaliaveis.isEmpty()) {
            System.out.println("Nenhum objeto avaliável encontrado.");
            return;
        }

        System.out.println("Objetos avaliáveis:");
        for (int i = 0; i < avaliaveis.size(); i++)
            System.out.println(i + " - " + avaliaveis.get(i).getClass().getSimpleName());

        System.out.print("Escolha o índice: ");
        int idx = sc.nextInt();
        sc.nextLine();
        System.out.print("Nota (1-5): ");
        int nota = sc.nextInt();
        sc.nextLine();

        avaliaveis.get(idx).avaliar(nota);
    }

    // ── Funcionalidade 6 ─────────────────────────────────────────────────────
    static void realizarInspecao(Scanner sc) {
        List<Inspecionavel> inspecionaveis = new ArrayList<>();
        for (Veiculo v : veiculos)
            if (v instanceof Inspecionavel)
                inspecionaveis.add((Inspecionavel) v);

        if (inspecionaveis.isEmpty()) {
            System.out.println("Nenhum veículo inspecionável.");
            return;
        }

        System.out.println("Veículos inspecionáveis:");
        for (int i = 0; i < inspecionaveis.size(); i++)
            System.out.println(i + " - " + inspecionaveis.get(i).getClass().getSimpleName());

        System.out.print("Escolha o índice: ");
        int idx = sc.nextInt();
        sc.nextLine();
        inspecionaveis.get(idx).realizarInspecao();
    }

    // ── Funcionalidade 7 ─────────────────────────────────────────────────────
    static void removerVeiculosManutencao() {
        Iterator<Veiculo> it = veiculos.iterator();
        int removidos = 0;
        while (it.hasNext()) {
            Veiculo v = it.next();
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                System.out.println("Removido: " + v.getModelo() + " [" + v.getPlaca() + "]");
                it.remove();
                removidos++;
            }
        }
        if (removidos == 0)
            System.out.println("Nenhum veículo em manutenção encontrado.");
        else
            System.out.println(removidos + " veículo(s) removido(s).");
    }
}
