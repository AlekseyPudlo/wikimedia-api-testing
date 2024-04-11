package com.oleksii.pudlo.lotto24.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class CaseStudyTests extends BaseTest {
  private static final String SEARCH_QUERY = "furry rabbits";
  private static final String PAGE_TITLE = "Sesame Street";
  private static String pageKey;

  @Test
  @Order(1)
  public void shouldSearchForFurryRabbitsFindsSesameStreet() {
    Response response = given().spec(spec).
      param("q", SEARCH_QUERY).
    when().
      get("/search/page").
    then().
      assertThat().
      statusCode(200).
      contentType("application/json").
      body("pages.title", hasItem(PAGE_TITLE)).
      extract().
      response();

    pageKey = response.path("pages.find { it.title == '" + PAGE_TITLE + "' }.key");

    assertNotNull(pageKey, "Page key for " + PAGE_TITLE + " should not be null");
  }

  @Test
  @Order(2)
  public void shouldHaveTimestampForSesameStreetPageDetails() {
    ZonedDateTime expectedDateThreshold = ZonedDateTime.parse("2023-08-17T00:00:00Z");

    if (pageKey == null || pageKey.isEmpty()) {
      throw new IllegalStateException("Page key for " + PAGE_TITLE + " is not available.");
    }

    String timestampActual = given().spec(spec).
    when().
      get("/page/" + pageKey + "/bare").
    then().
      assertThat().
      statusCode(200).
      contentType("application/json").
      extract().
      path("latest.timestamp");

    ZonedDateTime actualDateThreshold = ZonedDateTime.parse(timestampActual, DateTimeFormatter.ISO_DATE_TIME);

    assertTrue(
      actualDateThreshold.isAfter(expectedDateThreshold),
      "The timestamp for " + PAGE_TITLE + " should be after " + expectedDateThreshold);
  }
}
