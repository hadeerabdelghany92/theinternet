package org.example.api;


import io.restassured.response.Response;
import org.example.api.models.Book;
import org.example.service.BooksService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BooksApiTests {
    private BooksService booksService;

    @BeforeClass
    public void setup() {
        booksService = new BooksService();
    }

    @Test(description = "Happy Path: Fetch book by ID")
    public void testGetBookByIdSuccess() {
        Response response = booksService.getBookById(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertNotNull(response.jsonPath().getString("title"));
    }

    @Test(description = "Happy Path: Create new book record")
    public void testCreateBookSuccess() {
        Book payload = new Book(101, "Test Automation Handbook", "QA Engineering Guide", 350, "Sample Excerpt", "2026-03-30T00:00:00.000Z");

        Response response = booksService.createBook(payload);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), payload.getTitle());
    }

    @Test(description = "Edge/Negative Case: Fetch non-existent book or invalid path format parameter")
    public void testGetBookByInvalidId() {
        Response response = booksService.getBookById("invalid_id");

        Assert.assertEquals(response.getStatusCode(), 400,
                "Note: FakeRESTApi returns HTTP 400 Bad Request for string values passed in integer ID paths.");
    }
}