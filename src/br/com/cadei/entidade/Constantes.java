package br.com.cadei.entidade;

import java.io.Serializable;

public class Constantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static class Turma
	{	
	
	
		private String nome;
	
		public Turma(String nome){
			this.nome = nome;
		}
	
		public String getNome(){
			return this.nome;
		}
	
	}
	public Turma[] getTurmas(){
		String[] vet ={"1 Ano","2 Ano","3 Ano"};
		Turma[] turmas = new Turma[vet.length];
		for(int i=0;i<vet.length;i++){
			turmas[i] = new Turma(vet[i]);
		}
		return turmas;
	}
}

