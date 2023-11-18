package entidades;
public class Caminhao {

	private final String nome;
	private final double autonomia;
	private int codigo;
	private static int codigoAUX = 1;
	private final double velocidade;
	private double custoPorKm;

	public Caminhao(String nome, double autonomia, double velocidade, double custoPorKm){
		this.nome = nome;
		this.autonomia = autonomia;
		this.velocidade = velocidade;
		this.custoPorKm = custoPorKm;
		codigo = codigoAUX;
		codigoAUX++;
	}

	public Caminhao(String nome, double autonomia, int codigo, double velocidade, double custoPorKm){
		this.nome = nome;
		this.autonomia = autonomia;
		this.velocidade = velocidade;
		this.custoPorKm = custoPorKm;
		this.codigo = codigo;
		codigoAUX++;
	}

	public String getNome() {
		return nome;
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
				autonomia + " Km/\t" + velocidade + " Km/h\t" + custoPorKm + " R$/Km" 				;
	}

	public String csvString(){
		return nome + ";" + autonomia + ";" + codigo +  ";" + velocidade + ";" + custoPorKm;
	}
}
