package kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.join_strategy.single_table.domain.SingleTableMovie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SingleTableRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {
        SingleTableMovie movie = new SingleTableMovie();
        movie.setDirector("aaaa");
        movie.setActor("bbbb");
        movie.setName("바람과 함께 사라지다");
        movie.setPrice(10000);

        em.persist(movie);

        em.flush();
        em.clear();

        SingleTableMovie findMovie = em.find(SingleTableMovie.class, movie.getId());
        System.out.println("findMovie = " + findMovie);
    }

}
