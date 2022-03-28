package hello.hellospring.service;

import hello.hellospring.domain.TestMember;
import hello.hellospring.repository.TestMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
//@Transactional
@DataJpaTest
class TestMemberServiceTest {



    @Autowired
    TestMemberRepository testMemberRepository;

//    @InjectMocks
    TestMemberService testMemberService;

    @Test
    @DisplayName("전체조회 확인")
    void 전체조회() {


        List<TestMember> list = testMemberService.findAll();
        System.out.println(list);
    }

    @Test
    void 이름조회() {
        //given
        TestMember testMember = new TestMember();
        testMember.setTestName("spring");
        testMemberService.save(testMember);
        //when
        String name = "spring";
        Optional<TestMember> member = testMemberService.findByTestName("spring2");
        //then
        System.out.println("member" + member.get());

    }

    @Test
    void 저장() {
        //given
        TestMember testMember = new TestMember();
        testMember.setTestName("spring2");
        //when
        testMemberRepository.save(testMember);
        //then

//        testMemberService.save(testMember);
    }
}