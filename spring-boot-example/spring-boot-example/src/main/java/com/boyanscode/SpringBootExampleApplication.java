package com.boyanscode;

import com.boyanscode.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication // annotation for application(Configuration, EnableAutoConfiguration, ComponentScan)
@RestController // use rest and json to conn front(Controller, ResponseBody)
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		// run the application
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	// return string
	@GetMapping("/")
	private String greet() {
		return "Hello";
	}

	// return json obj
	@GetMapping("/record")
	private GreetResp greetResp() {

		GreetResp resp = new GreetResp(
				"HELLO",
				List.of("Java", "Python"),
				new Person("boyan", 28, 30_000)
		);
		return resp;
	}

	// record add from java 16, use for immutable object
	record Person(String name, int age, double savings){}
	record GreetResp(
			String greet,
			List<String> favProgrammingLang,
			Person person
	){}

	// same as GreetResp
	@SuppressWarnings("unused")
	static class GreetRespDetail {
		private final String greet;

		GreetRespDetail(String greet) {
            this.greet = greet;
        }

		public String getGreet() {
			return greet;
		}

		@Override
		public String toString() {
			return "GreetRespDetail{" +
					"greet='" + greet + '\'' +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			GreetRespDetail that = (GreetRespDetail) o;
			return Objects.equals(greet, that.greet);
		}

		@Override
		public int hashCode() {
			return Objects.hash(greet);
		}
	}

}
