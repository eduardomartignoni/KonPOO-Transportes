import java.util.*;

public class Controle {

	private ArrayList<Carga> cargas;
	private Queue<Carga> cargasPendentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Caminhao> frota;
	private final ArrayList<Local> locais = new ArrayList<>();
	private ArrayList<TipoCarga> tipos;

	public void alteraStatus() {}

	public void carregarDados() {}

	public void consultaCargas() {}

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
	public boolean consultaNomeUnicoCaminhao(String nome){
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

	public boolean consultaCodigoUnicoCliente(int codigo){
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

	public boolean consultaAlgumDestinoJaCadastrado(){
		return (!locais.isEmpty());
	}
	public void ordenaLocaisPorCidade(){
		LocalComparatorCidade c = new LocalComparatorCidade();
		locais.sort(c);
	}
	public void ordenaLocaisPorCodigo(){
		LocalComparatorCodigo c = new LocalComparatorCodigo();
		locais.sort(c);
	}

	// DA PRA MELHORAR ESSES 2 STRINGS E COLOCAR TODAS INFOS DO LOCAL
	public String exibirLocaisPorCidade(){
		ordenaLocaisPorCidade();
		StringBuilder s = new StringBuilder("Destinos: \n");
		if (locais.size()==0) {
			s.append("Nenhum Destino cadastrado");
			return s.toString();
		}
		for (Local local : locais) {
			s.append(local.toString());
		}
		ordenaLocaisPorCodigo();
		return s.toString();
	}
	public String exibirLocaisPorCodigo(){
		ordenaLocaisPorCodigo();
		StringBuilder s = new StringBuilder("Destinos: \n");
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

	public void salvarDados() {}

	static class CaminhaoComparator implements Comparator<Caminhao>{
		@Override
		public int compare(Caminhao a, Caminhao b){
			return a.getNome().compareToIgnoreCase(b.getNome());
		}
	}
	static class LocalComparatorCidade implements Comparator<Local>{
		@Override
		public int compare(Local a, Local b){
			return a.getCidade().compareTo(b.getCidade());
		}
	}
	static class LocalComparatorCodigo implements Comparator<Local>{
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
}
