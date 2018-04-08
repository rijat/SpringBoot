package org.rija;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.rija.dao.ContactRepository;
import org.rija.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository .save(new Contact("nom", "prenom", df.parse("09/11/1982"), "email", 0625750331, "photo"));
		contactRepository .save(new Contact("nom1", "prenom1", df.parse("08/11/1982"), "email", 0225750331, "photo1"));
		contactRepository .save(new Contact("nom2", "prenom2", df.parse("07/11/1982"), "email", 0125750331, "photo2"));
		contactRepository .save(new Contact("nom3", "prenom3", df.parse("06/11/1982"), "email", 0725750331, "photo3"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	
	}
}
