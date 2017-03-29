/**
  * Created by knoldus on 29/3/17.
  */
import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.scalatest.FlatSpec

class MyntraSpec extends FlatSpec with MyMyntra {

  "A user" should "visit on amazon.in" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
  }

  "user" should "fail to login with invalid credentials" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys("shubham@gmail.com")

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys("123456")

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "logged in " in {

    //    driver.manage().window().maximize()
    //    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys(EMAIl)

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys(password)

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "select a Jeans category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.split-navi-list ul:nth-child(4) li.navi-base  a.navi-link.navi-pad")))

    driver.findElementByCssSelector("ul.split-navi-list ul:nth-child(4) li.navi-base  a.navi-link.navi-pad").click()
  }

  "user" should "select a Jeans" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to choose the desired size of the selected Jeans and then add it to the cart" in {

    driver.findElementByCssSelector("button.size-buttons-size-button.size-buttons-size-button-default").click()

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()
  }

  "user" should "search for shoes category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.desktop-searchBar")))

    val search: WebElement =driver.findElementByCssSelector("input.desktop-searchBar")
    search.sendKeys("shoes")
    driver.findElementByCssSelector("a.desktop-submit").click()
  }

  "user" should "select a shoe" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to add the shoe to the cart" in {

    driver.findElementByCssSelector("button.size-buttons-size-button.size-buttons-size-button-default").click()
    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()

  }
  "user" should "be able to verify the products added to cart" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

}
