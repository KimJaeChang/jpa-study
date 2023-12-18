package kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.JoinStrategy.joined.domain.JoinedMovie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JoinedRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {
        JoinedMovie movie = new JoinedMovie();
        movie.setDirector("aaaa");
        movie.setActor("bbbb");
        movie.setName("바람과 함께 사라지다");
        movie.setPrice(10000);

        em.persist(movie);

        em.flush();
        em.clear();

        JoinedMovie findMovie = em.find(JoinedMovie.class, movie.getId());
        System.out.println("findMovie = " + findMovie);
    }

}
