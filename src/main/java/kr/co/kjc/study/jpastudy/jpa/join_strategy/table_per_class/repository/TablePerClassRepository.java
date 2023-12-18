package kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.domain.TablePerClassItem;
import kr.co.kjc.study.jpastudy.jpa.join_strategy.table_per_class.domain.TablePerClassMovie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TablePerClassRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {
        TablePerClassMovie movie = new TablePerClassMovie();
        movie.setDirector("aaaa");
        movie.setActor("bbbb");
        movie.setName("바람과 함께 사라지다");
        movie.setPrice(10000);

        em.persist(movie);

        em.flush();
        em.clear();

        TablePerClassItem findItem = em.find(TablePerClassItem.class, movie.getId());
        System.out.println("findItem = " + findItem);
    }

}
