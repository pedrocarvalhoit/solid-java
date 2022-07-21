package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.Funcionario;
import model.ValidacaoException;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste{
	
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste deve ser inferior a 40% do sal�rio");
		}
	}

}
