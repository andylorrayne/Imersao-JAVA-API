package br.com.alura.linguagemapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLinguagens {
    
    @Autowired
    private LinguagemRepositorio repositorio;

    @GetMapping("/linguagem")
    public List<Linguagens> obterLinguagens(){
       List<Linguagens> linguagem = repositorio.findAll();
       return linguagem;
    }


}
