package entidades;
public class Caminhao {

	private final String nome;
	private final double autonomia;
	private int codigo;
	private static int codigoAUX = 1;
	private final double velocidade;
	private double custoPorKm;
	private final double capacidade;
	private static double valorGasol = 5.32;

	public Caminhao(String nome, double autonomia, double velocidade, double capacidade){
		this.nome = nome;
		this.autonomia = autonomia;
		this.velocidade = velocidade;
		this.custoPorKm = valorGasol/autonomia;
		codigo = codigoAUX;
		this.capacidade = capacidade;
		codigoAUX++;
	}

	public Caminhao(String nome, double autonomia, int codigo, double velocidade, double capacidade){
		this.nome = nome;
		this.autonomia = autonomia;
		this.velocidade = velocidade;
		this.custoPorKm = valorGasol/autonomia;
		this.codigo = codigo;
		this.capacidade = capacidade;
		codigoAUX++;
	}

	public String getNome() {
		return nome;
	}

	public static void setValorGasol(double valorGasol) {
		if(valorGasol>0) Caminhao.valorGasol = valorGasol;
	}

	public double getCustoPorKm(){
		return custoPorKm;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "[" + codigo + "] " + nome + "\n" +
				autonomia + " Km/\t" + velocidade + " Km/h\t" + custoPorKm + " R$/Km\t" + capacidade;
	}

	public String csvString(){
		return nome + ";" + autonomia + ";" + codigo +  ";" + velocidade + ";" + custoPorKm + ";" + capacidade;
	}
}
