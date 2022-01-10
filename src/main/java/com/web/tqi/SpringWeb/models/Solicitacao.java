package com.web.tqi.SpringWeb.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "Solicitacao")
public class Solicitacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NumberFormat(pattern = "###.###,##")
	private BigDecimal valor;
	@DateTimeFormat(style = "yyyy-MM-dd")
	private LocalDate datasolicitacao;
	@Range(min = 1, max =  60)
	private int qtdeparcela; 
	@DateTimeFormat(style = "yyyy-MM-dd")
	private LocalDate dataprimeiraparcela; 
	private String obsdoprocesso;
	@JoinColumn(name = "id_cliente")
	private int id_cliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDatasolicitacao() {
		return datasolicitacao;
	}
	public void setDatasolicitacao(LocalDate datasolicitacao) {
		this.datasolicitacao = datasolicitacao;
	}
	public int getQtdeparcela() {
		return qtdeparcela;
	}
	public void setQtdeparcela(int qtdeparcela) {
		this.qtdeparcela = qtdeparcela;
	}
	public LocalDate getDataprimeiraparcela() {
		return dataprimeiraparcela;
	}
	public void setDataprimeiraparcela(LocalDate dataprimeiraparcela) {
		this.dataprimeiraparcela = dataprimeiraparcela;
	}
	public String getObsdoprocesso() {
		return obsdoprocesso;
	}
	public void setObsdoprocesso(String obsdoprocesso) {
		this.obsdoprocesso = obsdoprocesso;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
