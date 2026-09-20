package org.example.service;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.models.Book;

import static io.restassured.RestAssured.given;

public class BooksService {
    private final RequestSpecification spec;

    public BooksService() {
        this.spec = new RequestSpecBuilder()
                .setBaseUri("https://fakerestapi.azurewebsites.net")
                .setBasePath("/api/v1/Books")
                .setContentType(ContentType.JSON)
                .build();
    }

    public Response getAllBooks() {
        return given().spec(spec).when().get();
    }

    public Response getBookById(Object id) {
        return given().spec(spec).pathParam("id", id).when().get("/{id}");
    }

    public Response createBook(Book book) {
        return given().spec(spec).body(book).when().post();
    }

    public Response deleteBook(int id) {
        return given().spec(spec).pathParam("id", id).when().delete("/{id}");
    }
}
