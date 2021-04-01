package telefonia.model.bo;

import telefonia.exception.EnderecoNaoInformadoException;
import telefonia.model.dao.EnderecoDAO;
import telefonia.model.dao.ClienteDAO;
import telefonia.model.dao.TelefoneDAO;

import telefonia.model.vo.ClienteVO;
import telefonia.model.vo.EnderecoVO;
import telefonia.model.vo.TelefoneVO;
public class ClienteBO {
	
	private ClienteDAO dao = new ClienteDAO();
	public ClienteVO salvar(ClienteVO cliente) throws EnderecoNaoInformadoException {
		
		if(cliente.getEndereco() == null) {
			throw new EnderecoNaoInformadoException("Endereço é obrigatório, favor informar o endereço.");
		}
		if(cliente.getEndereco().getId() == null) {
			EnderecoDAO eDAO = new EnderecoDAO();
			EnderecoVO enderecoDoBanco = eDAO.cadastrar(cliente.getEndereco());
		}
		dao.cadastrar(cliente);
		return cliente;
		
	}
}
