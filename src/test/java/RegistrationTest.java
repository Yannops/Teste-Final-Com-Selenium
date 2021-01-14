import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTest {

    WebDriver driver = DriverFactory.createDriver("chrome");
    private RegistrationPage page;

    @Before
    public void preCondicao() {
        driver.manage().window().maximize();
        driver.get("http://demoqa.com/");
        page = new RegistrationPage(driver);
        page.clicaEmRegistrationLink();
    }

    @Test
    public void deveCriarUmRegistro() {
        FakerGenerator faker = new FakerGenerator("pt-BR");
        page.preencheNome(faker.gerarNome(), faker.gerarSobrenome());
        page.escolheCivilSolteiro();
        page.escolheHobbyDanca();
        page.escolhePais("Brazil");
        page.preencheDataNascimento("20", "7", "2000");
        page.preencheDadosContato(faker.geraNumeroCelular(), faker.geraUsuario(), faker.geraEmail());
        page.preencheSenhasEConfirmacao("teste123", "teste123");
        page.submeteForm();
        Assert.assertTrue(page.mensagemSucessoApareceu());
        Assert.assertTrue(page.mensagemSucerroEstaCorreta());
    }

    @Test
    public void deveAvisarObrigatoridadeDoSobrenome() {
        FakerGenerator faker = new FakerGenerator("pt-BR");
        page.preencheNome(faker.gerarNome(), "");
        page.escolheCivilSolteiro();
        Assert.assertTrue(page.mensagemObrigatoriedadeDoSobrenome());
    }

    @Test
    public void deveValidarQtdMininaDeNumerosTelefone() {
        FakerGenerator faker = new FakerGenerator("en");
        page.preencheDadosContato("123456789", faker.geraUsuario(), faker.geraEmail());
        Assert.assertTrue(page.quantidadeMinimaDeNumerosTelefone());
    }

    @After
    public void posCondicao() {
        driver.quit();
    }
}
