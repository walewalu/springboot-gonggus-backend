package com.project.gonggus.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.category = :category")
    List<Post> findByCategory(@Param("category") String category);

    @Query("select p from Post p where p.title like concat('%',:searchTitle,'%')")
    List<Post> findBySearchTitle(@Param("searchTitle") String searchTitle);
}
