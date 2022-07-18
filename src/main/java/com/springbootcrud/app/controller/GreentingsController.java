package com.springbootcrud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.springbootcrud.app.model.Usuario;
import com.springbootcrud.app.repository.UsuarioRepository;

@RestController
public class GreentingsController {

    @Autowired // injeção de dependencia.
    private UsuarioRepository usuarioRepository;

    @GetMapping(value="/maycon")
    public String getMethodName() {
        return "Olá Mundo VSCode!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String nome) {

		Usuario usuario = new Usuario();
		usuario.setNome(nome);

		usuarioRepository.save(usuario);/* grava no banco de dados */

		return "Ola mundo " + nome;
	}

    @GetMapping(value = "listatodos")
    @ResponseBody // Retorna um JSON
    public ResponseEntity<List<Usuario>> listaUsuario() {
        
        List<Usuario> usuarios = usuarioRepository.findAll(); // consulta no banco de dados

        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); // Rertorna a lista em JSON

    }
    
}
