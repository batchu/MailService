package net.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class JavamailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavamailApplication.class, args);
	}


	@Autowired
	@Qualifier("ubsJavaMailSender")
	JavaMailSender emailSender;

	@Override
	public void run(String... args) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("to@somedomain.com");
		message.setSubject("Some Subject");
		message.setText("Some Text");
		emailSender.send(message);
	}
}


