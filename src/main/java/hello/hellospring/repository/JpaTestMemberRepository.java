package hello.hellospring.repository;

import hello.hellospring.domain.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestMemberRepository extends JpaRepository<TestMember, Long>, TestMemberRepository {

}
