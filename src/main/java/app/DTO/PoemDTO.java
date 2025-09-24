package app.DTO;

import app.entities.Poem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoemDTO {
    private int id;
    private String author;
    private String content;

    public PoemDTO(Poem poem){
        this.id = poem.getId();
        this.author = poem.getAuthor();
        this.content = poem.getContent();
    }

}
