package io.promova.newsservice.reps;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITitleRepository extends JpaRepository<TitleEntity, String>
{
//    @Query(value = "select t.id, t.title, t.date_created " +
//            "from titles as t " +
//            "left join articles as a on t.id=a.id " +
//            "where a.article like'%?1%' " +
//            "or t.title like'%?1%' " +
//            "order by t.date_created desc", nativeQuery = true)
//    List<TitleEntity> search(String keyword);

    @Query(value = """
    select title.title, title.id, title.date_created
    from titles as title 
    left join stories.articles as article on title.id = article.id 
    where title.title like %?1% 
    or article.article like %?1% 
    """, nativeQuery = true)
    Page<TitleEntity> search(String keyword, Pageable pageable);
}
