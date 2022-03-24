package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager entityManager; // JPA를 사용하려면 EntityManager를 주입받아야한다.

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    } // 스프링부트가 만들어준다. DI로 주입해주면 된다.

    @Override
    public Member save(Member member) {
        entityManager.persist(member); // insert
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class) // JPQL 객체를 대상으로 쿼리를 날린다.
                .getResultList();
    }
}
