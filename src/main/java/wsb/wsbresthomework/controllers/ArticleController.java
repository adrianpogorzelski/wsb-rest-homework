package wsb.wsbresthomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsb.wsbresthomework.models.Article;
import wsb.wsbresthomework.services.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    final private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Article> find(@PathVariable Long id) {
        Article article = articleService.find(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(article);
    }

    @PostMapping
    ResponseEntity<Article> save(@RequestBody Article article) {
        Article newArticle = articleService.save(article);
        if (newArticle == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle);
    }

    @PutMapping("/{id}")
    ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
        Article articleToUpdate = articleService.update(id, article);
        if (articleToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(articleToUpdate);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> remove(@PathVariable Long id) {
        articleService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
