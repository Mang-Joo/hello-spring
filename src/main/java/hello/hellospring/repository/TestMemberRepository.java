package hello.hellospring.repository;

import hello.hellospring.domain.TestMember;

import java.util.List;
import java.util.Optional;

public interface TestMemberRepository {
    TestMember save(TestMember testMember);

    Optional<TestMember> findByTestName(String testName);

    List<TestMember> findAll();

    Optional<TestMember> findById(Long id);



}
