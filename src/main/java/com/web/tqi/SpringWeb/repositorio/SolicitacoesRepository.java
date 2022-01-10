package com.web.tqi.SpringWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.tqi.SpringWeb.models.Solicitacao;

public interface SolicitacoesRepository extends CrudRepository<Solicitacao, Long> {

	  @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from solicitacao where id_cliente = :id", nativeQuery = true)
	  public boolean exist(int id);
}
