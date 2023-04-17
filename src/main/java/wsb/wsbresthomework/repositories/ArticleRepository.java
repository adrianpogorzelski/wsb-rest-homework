package wsb.wsbresthomework.repositories;

import org.springframework.stereotype.Repository;
import wsb.wsbresthomework.models.Article;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ArticleRepository {

    static List<Article> articles = new LinkedList<>() {{
       add(new Article(1L, "Andrzej Brokuł", "Dlaczego Twój kot drze mordę w nocy", "Z badań amerykańskich naukowców wynika, że kot się drze, bo tak i co mu zrobisz?"));
       add(new Article(2L, "Celina Dynia", "Jak karmić kota?", "Po latach konsultacji doszliśmy do ostatecznego wniosku. Kota należy karmić jak najczęściej."));
       add(new Article(3L, "Eugeniusz Figa", "Ile może spać kot", "Jeżeli zastanawiasz się, ile może spać Twój kot, nie szukaj odpowiedzi dalej. Kot śpi ile mu się podoba."));
    }};

    static Long currentId = Long.valueOf(articles.size());

    public List<Article> findAll() {
        return articles;
    }

    public Article find(Long id) {
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Article save(Article article) {
        article.setId(currentId + 1);
        articles.add(article);
        return article;
    }

    public Article update(Long id, Article article) {
        Article articleToUpdate = find(id);

        if (articleToUpdate == null) {
            return null;
        }

        articleToUpdate.setAuthor(article.getAuthor());
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setContent(article.getContent());

        return articleToUpdate;
    }

    public void remove(Long id) {
        Article article = find(id);
        articles.remove(article);
    }

}

