/*ATENCAO: ESSA CLASSE TEM METODOS A SEREM DESENVOLVIDOS:
 * ordenaTipos()
 * localPorCodigo(int codigo)
 * clientePorCodigo(int codigo)
 * caminhaoPorCodigo(int codigo)
 * carregarDados()
 * fretar()
 * tipoPorNumero(int numero)
 * novoTipo()
 */

package aplicacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

import cargas.*;
import entidades.*;

public class Controle {

	private ArrayList<Carga> cargas;
	private Queue<Carga> cargasPendentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Caminhao> frota;
	private final ArrayList<Local> locais;
	private ArrayList<TipoCarga> tipos;

	public void carregarDados(){}

	public Controle() {
		cargas = new ArrayList<>();
		cargasPendentes = new LinkedList<>();
		clientes = new ArrayList<>();
		frota = new ArrayList<>();
		tipos = new ArrayList<>();
		locais = new ArrayList<>();
	}

	public void fretar() {}

	public String inicializaDados() {
		StringBuilder s = new StringBuilder();
		s.append(inicializaLocais() + "\n");
		s.append(inicializaClientes() + "\n");
		s.append(inicializaCaminhoes() + "\n");
		s.append(inicializaTipos() + "\n");
		s.append(inicializaCargas() + "\n");
		s.append(inicializaFila() + "\n");
		return s.toString();
	}

	private String inicializaLocais(){
		Path locaisARQ = Paths.get("src" + File.separator + "entidades" + File.separator + "locais.csv");

		try (BufferedReader reader = Files.newBufferedReader(locaisARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			 while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					String cidade, nome;
					int codigo, latitude, longitude;

					cidade = sc.next();
					codigo = Integer.parseInt(sc.next());
					nome = sc.next();
					latitude = Integer.parseInt(sc.next());
					longitude = Integer.parseInt(sc.next());

					sc.close();
					locais.add(new Local(cidade, codigo, nome, latitude, longitude));
			 }
			 ordenaLocaisPorCodigo();
			 return "Locais carregados com sucesso";
		} catch (IOException e) {
			return "Erro ao carregar dados dos locais";
		}

	}

	private String inicializaClientes(){
		Path clientesARQ = Paths.get("src" + File.separator + "entidades" + File.separator + "clientes.csv");

		try (BufferedReader reader = Files.newBufferedReader(clientesARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					String telefone, nome;
					int codigo;

					codigo = Integer.parseInt(sc.next());
					nome = sc.next();
					telefone = sc.next();					

					clientes.add(new Cliente(nome, telefone, codigo));
					sc.close();
			}

			ordenaClientes();
			return "Clientes carregados com sucesso";
		
		} catch (IOException e) {
			return "Erro ao carregar dados dos clientes";
		}
	
	}

	private String inicializaCaminhoes(){
		Path caminhoesARQ = Paths.get("src" + File.separator + "entidades" + File.separator + "caminhoes.csv");

		try (BufferedReader reader = Files.newBufferedReader(caminhoesARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					String nome;
					double autonomia, velocidade, capacidade;
					int codigo;

					nome = sc.next();
					autonomia = Double.parseDouble(sc.next());
					codigo = Integer.parseInt(sc.next());
					velocidade = Double.parseDouble(sc.next());
					sc.next();
					capacidade = Double.parseDouble(sc.next());

					frota.add(new Caminhao(nome, autonomia, codigo, velocidade, , capacidade));
					sc.close();
			}

			ordenaFrota();
			return "Frota carregada com sucesso";
		
		} catch (IOException e) {
			return "Erro ao carregar dados da frota";
		}
	
	}

	private String inicializaTipos(){
		Path tiposARQ = Paths.get("src" + File.separator + "cargas" + File.separator + "tipos_carga.csv");

		try (BufferedReader reader = Files.newBufferedReader(tiposARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					// fatorPeso;descricao;numero;origem/materialPrincipal;validade/setor
					String descricao, prop1, prop2;
					int numero, fatorPeso;

					fatorPeso = Integer.parseInt(sc.next());
					descricao = sc.next();
					numero = Integer.parseInt(sc.next());
					prop1 = sc.next();
					prop2 = sc.next();

					if(fatorPeso==1) tipos.add(new Duravel(descricao, numero, prop1, prop2));
					else tipos.add(new Perecivel(descricao, numero, prop1, prop2));

					sc.close();
			}

			ordenaTipos();
			return "Tipos de carga carregados com sucesso";
		
		} catch (IOException e) {
			return "Erro ao carregar dados dos tipos de carga";
		}
	
	}

	private String inicializaCargas(){
		Path cargasARQ = Paths.get("src" + File.separator + "cargas" + File.separator + "cargas.csv");

		try (BufferedReader reader = Files.newBufferedReader(cargasARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					double valorDeclarado;
					String aux; //possivel usar para mais verificacoes
					int codigo, peso, tempoMaximo;
					Local destino, origem;
					Cliente cliente;
					Carga.Status status;
					TipoCarga tipocarga;
					Caminhao caminhaoDesignado;

					codigo = Integer.parseInt(sc.next());
					peso = Integer.parseInt(sc.next());
					tempoMaximo = Integer.parseInt(sc.next());
					valorDeclarado = Double.parseDouble(sc.next());
					destino = localPorCodigo(Integer.parseInt(sc.next()));
					origem = localPorCodigo(Integer.parseInt(sc.next()));
					cliente = clientePorCodigo(Integer.parseInt(sc.next()));
					status = Carga.Status.values()[Integer.parseInt(sc.next()) + 1];
					tipocarga = tipoPorNumero(Integer.parseInt(sc.next()));
					aux = sc.next();
					if (aux.equals("null")) caminhaoDesignado = null;
					else caminhaoDesignado = caminhaoPorCodigo(Integer.parseInt(aux));

					Carga carga = new Carga(codigo, peso, tempoMaximo, valorDeclarado, destino, origem, cliente, tipocarga);
					carga.setStatus(status);
					carga.setCaminhaoDesignado(caminhaoDesignado);
					cargas.add(carga);

					sc.close();
			}

			ordenaTipos();
			return "Cargas carregadas com sucesso";
		
		} catch (IOException e) {
			return "Erro ao carregar dados das cargas";
		}
	
	}

	private String inicializaFila(){
		Path cargasARQ = Paths.get("src" + File.separator + "aplicacao" + File.separator + "cargasFila.csv");

		try (BufferedReader reader = Files.newBufferedReader(cargasARQ, Charset.defaultCharset())) {
			reader.readLine(); //pula a primeira (cabecalho)
			String linha = null;
 			while((linha = reader.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";");

					double valorDeclarado;
					String aux; //possivel usar para mais verificacoes
					int codigo, peso, tempoMaximo;
					Local destino, origem;
					Cliente cliente;
					TipoCarga tipocarga;
					Caminhao caminhaoDesignado;

					codigo = Integer.parseInt(sc.next());
					peso = Integer.parseInt(sc.next());
					tempoMaximo = Integer.parseInt(sc.next());
					valorDeclarado = Double.parseDouble(sc.next());
					destino = localPorCodigo(Integer.parseInt(sc.next()));
					origem = localPorCodigo(Integer.parseInt(sc.next()));
					cliente = clientePorCodigo(Integer.parseInt(sc.next()));
					sc.next();
					tipocarga = tipoPorNumero(Integer.parseInt(sc.next()));
					aux = sc.next();
					if (aux.equals("null")) caminhaoDesignado = null;
					else caminhaoDesignado = caminhaoPorCodigo(Integer.parseInt(aux));

					Carga carga = new Carga(codigo, peso, tempoMaximo, valorDeclarado, destino, origem, cliente, tipocarga);
					carga.setStatus(Carga.Status.PENDENTE);
					carga.setCaminhaoDesignado(caminhaoDesignado);
					cargasPendentes.add(carga);

					sc.close();
			}

			ordenaTipos();
			return "Fila de cargas carregada com sucesso";
		
		} catch (IOException e) {
			return "Erro ao carregar dados da fila de cargas";
		}
	
	}

	public void novoCaminhao(String nome, double autonomia, double velocidade, double custoPorKm){
		Caminhao caminhao = new Caminhao(nome, autonomia, velocidade, custoPorKm);
		frota.add(caminhao);
		ordenaFrota();
	}

	public void ordenaFrota(){
		CaminhaoComparator c = new CaminhaoComparator();
		frota.sort(c);
	}

	public void ordenaTipos(){
		//TODO DEVELOP
	}

	public Local localPorCodigo(int codigo) {
		//TODO DESENVOLVER
		return null;
	}

	public Cliente clientePorCodigo(int codigo) {
		//TODO DESENVOLVER
		return null;
	}

	public Caminhao caminhaoPorCodigo(int codigo) {
		//TODO DESENVOLVER
		return null;
	}

	public TipoCarga tipoPorNumero(int numero) {
		//TODO DESENVOLVER
		return null;
	}

	public boolean verificaNomeUnicoCaminhao(String nome){
		if (frota.size()==0) return true;
		for (Caminhao caminhao : frota) return !nome.equalsIgnoreCase(caminhao.getNome());
		return true;
	}

	public void novoCliente(int codigo, String nome, String telefone) {
		Cliente cliente = new Cliente (nome, telefone, codigo);
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

	public void novoLocal(String cidade, String nome, int latitude, int longitude) {
		Local destino = new Local(cidade, nome, latitude, longitude);
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
	
	//acho que esse metodo ficou inutil
	public String adicionarDados(String arquivo, String dados){
		switch(arquivo){
			case "caminhoes":
				arquivo = "src" + File.separator + "entidades" + File.separator + "caminhoes.csv";
				break;
			case "clientes":
				arquivo = "src" + File.separator + "entidades" + File.separator + "clientes.csv";
				break;
			case "locais":
				arquivo = "src" + File.separator + "entidades" + File.separator + "locais.csv";
				break;
			case "tipos":
				arquivo = "src" + File.separator + "cargas" + File.separator + "tipos_carga.csv";
				break;
			case "cargas":
				arquivo = "src" + File.separator + "cargas" + File.separator + "cargas.csv";
				break;
			case "fila":
				arquivo = "src" + File.separator + "aplicacao" + File.separator + "cargasFila.csv";
				break;
			default:
				return "Erro ao salvar dados";
		}
		Path caminho = Paths.get(arquivo);

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.APPEND);
            PrintWriter writer = new PrintWriter(bw);){
			writer.println(dados);
			return "Dados salvos com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar  dados";
		}
	}

	public String salvaDados() {
		StringBuilder s = new StringBuilder();
		s.append(salvaLocais() + "\n");
		s.append(salvaClientes() + "\n");
		s.append(salvaCaminhoes() + "\n");
		s.append(salvaTipos() + "\n");
		s.append(salvaCargas() + "\n");
		s.append(salvaFila() + "\n");
		return s.toString();
	}	

	private String salvaFila(){
		Path caminho = Paths.get("src" + File.separator + "aplicacao" + File.separator + "cargasFila.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("codigo;peso;tempoMaximo;valorDeclarado;destino(cod);origem(cod);cliente(cod);status(id);tipoCarga(nro);caminhaoDesignado(cod)\n");
			for (Carga carga : cargasPendentes) {
				writer.println(carga.csvString());
			}
			return "Fila salva com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar fila: dados serão perdidos";
		}
	}

	private String salvaCargas(){
		Path caminho = Paths.get("src" + File.separator + "cargas" + File.separator + "cargas.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("codigo;peso;tempoMaximo;valorDeclarado;destino(cod);origem(cod);cliente(cod);status(id);tipoCarga(nro);caminhaoDesignado(cod)\n");
			for (Carga carga : cargas) {
				writer.println(carga.csvString());
			}
			return "Cargas salvas com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar cargas: dados serão perdidos";
		}
	}

	private String salvaTipos(){
		Path caminho = Paths.get("src" + File.separator + "cargas" + File.separator + "tipos_carga.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("fatorPeso;descricao;numero;origem/materialPrincipal;validade/setor\n");
			for (TipoCarga tipo : tipos) {
				writer.println(tipo.csvString());
			}
			return "Tipos de carga salvas com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar tipos de carga: dados serão perdidos";
		}
	}

	private String salvaCaminhoes(){
		Path caminho = Paths.get("src" + File.separator + "entidades" + File.separator + "caminhoes.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("nome;autonomia;codigo;velocidade;custoPorKm;capacidade\n");
			for (Caminhao caminhao : frota) {
				writer.println(caminhao.csvString());
			}
			return "Frota salva com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar frota: dados serão perdidos";
		}
	}

	private String salvaClientes(){
		Path caminho = Paths.get("src" + File.separator + "entidades" + File.separator + "clientes.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("codigo;nome;telefone\n");
			for (Cliente cliente : clientes) {
				writer.println(cliente.csvString());
			}
			return "Clientes salvos com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar clientes: dados serão perdidos";
		}
	}

	private String salvaLocais(){
		Path caminho = Paths.get("src" + File.separator + "entidades" + File.separator + "locais.csv");

		try (BufferedWriter bw = Files.newBufferedWriter(caminho, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
			PrintWriter writer = new PrintWriter(bw);){
					
			writer.print("cidade;codigo;nome;latitude;longitude\n");
			for (Local local : locais) {
				writer.println(local.csvString());
			}
			return "Locais salvos com sucesso";
		} catch (Exception e) {
			return "Erro ao salvar locais: dados serão perdidos";
		}
	}

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

	public void teste(){
		for(Cliente c : clientes) System.out.println(c.toString());
	}
}
