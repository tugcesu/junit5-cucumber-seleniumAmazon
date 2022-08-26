package page;/*
 * (C) Copyright 2020 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutObj {

    ChromeDriver driver;
    WebDriverWait wait;

	  @FindBy(id = "nav-tools")
	  private WebElement navToolsObj;

	  @FindBy(css = ".a-box-inner.a-padding-extra-large")
	  private WebElement signInPageObj;

	  @FindBy(css = "div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16")
		private WebElement searchResultObj;

	  @FindBy(id = "ppd")
	  private WebElement productDetailObj;

	  @FindBy(id = "sw-atc-confirmation")
	  private WebElement confirmationObj;

	  @FindBy(css = ".pmts-add-payment-instruments-wrapper:nth-child(1)")
	  private WebElement paymentObj;

    public CheckoutObj(ChromeDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }


	  private WebElement navToolsObj() {
		  return driver.findElement(By.id("nav-belt"));
	}

	  private WebElement signInPageObj() {
		  return driver.findElement(By.cssSelector(".a-box-inner.a-padding-extra-large"));
	}

	  private WebElement searchResultObj() {
		  return driver.findElement(By.cssSelector("div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row:nth-child(12)"));
	}

	  private WebElement productDetailObj() {
		  return driver.findElement(By.id("ppd"));
	}

	  private WebElement confirmationObj() {
		  return driver.findElement(By.id("sw-atc-confirmation"));
	}

	  private WebElement paymentObj() {
		  return driver.findElement(By.cssSelector(".pmts-add-payment-instruments-wrapper:nth-child(1)"));
	}


	public boolean verifySignInTool() {
		WebElement signInTool = navToolsObj();
		wait.until(ExpectedConditions.visibilityOf(signInTool));
		return signInTool.isDisplayed();
	}

	public void clickSignInButton() throws InterruptedException {
		navToolsObj().findElement(By.cssSelector("#nav-link-accountList")).click();
		Thread.sleep(300);
	}

	public boolean existSignInPage() {
		WebElement SignInPage = signInPageObj();
		wait.until(ExpectedConditions.visibilityOf(SignInPage));
		return SignInPage.isDisplayed();
	}

	public void enterEmail(String textEmail) throws InterruptedException {
		signInPageObj().findElement(By.id("ap_email")).sendKeys(textEmail);
		Thread.sleep(300);
	}

	public void clickContinueButton() throws InterruptedException {
		signInPageObj().findElement(By.id("continue")).click();
		Thread.sleep(1000);
	}

	public String getEmailText() {
		WebElement emailText = signInPageObj().findElement(By.cssSelector(".a-row.a-spacing-base > span:nth-child(1)"));
		wait.until(ExpectedConditions.visibilityOf(emailText));
		return emailText.getText();
	}

	public void enterPassword(String textPassword) throws InterruptedException {
		signInPageObj().findElement(By.id("ap_password")).sendKeys(textPassword);
		Thread.sleep(300);
	}

	public void clickSignInSubmitButton() throws InterruptedException {
		 signInPageObj().findElement(By.id("signInSubmit")).click();
		 Thread.sleep(1000);
	}

	public String getAccountText() {
		 WebElement accountText = navToolsObj().findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		 wait.until(ExpectedConditions.visibilityOf(accountText));
		 return accountText.getText();
	}
	//end of login

	public void enterProductName(String textProduct) throws InterruptedException {
		 navToolsObj().findElement(By.id("twotabsearchtextbox")).sendKeys(textProduct);
		 Thread.sleep(300);
	}

	 public void clickSearchButton(){
		 navToolsObj().findElement(By.id("nav-search-submit-button")).sendKeys(Keys.ENTER);
	}

	 public boolean existSearchResult() {
		 WebElement searchResult = searchResultObj();
		 wait.until(ExpectedConditions.visibilityOf(searchResult));
		 return searchResult.isDisplayed();
	}

	 public void selectProduct(String numberProduct)  {
		  WebElement productSelection = searchResultObj().findElement(By.cssSelector
				("div.s-result-item.s-asin.sg-col.s-widget-spacing-small.sg-col-12-of-16:nth-child("+ numberProduct +")"));
		  wait.until(ExpectedConditions.visibilityOf(productSelection));
			productSelection.findElement(By.cssSelector(".a-link-normal")).click();
	}

	 public boolean existProductDetailPage() {
		 WebElement productDetail = productDetailObj().findElement(By.id("centerCol"));
		 wait.until(ExpectedConditions.visibilityOf(productDetail));
		 return productDetail.isDisplayed();
	}

	 public void clickAddToCartButton(){
			productDetailObj().findElement(By.id("add-to-cart-button")).click();
	}

	 public boolean existConfirmationPage() {
		 WebElement confirmationPage = confirmationObj();
		 wait.until(ExpectedConditions.visibilityOf(confirmationPage));
		 return confirmationPage.isDisplayed();
	}

	 public void clickCheckoutButton(){
			WebElement checkoutButton = confirmationObj().findElement(By.id("sw-ptc-form"));
			wait.until(ExpectedConditions.visibilityOf(checkoutButton));
			checkoutButton.click();
	}
	//end of cart

	 public boolean existCheckoutPage() {
		  WebElement checkoutPage = paymentObj();
		  wait.until(ExpectedConditions.visibilityOf(checkoutPage));
		  return checkoutPage.isDisplayed();
	}

}
