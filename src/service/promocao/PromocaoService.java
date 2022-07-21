package service.promocao;

import model.Cargo;
import model.Funcionario;
import model.ValidacaoException;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		if (Cargo.GERENTE == funcionario.getCargo()) {
			throw new ValidacaoException("Gerentes n�o podem ser promovidos");
		}
		if(metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcionario n�o bateu a meta");
		}
		
	}

}
