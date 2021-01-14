import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerGenerator {
    Faker faker = new Faker();

    public FakerGenerator(String idioma) {
        escolheIdioma(idioma);
    }

    public Faker escolheIdioma(String pais) {
        Faker faker = new Faker(new Locale(pais));
        return faker;
    }

    public String gerarNome() {
        return faker.name().firstName();
    }

    public String gerarSobrenome() {
        return faker.name().lastName();
    }

    public String gerarNomeInteiro() {
        return faker.name().fullName();
    }

    public String geraNumeroCelular() {
        return faker.phoneNumber().cellPhone();
    }

    public String geraUsuario() {
        return faker.name().username();
    }

    public String geraEmail() {
        return faker.internet().emailAddress();
    }
}
