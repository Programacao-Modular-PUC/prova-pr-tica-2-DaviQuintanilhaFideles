package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int avaliacao;
    private boolean inspecionada;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
        this.avaliacao = 0;
        this.inspecionada = false;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 1 && nota <= 5) {
            this.avaliacao = nota;
            System.out.println("Van " + getModelo() + " avaliada com nota " + nota);
        } else {
            System.out.println("Nota inválida. Informe um valor entre 1 e 5.");
        }
    }

    @Override
    public void realizarInspecao() {
        this.inspecionada = true;
        System.out.println("Inspeção realizada na van " + getModelo() + " (" + getPlaca() + ").");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== VAN ===");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAnoFabricacao());
        System.out.println("Valor Diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km");
        System.out.println("Status: " + getStatus());
        System.out.println("Máx. Passageiros: " + maxPassageiros);
        System.out.println("Avaliação: " + (avaliacao == 0 ? "Sem avaliação" : avaliacao + "/5"));
        System.out.println("Inspecionada: " + (inspecionada ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }
}