package modulos.produtos;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.jupiter.api.Assertions;
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
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Vou preenchr dados do produto e o valor vai ser igual a 0
        navegador.findElement(By.id("produtonome")).sendKeys("Mackbook Pro");
        navegador.findElement(By.id("produtovalor")).sendKeys("000");
        navegador.findElement(By.id("produtocores")).sendKeys("preto,branco");

        //Vou submeter o formulário
        navegador.findElement(new By.ByCssSelector("button[type='submit']")).click();

        //Vou validar que a mensagem de erro foi apresentada
        String mensagemToast = navegador.findElement(new By.ByCssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);


    }

}
