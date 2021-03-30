package boot.no.controller;

import boot.no.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/xxx")
    public String xxx() {
        return "xxxx";
    }

    @GetMapping("/index")
    public String toIndex(Model model) {
        //String name = "尖叫";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "生1"));
        students.add(new Student(2, "生2"));
        students.add(new Student(3, "生3"));
        students.add(new Student(4, "生5"));

        model.addAttribute("students", students);
        //model.addAttribute("name", name);
        return "index";
    }
}
