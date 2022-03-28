package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class TestMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TESTID")
    Long id;

    @Column(name = "TESTNAME")
    String testName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
