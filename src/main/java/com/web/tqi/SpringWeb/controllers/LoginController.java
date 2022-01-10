package com.web.tqi.SpringWeb.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.web.tqi.SpringWeb.Servico.CookieService;
import com.web.tqi.SpringWeb.models.Cliente;
import com.web.tqi.SpringWeb.repositorio.ClientesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  @Autowired
  private ClientesRepository repo;

  @GetMapping("/login")
  public String index(){
    return "login/index";
  }

  @PostMapping("/logar")
  public String logar(Model model, Cliente admParam, String lembrar, HttpServletResponse response) throws IOException{
    Cliente adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
    model.addAttribute("dados", admParam);
    if(adm != null){
      int tempoLogado = (60*60); // 1 hora de cookie
      if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
      CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
      CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
      return "redirect:/";
    }
    model.addAttribute("erro", "Usuário ou senha inválidos");
    return "/clientes/novo";
  }

  @GetMapping("/sair")
  public String logar(HttpServletResponse response) throws IOException{
    CookieService.setCookie(response, "usuarioId", "", 0);
    return "redirect:/login";
  }
  
 
}
