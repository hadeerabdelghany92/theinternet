package org.example.gui;

import org.example.base.BaseTest;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class GuiAutomationTests extends BaseTest {
    private final String baseUrl = "https://the-internet.herokuapp.com";

    @Test(description = "Verify file upload functionality")
    public void testFileUpload() {
        File uploadFile = new File("src/test/resources/hello-world.png");

        String uploadedFileName = new HomePage(driver)
                .open(baseUrl)
                .clickFileUpload()
                .selectFile(uploadFile.getAbsolutePath())
                .clickSubmit()
                .getUploadedFileName();

        Assert.assertEquals(uploadedFileName, uploadFile.getName(), "Uploaded file name mismatch!");
    }

    @Test(description = "Verify dynamic loading element rendered after action")
    public void testDynamicLoading() {
        String resultText = new HomePage(driver)
                .open(baseUrl)
                .clickDynamicLoading()
                .clickExample2()
                .clickStart()
                .getLoadedText();

        Assert.assertEquals(resultText, "Hello World!", "Loaded dynamic text mismatch!");
    }
}