package fr.sncf.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import fr.sncf.ecommerce.users.domain.models.UserRole;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		System.out.println("ça marche");
		System.out
				.println(UserRole.deSerializable("user")
						+ " role " + UserRole.deSerializable("user").serializable());
	}

}
