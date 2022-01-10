package com.web.tqi.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.web.tqi.SpringWeb.models.Cliente;
import com.web.tqi.SpringWeb.repositorio.ClientesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientesController {

  @Autowired
  private ClientesRepository repo;

  @GetMapping("/clientes")
  public String index(Model model){
    List<Cliente> listaClientes = (List<Cliente>)repo.findAll();
    model.addAttribute("clientes", listaClientes);
    return "clientes/index";
  }

  @GetMapping("/clientes/novo")
  public String novo(){
    return "clientes/novo";
  }

  @PostMapping("/clientes/criar")
  public String criar(@Valid Cliente cliente){
    repo.save(cliente);
    return "redirect:/clientes";
  }

  @GetMapping("/clientes/{id}")
  public String busca(@PathVariable int id, Model model){
    Optional<Cliente> admin = repo.findById(id);
    try{
      model.addAttribute("cliente", admin.get());
    }
    catch(Exception err){ return "redirect:/clientes"; }

    return "/clientes/editar";
  }

  @PostMapping("/clientes/{id}/atualizar")
  public String atualizar(@PathVariable int id, Cliente cliente){
    if(!repo.existsById(id)){
      return "redirect:/clientes";
    }

    repo.save(cliente);

    return "redirect:/clientes";
  }


  @GetMapping("/clientes/{id}/excluir")
  public String excluir(@PathVariable int id){
    repo.deleteById(id);
    return "redirect:/clientes";
  }
}
