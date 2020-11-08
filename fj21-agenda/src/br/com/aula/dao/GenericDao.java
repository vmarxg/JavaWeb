package br.com.aula.dao;

public interface GenericDao {
	
	public void adiciona(Object obj);
//	public Object pesquisa(long id);
	public void altera(Object obj);
	public void remove(Object obj);
}