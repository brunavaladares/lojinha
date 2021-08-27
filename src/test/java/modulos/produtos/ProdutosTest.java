package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {
    @Test
    @DisplayName("Não é permitido registrar um prodto com valor igal a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver91\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Vou maximinizar a tela
        navegador.manage().window().maximize();

        // Navegar para a página da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

        // Fazer login
        navegador.findElement(new By.ByCssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");

        navegador.findElement(new By.ByCssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");

        navegador.findElement(new By.ByCssSelector("button[type='submit']")).click();

        // Vou para a tela de registro de produto



        // Vo submeter o formulário


        // Vou validar que a mensagem de erro foi apresentada

    }

}
