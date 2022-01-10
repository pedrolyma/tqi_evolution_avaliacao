package com.web.tqi.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.tqi.SpringWeb.models.Solicitacao;
import com.web.tqi.SpringWeb.repositorio.SolicitacoesRepository;

@Controller
public class SolicitacoesController {
	
	  @Autowired
	  private SolicitacoesRepository repo;

	  @GetMapping("/solicitacoes")
	  public String index(Model model){
	    List<Solicitacao> listaSolicitacoes = (List<Solicitacao>)repo.findAll();
	    model.addAttribute("solicitacoes", listaSolicitacoes);
	    return "solicitacoes/index";
	  }

	  @GetMapping("/solicitacoes/nova")
	  public String nova(){
	    return "solicitacoes/nova";
	  }

	  @PostMapping("/solicitacoes/criar")
	  public String criar(Solicitacao solicitacao){
	    repo.save(solicitacao);
	    return "redirect:/solicitacoes";
	  }

	  @GetMapping("/solicitacoes/{id}")
	  public String busca(@PathVariable Long id, Model model){
	    Optional<Solicitacao> admin = repo.findById(id);
	    try{
	      model.addAttribute("solicitacao", admin.get());
	    }
	    catch(Exception err){ return "redirect:/solicitacoes"; }

	    return "/solicitacoes/editar";
	  }

	  @PostMapping("/solicitacoes/{id}/atualizar")
	  public String atualizar(@PathVariable Long id, Solicitacao solicitacao){
	    if(!repo.existsById(id)){
	      return "redirect:/solicitacoes";
	    }

	    repo.save(solicitacao);

	    return "redirect:/solicitacoes";
	  }

	  @GetMapping("/solicitacoes/{id}/excluir")
	  public String excluir(@PathVariable Long id){
	    repo.deleteById(id);
	    return "redirect:/solicitacoes";
	  }
}
