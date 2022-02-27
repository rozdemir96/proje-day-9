package hrms.proje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class ProjeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjeApplication.class, args);
	}

	@Bean//Bean; normal bir class'tan herhangi bir farkı yoktur. Derleme yapıldığında Spring Boot, Bean'i gördüğü zaman belleğe yerleştirir
	//Docket isimli bir nesne ile controller'larımızdaki bütün RequestHandler'ları bulur ve bizim için dökümantasyon haline getirir.
	//Uygulamamız içerisindeki bütün API'leri bulur ve o API'leri tarayıp test edebileceğimiz bir noktaya taşır.
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("hrms.proje"))//kodlamaio.northwind'leri gez, API'leri bul ve dökümantasyona ekle
				.build();
	}

}
