package com.oleksii.pudlo.lotto24.integration;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
  protected static RequestSpecification spec;

  @BeforeAll
  public static void setUp() {
      RestAssured.baseURI = "https://api.wikimedia.org/core/v1/wikipedia/en";
      RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
      spec = RestAssured.given().contentType("application/json");
  }
}
