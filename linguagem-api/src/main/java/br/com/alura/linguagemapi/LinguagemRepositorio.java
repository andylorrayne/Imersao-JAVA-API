package br.com.alura.linguagemapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepositorio extends MongoRepository <Linguagens, String> {

}
