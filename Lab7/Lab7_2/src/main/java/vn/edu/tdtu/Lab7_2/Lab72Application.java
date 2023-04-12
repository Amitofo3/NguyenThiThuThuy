package vn.edu.tdtu.Lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.tdtu.javatech.Lab7_2.model.Student;
import vn.edu.tdtu.javatech.Lab7_2.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Lab72Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}

	private void showStudents() {
		List<Student> studentList = (List<Student>) this.studentService.getAllStudents();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(1L, "ThuThuy", 21, "thuthuy@tdtu.edu.vn", 7.0);
		Student student2 = new Student(2L, "ThanhThu", 19, "thanhthu@tdtu.edu.vn", 7.0);

		this.studentService.save(student1);
		this.studentService.save(student2);
		showStudents();
		System.out.println("After updating students");
		student1.setIeltsScore(8.0);
		this.studentService.save(student1);
		showStudents();
		System.out.println("After deleting students");
		this.studentService.deleteStudent(1L);
		showStudents();
	}
}
