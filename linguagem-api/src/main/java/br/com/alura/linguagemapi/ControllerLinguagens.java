package br.com.alura.linguagemapi;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControllerLinguagens {
    
    @Autowired
    private LinguagemRepositorio repositorio;

    @GetMapping("/linguagem")
    public List<Linguagens> obterLinguagens(){
       List<Linguagens> linguagem = repositorio.findByOrderByRanking();
       return linguagem;
    }

    @PostMapping("/linguagem")
    public ResponseEntity< Linguagens >cadastrarLinguagem (@RequestBody Linguagens linguagem){
        Linguagens linguagemSalva = repositorio.save(linguagem);
        return new ResponseEntity  <> (linguagemSalva, HttpStatus.CREATED);
    }

    @GetMapping("/linguagem/{id}")
    public Linguagens obterLinguagensPorID(@PathVariable String id){
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/linguagem/{id}")
    public void deletarLinguagensPorID(@PathVariable String id){
        repositorio.deleteById(id);
       
    }
        

    @PutMapping("/linguagem/{id}")
    public Linguagens alterarLinguagensPorID(@PathVariable String id, @RequestBody Linguagens linguagem){
        if (!repositorio.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }  
        linguagem.setId(id);
        Linguagens linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }
         

}
