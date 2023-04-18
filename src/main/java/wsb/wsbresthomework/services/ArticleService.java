package wsb.wsbresthomework.services;

import org.springframework.stereotype.Service;
import wsb.wsbresthomework.models.Article;
import wsb.wsbresthomework.repositories.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {

    final private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article find(Long id) {
        return articleRepository.find(id);
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Article update(Long id, Article article) {
        return articleRepository.update(id, article);
    }

    public void remove(Long id) {
        articleRepository.remove(id);
    }

}
