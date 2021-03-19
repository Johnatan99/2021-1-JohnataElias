package telefonia.executavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import telefonia.model.vo.ClienteVO;
import telefonia.model.vo.EnderecoVO;
import telefonia.model.vo.TelefoneVO;

public class PrincipalTelefonia {
	
	public static void main(String args[]) {
		
		ArrayList<ClienteVO> clientes = criarClientes();

		for(ClienteVO c : clientes) {
			System.out.println("Cliente : "+c.toString());
		}
	}
		private static ArrayList<ClienteVO> criarClientes(){
			ArrayList<TelefoneVO> telefones1 = new ArrayList<TelefoneVO>();
			ClienteVO c1 = criarCiente("Johnatan Elias", "000.000.000-00");
			ClienteVO c2 = criarCiente("Gabi", "111.111.111-11");
			ClienteVO c3 = criarCiente("Pinh�o da Siva", "001.000.000-00");
			ClienteVO c4 = criarCiente("Sr.Cannabis", "002.000.000-00");
			ClienteVO c5 = criarCiente("Albert", "003.000.000-00");
		
			ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
			clientes.add(c1);
			clientes.add(c2);
			clientes.add(c3);
			clientes.add(c4);
			clientes.add(c5);
			
			return clientes;
		}
	
		private static TelefoneVO criarTelefoneAleatorio() {
			String codigoInternacional = String.valueOf(new Random().nextInt(99));
			String ddd = String.valueOf(new Random().nextInt(99));
			String numero = String.valueOf(new Random().nextInt(99999999));
			boolean ativo = new Random().nextInt(2) > 0;
			boolean movel = new Random().nextInt(2) > 0;
			TelefoneVO novoTelefone = new TelefoneVO(codigoInternacional, ddd, numero, ativo, movel);
			return novoTelefone;
		}
		
		private static ArrayList<TelefoneVO> criarTelefonesAleatorios(){
			ArrayList<TelefoneVO> telefones = new ArrayList<TelefoneVO>();
			
			int quantidadeTelefones = new Random().nextInt(5);
			for(int i = 0; i<quantidadeTelefones;i++) {
				telefones.add(criarTelefoneAleatorio());
			}
			return telefones;
		}
		
		
		private static EnderecoVO criarEnderecoAleatorio() {
			EnderecoVO novoEndereco = new EnderecoVO();
			double numeroBaseCep = new Random().nextInt(99999);
			double numero = new Random().nextInt(100);
			
			novoEndereco.setCep(numeroBaseCep+"-000");
			novoEndereco.setLogradouro("Rua "+numero);
			novoEndereco.setCidade("Cidade "+numero);
			novoEndereco.setUf("SC");
			return novoEndereco;
		}	
		
		private static ClienteVO criarCiente(String nome, String cpf) {
			boolean ativo = new Random().nextInt(2) > 0;
			ClienteVO novoCliente = new ClienteVO();
			novoCliente.setNome(nome);
			novoCliente.setCpf(cpf);
			novoCliente.setTelefones(criarTelefonesAleatorios());
			novoCliente.setEnderecoCliente(criarEnderecoAleatorio());
			novoCliente.isAtivo();
			return novoCliente;
		}
}