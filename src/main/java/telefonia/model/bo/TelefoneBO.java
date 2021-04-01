package telefonia.model.bo;

import telefonia.exception.NumeroIndisponivelException;
import telefonia.model.dao.TelefoneDAO;
import telefonia.model.vo.TelefoneVO;

public class TelefoneBO {

		private TelefoneDAO tDAO = new TelefoneDAO();
		
		public TelefoneVO cadastrar(TelefoneVO novoTelefone) throws NumeroIndisponivelException {
			
			if(tDAO.numeroEstaDisponivel(novoTelefone)) {
				tDAO.cadastrar(novoTelefone);
			}else throw new NumeroIndisponivelException("O número informado ("+novoTelefone.getNumero()+") já foi utilizado no DDD "+novoTelefone.getDdd());
			return novoTelefone;
		}
}
