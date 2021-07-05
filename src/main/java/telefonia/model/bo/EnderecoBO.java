package telefonia.model.bo;

import telefonia.controller.EnderecoController;
import telefonia.model.dao.EnderecoDAO;
import telefonia.model.vo.EnderecoVO;

public class EnderecoBO {
	
	private EnderecoDAO dDAO = new EnderecoDAO();
	
	public EnderecoVO cadastrar(EnderecoVO novoEndereco) {
		String mensagem ="BO - N�o foi poss�vel cadastrar o endere�o";
		dDAO.cadastrar(novoEndereco);
		if(novoEndereco.getId() != null && novoEndereco.getId() > 0) {
			mensagem = "BO - Endereco cadastrado com sucesso!";
		}
		dDAO.cadastrar(novoEndereco);
		System.out.println(mensagem);
		
		return novoEndereco;
	}
}
