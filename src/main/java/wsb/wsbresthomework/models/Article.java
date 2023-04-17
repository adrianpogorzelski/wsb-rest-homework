package wsb.wsbresthomework.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.MessageFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;

    public String toString() {
        return MessageFormat.format("{0}\n{1}\n{2}", title, content, author);
    }
}
