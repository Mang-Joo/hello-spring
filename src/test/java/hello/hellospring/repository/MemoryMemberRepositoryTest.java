package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/*모든 테스트는 순서가 보장되지 않는다.*/
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach/*메소드가 끝날 때 마다 실행되게 하는 것.*/
    public void afterEach() {
        repository.clearStore();
    }
    @Test/*Junit의 테스트*/
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        /*optional에서는 get으로 값을 꺼낼 수 있다.*/
//        Assertions.assertEquals(member, result);
        /*값을 비교하는 api, 만약 값이 같으면 오류가 발생하지 않는다.*/
        assertThat(member).isEqualTo(result);
        /*위의 값과 같다. 다른 라이브러리를 사용한다. */

    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save(member1);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(result.size());
    }
}
