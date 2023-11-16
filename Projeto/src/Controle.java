import java.util.*;

public class Controle {

	private ArrayList<Carga> cargas;
	private Queue<Carga> cargasPendentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Caminhao> frota;
	private final ArrayList<Local> locais = new ArrayList<>();
	private ArrayList<TipoCarga> tipos;

	public void carregarDados() {}



	public void fretar() {}

	public void inicializaDados() {}

	public void novoCaminhao(String nome, double autonomia, double velocidade, double custoPorKm){
		Caminhao caminhao = new Caminhao(nome, autonomia, velocidade, custoPorKm);
		frota.add(caminhao);
		ordenaFrota();
	}
	public void ordenaFrota(){
		CaminhaoComparator c = new CaminhaoComparator();
		frota.sort(c);
	}
	public boolean verificaNomeUnicoCaminhao(String nome){
		if (frota.size()==0) return true;
		for (Caminhao caminhao : frota) return !nome.equalsIgnoreCase(caminhao.getNome());
		return true;
	}
	public void novoCliente(int codigo, String nome, String telefone) {
		Cliente cliente = new Cliente(codigo, nome, telefone);
		clientes.add(cliente);
		ordenaClientes();
	}

	public void ordenaClientes(){
		ClienteComparator c = new ClienteComparator();
		clientes.sort(c);
	}

	public boolean verificaCodigoUnicoCliente(int codigo){
		if (clientes.size()==0) return true;
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo()==codigo) return false;
		}
		return true;
	}

	public void novoLocal(String cidade, String nome, double distancia) {
		Local destino = new Local(cidade, nome, distancia);
		locais.add(destino);
	}

	public boolean verificaAlgumDestinoJaCadastrado(){
		return (!locais.isEmpty());
	}

	public void ordenaLocaisPorCodigo(){
		LocalComparator c = new LocalComparator();
		locais.sort(c);
	}

	public String exibirLocaisPorCodigo(){
		ordenaLocaisPorCodigo();
		StringBuilder s = new StringBuilder("Destinos: \n\n");
		if (locais.size()==0) {
			s.append("Nenhum Destino cadastrado");
			return s.toString();
		}
		for (Local local : locais) {
			s.append(local.toString());
		}
		return s.toString();
	}

	public void novoTipo() {}

	public String novaCarga(int codigo, int peso, int tempoMaximo, double valorDeclarado, Local destino, Local origem, Cliente cliente, TipoCarga tipoCarga){
		Carga carga = new Carga(codigo, peso, tempoMaximo, valorDeclarado, destino, origem, cliente, tipoCarga);
		cargasPendentes.add(carga);
		cargas.add(carga);
		ordenaCargas();

		return carga.toString();
	}
	public void ordenaCargas(){
		CargasComparator c = new CargasComparator();
		cargas.sort(c);
	}
	public String consultaTodasCargas() {
		StringBuilder s = new StringBuilder("Cargas: \n\n");
		if (cargas.size()==0) {
			s.append("Nenhuma carga cadastrada");
			return s.toString();
		}
		for (Carga carga : cargas) {
			s.append(carga.toString()).append("\n\n");
		}
		return s.toString();
	}
	public String consultaCarga(int codigo){
		for(Carga carga : cargas){
			if (carga.getCodigo()==codigo) return carga.toString();
		}
		return "ERR0: Carga não encontrada";
	}
	public String alteraStatus(int codigo, int status) {
		StringBuilder s = new StringBuilder();
		for (Carga carga : cargas){
			if (carga.getCodigo()==codigo) {
				if (carga.getStatus()== Carga.Status.FINALIZADA) return "Carga FINALIZADA, não é possivel alterar seu status";
				if (status==-1) {
					carga.cancelar();
					s.append("Carga cancelada");
					break;
				}
				if (status==0) {
					carga.finalizar();
					s.append("Carga Finalizada");
					break;
				}
				if (status==1) {
					carga.locar();
					s.append("Carga Locada");
					break;
				}
			}
		}
		return s.toString();
	}
	public void salvarDados() {}

	static class CaminhaoComparator implements Comparator<Caminhao>{
		@Override
		public int compare(Caminhao a, Caminhao b){
			return a.getNome().compareToIgnoreCase(b.getNome());
		}
	}

	static class LocalComparator implements Comparator<Local>{
		@Override
		public int compare(Local a, Local b){
			return a.getCodigo() - b.getCodigo();
		}
	}

	static class ClienteComparator implements Comparator<Cliente>{
		@Override
		public int compare(Cliente a, Cliente b){
			return a.getCodigo() - b.getCodigo();
		}
	}

	static class CargasComparator implements  Comparator<Carga>{
		@Override
		public int compare(Carga a, Carga b){
			return a.getCodigo() - b.getCodigo();
		}
	}
}
