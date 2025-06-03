package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;


public class RequestBuilder {

    private static RequestSpecification requestSpec;
    public static void init() {
        requestSpec = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();
    }

    public static RequestSpecification getRequest() {
        return requestSpec;
    }

    public static void setFilters(Filter... filters) {
        requestSpec.filters(Arrays.asList(filters));
    }

}
