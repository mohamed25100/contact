package fr.fms;

import fr.fms.business.IBusiness;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {

	@Autowired
	private IBusiness business;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//dataContacts();
	}

	private void dataContacts() {

		Contact c1 = new Contact();
		c1.setFirstName("John");
		c1.setLastName("Doe");
		c1.setEmail("john.doe@example.com");
		c1.setPhone("123456789");

		Contact c2 = new Contact();
		c2.setFirstName("Jane");
		c2.setLastName("Smith");
		c2.setEmail("jane.smith@example.com");
		c2.setPhone("987654321");

		Contact c3 = new Contact();
		c3.setFirstName("Alice");
		c3.setLastName("Brown");
		c3.setEmail("alice.brown@example.com");
		c3.setPhone("456123789");

		Contact c4 = new Contact();
		c4.setFirstName("Bob");
		c4.setLastName("Martin");
		c4.setEmail("bob.martin@example.com");
		c4.setPhone("789456123");

		Contact c5 = new Contact();
		c5.setFirstName("Emma");
		c5.setLastName("Wilson");
		c5.setEmail("emma.wilson@example.com");
		c5.setPhone("321654987");

		business.addContact(c1);
		business.addContact(c2);
		business.addContact(c3);
		business.addContact(c4);
		business.addContact(c5);

		System.out.println("5 contacts ajoutés avec succès !");

		System.out.println("tout va bien");
	}

}
