package br.com.alura.linguagemapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControllerLinguagens {
    
    @Autowired
    private LinguagemRepositorio repositorio;

    @GetMapping("/linguagem")
    public List<Linguagens> obterLinguagens(){
       List<Linguagens> linguagem = repositorio.findAll();
       return linguagem;
    }

    @PostMapping("/linguagem")
    public Linguagens cadastrarLinguagem (@RequestBody Linguagens linguagem){
       return repositorio.save(linguagem);
    }

    @GetMapping("/linguagem/{id}")
    public Linguagens obterLinguagensPorID(@PathVariable String id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/linguagem/{id}")
    public Linguagens deletarLinguagensPorID(@PathVariable String id){
        repositorio.deleteById(id);
        return 
    }
        

    @PutMapping("/linguagem/{id}")
    public Linguagens alterarLinguagensPorID(@PathVariable String id, @RequestBody Linguagens linguagem){
        repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            
        return repositorio.save(linguagem);
    }

}
