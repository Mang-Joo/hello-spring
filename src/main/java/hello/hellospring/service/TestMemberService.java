package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.TestMember;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.TestMemberRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TestMemberService {

    private final TestMemberRepository testMemberRepository;

    @Autowired
    public TestMemberService(TestMemberRepository testMemberRepository) {
        this.testMemberRepository = testMemberRepository;
    }

    public List<TestMember> findAll() {
        return testMemberRepository.findAll();
    }

    public Optional<TestMember> findByTestName(String name) {
        return testMemberRepository.findByTestName(name);
    }

    public void save(TestMember testMember) {
        validateDuplicateMember(testMember);
        testMemberRepository.save(testMember);
    }

    public Optional<TestMember> findById(Long id) {
        return testMemberRepository.findById(id);
    }



    private void validateDuplicateMember(TestMember testMember) {
        testMemberRepository.findByTestName(testMember.getTestName()).ifPresent(
                testMember1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }
        );
    }
}
