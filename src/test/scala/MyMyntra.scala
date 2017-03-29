import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait

/**
  * Created by knoldus on 29/3/17.
  */
trait MyMyntra {

  val BASE_URL = "http://www.myntra.com/"
  val EMAIl = "shubhamagrawal6666@gmail.com"
  val password = "shubham@123"
  System.setProperty("webdriver.chrome.driver", "/home/knoldus/chrome_driver/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 20)

}
