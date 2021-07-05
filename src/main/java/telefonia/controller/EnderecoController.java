package telefonia.controller;

import telefonia.model.bo.EnderecoBO;
import telefonia.model.dao.EnderecoDAO;
import telefonia.model.vo.EnderecoVO;

public class EnderecoController {
	
	EnderecoBO eBO = new EnderecoBO();
	EnderecoDAO eDAO = new EnderecoDAO();
	
	public EnderecoVO cadastrar(EnderecoVO novoEndereco) {
		
		return eBO.cadastrar(novoEndereco);
	}
	
	public EnderecoVO buscarPorId(int id) {
		EnderecoVO enderecoEncontrado = new EnderecoVO();
		return eDAO.buscarPorId(id);
	}
}
