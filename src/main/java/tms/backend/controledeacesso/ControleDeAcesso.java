package tms.backend.controledeacesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleDeAcesso {

	public static void main(String[] args) {
	    
	    System.out.println("Remove external identity providers, this not gona work. The application must become an authorization server by itself");
	    
	    System.exit(1);
	    
		SpringApplication.run(ControleDeAcesso.class, args);
	}

}
