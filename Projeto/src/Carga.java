public class Carga {

	private int codigo;
	private static int codigoAUX;
	private int peso;
	private Status status;
	private int tempoMaximo;
	private double valorDeclarado;
	private Local destino;
	private Local origem;
	private TipoCarga tipoCarga;
	private Cliente cliente;

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

}
