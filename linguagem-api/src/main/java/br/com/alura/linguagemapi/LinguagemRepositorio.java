package br.com.alura.linguagemapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepositorio extends MongoRepository <Linguagens, String> {
    List <Linguagens> findByOrderByRanking();
}
