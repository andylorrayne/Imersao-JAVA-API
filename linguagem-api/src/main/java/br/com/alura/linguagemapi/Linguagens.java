package br.com.alura.linguagemapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linguagensPopulares")

public class Linguagens {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public Linguagens(){
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    
        
    
}
