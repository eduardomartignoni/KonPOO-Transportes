public class Carga {

	private int codigo;
	private static int codigoAUX;

	private int peso;
	private int tempoMaximo;
	private double valorDeclarado;

	private Local destino;
	private Local origem;
	private Cliente cliente;
	private Status status;
	private TipoCarga tipoCarga;

	public void cancelar() {}

	public int distancia() {
		return 0;
	}

	public void finalizar() {}

	public double frete() {
		return 0;
	}

	public void locar() {}

	public double precoDistancia() {
		return 0;
	}

	enum Status {

		CANCELADA(-1, "Cancelada"), FINALIZADA(0, "Finalizada"),
		LOCADA(1, "Locada"), PENDENTE(2, "Pendente");

		private int id;
		private final String nome;

		Status(int id, String nome) {
			this.id = id;
			this.nome = nome;
		}

		public String getNome() {
			return this.nome;
		}
	}
}
