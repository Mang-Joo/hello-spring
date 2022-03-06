package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /*/hello로 요청이 들어오면 처리하기 위함.*/
    @GetMapping("hello")
    public String hello(Model model) {
        /*모델에 data란 이름으로 hello!! 라는 값을 담아서 hello.html에 보내준다.*/
        model.addAttribute("data", "hello!!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        /*@RequestParam은 param에 name값으로 넘어오는 값을 받겠다는 것이다.*/
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody/*http responsebody 부분에 이 데이터를 직접 넣어주겠다는 의미*/
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello ${name}" 값으로 넘어갈 것이다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 문자가 아닌 객체를 넘겼다. json 방식이다.
    }

    static class Hello {
        private String name;
        /*자바 빈 표준 방식 (프로퍼티 접근 방식)*/
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
