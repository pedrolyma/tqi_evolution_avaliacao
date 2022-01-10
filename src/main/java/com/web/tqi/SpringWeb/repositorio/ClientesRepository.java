package com.web.tqi.SpringWeb.repositorio;

import com.web.tqi.SpringWeb.models.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Cliente, Integer> {
  @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where id = :id", nativeQuery = true)
  public boolean exist(int id);

  @Query(value="select * from cliente where email = :email and senha = :senha", nativeQuery = true)
  public Cliente Login(String email, String senha);
}
