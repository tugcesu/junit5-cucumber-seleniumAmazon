package stepDefs;/*
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

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import page.CheckoutObj;


public class CheckoutStepDefs extends BaseConfig {

    protected CheckoutObj checkout;

    public CheckoutStepDefs() {
			checkout = new CheckoutObj(driver, wait);
    }

	  @Given("I should see sign in tool bar on the web app")
		public void existCheckoutForm() {
		assertEquals(checkout.verifySignInTool(),true);
	 }

	  @When("I click to Sign In button on the home page")
	  public void clickSignIn() throws InterruptedException {
		checkout.clickSignInButton();
	 }

	  @Then("I should see the Sign In page")
	  public void verifySignInPage() {
		assertEquals(checkout.existSignInPage(),true);
	}

	  @When("I enter {string} as email")
  	public void enterTheEmail(String textEmail) throws InterruptedException {
		checkout.enterEmail(textEmail);
	}

	  @When("I click to continue button")
	  public void clickContinue() throws InterruptedException {
		checkout.clickContinueButton();
	}

	  @Then("I should see {string} as email on the password entering page")
	  public void getEmail(String emailText) {
		assertEquals(emailText, checkout.getEmailText());
	}

	  @When("I enter {string} as a password")
	  public void enterPassword(String textPassword) throws InterruptedException {
		checkout.enterPassword(textPassword);
	}

	  @When("I click to Sign In submit button")
	  public void clickSignInSubmit() throws InterruptedException {
		checkout.clickSignInSubmitButton();
	}

	  @Then("I should see {string} on the home page")
	  public void getAccountName(String accountText) {
		assertEquals(accountText, checkout.getAccountText());
	}

	//end of the login

  	@When("I enter {string} to find the product in the search box")
 	  public void enterProduct(String textProduct) throws InterruptedException{
		checkout.enterProductName(textProduct);
	}

	  @When("I click to search button")
	  public void clickProductSearch(){
		checkout.clickSearchButton();
	}

   	@Then("I should see search results page")
	  public void verifySearchResultPage() {
		assertEquals(checkout.existSearchResult(),true);
	}

	  @When("I click to {string}th product on the search result page")
	  public void selectProductFromSearch(String numberProduct) {
		checkout.selectProduct(numberProduct);
	}

	  @Then("I should see product detail page")
	  public void existProductDetail() {
    assertEquals(checkout.existProductDetailPage(),true);
	}

	  @When("I click to add to cart button")
	  public void clickAddToCart(){
		checkout.clickAddToCartButton();
	}

	  @Then("I should see confirmation page")
	  public void existConfirmation() {
		assertEquals(checkout.existConfirmationPage(),true);
	}

	  @When("I click to Proceed to checkout button")
		public void clickProceedToCheckout(){
    checkout.clickCheckoutButton();
	}

	//end of the cart

	  @Then("I should see payment-checkout page")
	  public void existCheckout() {
		assertEquals(checkout.existCheckoutPage(),true);
	}


	@After
	public void closeDriver(){
	driver.quit();
	}
}
