package com.alura.appium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class FeatureCadastro {

    @Test
    public void nao_realiza_cadastro_se_tiver_senhas_incoerentes() throws MalformedURLException {
        //é preciso acessar o Driver para conversar com o emulador

        AppiumDriverConfig driver = new AppiumDriverConfig();

        WebElement btnCriarCadastro = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        btnCriarCadastro.click();

        WebElement campoNome = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        WebElement campoSenha = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        WebElement campoConfirmarSenha = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        campoNome.sendKeys("Lucas");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("456");

        WebElement btnConfirmarCadastro = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
        btnConfirmarCadastro.click();

        WebElement msgErro = (WebElement)driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro"));

        Assert.assertEquals("Senhas não conferem", msgErro.getText());
    }

}
