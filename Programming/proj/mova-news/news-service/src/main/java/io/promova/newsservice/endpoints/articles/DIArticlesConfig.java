package io.promova.newsservice.endpoints.articles;

import io.promova.newsservice.endpoints.articles.tools.ArticleEntityCreator;
import io.promova.newsservice.endpoints.articles.tools.ArticleModelAssembler;
import io.promova.newsservice.endpoints.articles.tools.IArticleEntityCreator;
import io.promova.newsservice.endpoints.articles.tools.IArticleModelAssembler;
import io.promova.newsservice.endpoints.articles.validators.IPostOneArticleRequestArticleValidator;
import io.promova.newsservice.endpoints.articles.validators.IPostOneArticleRequestValidator;
import io.promova.newsservice.endpoints.articles.validators.PostOneArticleRequestArticleValidator;
import io.promova.newsservice.endpoints.articles.validators.PostOneArticleRequestValidator;
import io.promova.newsservice.endpoints.util.validators.INotNullValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIArticlesConfig
{
    @Bean
    public IArticleModelAssembler articleModelAssembler()
    {
        return new ArticleModelAssembler();
    }

    @Bean
    public IPostOneArticleRequestArticleValidator postOneArticleRequestArticleValidator(INotNullValidator notNullValidator)
    {
        return new PostOneArticleRequestArticleValidator(notNullValidator);
    }

    @Bean
    public IPostOneArticleRequestValidator postOneArticleRequestValidator(INotNullValidator notNullValidator,
                                                                          IPostOneArticleRequestArticleValidator postOneArticleRequestArticleValidator)
    {
        return new PostOneArticleRequestValidator(notNullValidator, postOneArticleRequestArticleValidator);
    }

    @Bean
    public IArticleEntityCreator articleEntityCreator()
    {
        return new ArticleEntityCreator();
    }
}
