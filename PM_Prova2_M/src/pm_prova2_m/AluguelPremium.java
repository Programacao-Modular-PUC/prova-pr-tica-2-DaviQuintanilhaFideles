package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public class AluguelPremium extends Aluguel {

    private List<Veiculo> veiculos;

    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== ALUGUEL PREMIUM ===");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Dias: " + getQuantidadeDias());
        System.out.println("Valor Total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: Ilimitada");
        System.out.println("Seguro incluso: Sim");
        System.out.println("Veículos (" + veiculos.size() + "):");
        for (Veiculo v : veiculos) {
            System.out.println("  - " + v.getModelo() + " [" + v.getPlaca() + "]");
        }
    }
}
