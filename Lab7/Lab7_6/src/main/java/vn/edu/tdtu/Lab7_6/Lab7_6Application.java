package vn.edu.tdtu.Lab7_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.tdtu.javatech.Lab7_6.model.Student;
import vn.edu.tdtu.javatech.Lab7_6.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Lab7_6Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(Lab7_6Application.class, args);
	}

	private void showStudents() {
		List<Student> studentList = (List<Student>) this.studentService.getAllStudents();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void showStudentList(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		Student student1 = new Student(1L, "ThuThuy", 21, "thuthuy@tdtu.edu.vn", 7.0);
		Student student2 = new Student(2L, "ThanhThu", 19, "thanhthu@tdtu.edu.vn", 7.0);
		studentList.add(new Student(3L, "NgocVan", 20, "ngocvan@tdtu.edu.vn", 7.5));
		studentList.add(new Student(4L, "ThanhHa", 20, "thanha@tdtu.edu.vn", 8.5));
		studentList.add(new Student(5L, "Student5", 21, "student5@tdtu.edu.vn", 8.5));
		studentList.add(new Student(6L, "Student6", 21, "student6@tdtu.edu.vn", 8.5));
		studentList.add(new Student(7L, "Student7", 21, "student7@tdtu.edu.vn", 8.5));
		studentList.add(new Student(8L, "Student8", 21, "student8@tdtu.edu.vn", 8.5));
		studentList.add(new Student(9L, "Student9", 21, "student9@tdtu.edu.vn", 8.5));
		studentList.add(new Student(10L, "Student10", 21, "student10@tdtu.edu.vn", 8.5));
		studentList.add(new Student(11L, "Student11", 21, "student11@tdtu.edu.vn", 8.5));
		for(Student student: studentList) {
			studentService.save(student);
		}
		showStudents();

		System.out.println("The customized list of students:");
		List<Student> customizedStudentList = (List<Student>) studentService.getCustomizedStudentList();
		showStudentList(customizedStudentList);
	}
}
