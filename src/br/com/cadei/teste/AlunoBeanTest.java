package br.com.cadei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cadei.bean.AlunoBean;

public class AlunoBeanTest {

	@Test
	public void testLimpar() {
		AlunoBean ab = new AlunoBean();
		
		assertEquals(null, ab.limpar());
	}

	@Test
	public void testNovo() {
		AlunoBean ab = new AlunoBean();
		
		assertEquals("cadastrofolhaaluno?faces-redirect=true", ab.novo());
	}

}
