package com.maras.springtestharness.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RestApiStepDefinitions {

    static String url="";
    static String customer_id="";
    static String password="";
    static String account_no="";

    @Given("using this url {string}")
    public void setRequestUrl(String url) {
        this.url = url;
        System.out.println("URL set to: " + this.url);
    }

    @When("Customer ID is {string} password is {string} and account no is {string}")
    public void enterKeyword(String customer_id, String password, String account_no) {
        this.customer_id = customer_id;
        this.password = password;
        this.account_no = account_no;

        System.out.println("Customer ID: " + this.customer_id +
                " , Password: " + this.password +
                " , account_no: " + this.account_no);
    }

    @Then("Status code is {int}")
    public void getResponseStatus(int expectedStatusCode) {
        int statusCode= given().queryParam("CUSTOMER_ID",customer_id)
                .queryParam("PASSWORD",password)
                .queryParam("Account_No",account_no)
                .when().get(url).getStatusCode();
        //full url is http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1
        System.out.println("The response status code is: "+statusCode);

        //you can assert response status code like this
        given().queryParam("CUSTOMER_ID",customer_id)
                .queryParam("PASSWORD",password)
                .queryParam("Account_No",account_no)
                .when().get(url).then().assertThat().statusCode(expectedStatusCode);
        //or like this
        Assert.assertEquals(statusCode, expectedStatusCode);
    }

    @And("Print response time")
    public void printResponseTime(){
        System.out.println("The time taken to fetch the response "+given().queryParam("CUSTOMER_ID",customer_id)
                .queryParam("PASSWORD",password)
                .queryParam("Account_No",account_no)
                .when().get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Then("Response content type is {string}")
    public void checkResponseContentType(String expectedContentType){

        String contentType = given().get(url).then().extract().contentType();

        System.out.println("The content type of response is: "+ contentType);

        Assert.assertEquals(contentType, expectedContentType);
    }

    //This will fail
    @Then("Total value amount is {int}")
    public void checkTotalValueAmount(int expectedAmount){
        ArrayList<String> amounts = given().queryParam("CUSTOMER_ID",customer_id)
                .queryParam("PASSWORD",password)
                .queryParam("Account_No",account_no)
                .when().get(url).then().log().all().extract().path("result.statements.AMOUNT") ;
        int sumOfAll=0;
        for(String amount : amounts){

            System.out.println("The amount value fetched is: " + amount);
            sumOfAll=sumOfAll+Integer.valueOf(amount);
        }
        System.out.println("The total amount is: " + sumOfAll);

        Assert.assertEquals(sumOfAll, expectedAmount);
    }

    public static void getEntireResponse(){
        given().when().get(url).then().log()
                .all();
    }

    public static void getResponseBody(){
        given().queryParam("CUSTOMER_ID",customer_id)
                .queryParam("PASSWORD",password)
                .queryParam("Account_No",account_no) .when().get(url).then().log().body();
    }


    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                given().get(url).then().extract()
                        .headers());
    }



}