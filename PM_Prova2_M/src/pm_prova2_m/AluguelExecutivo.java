package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private String nomeMotorista;
    private int avaliacao;
    private List<Veiculo> veiculos;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal,
            StatusAluguel status, String nomeMotorista) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.nomeMotorista = nomeMotorista;
        this.avaliacao = 0;
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 1 && nota <= 5) {
            this.avaliacao = nota;
            System.out.println("Aluguel executivo do cliente " + getNomeCliente() + " avaliado com nota " + nota);
        } else {
            System.out.println("Nota inválida. Informe um valor entre 1 e 5.");
        }
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALUGUEL EXECUTIVO ===");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Dias: " + getQuantidadeDias());
        System.out.println("Valor Total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: Ilimitada");
        System.out.println("Seguro incluso: Sim");
        System.out.println("Motorista: " + nomeMotorista);
        System.out.println("Avaliação: " + (avaliacao == 0 ? "Sem avaliação" : avaliacao + "/5"));
        System.out.println("Veículos (" + veiculos.size() + "):");
        for (Veiculo v : veiculos) {
            System.out.println("  - " + v.getModelo() + " [" + v.getPlaca() + "]");
        }
    }
}
