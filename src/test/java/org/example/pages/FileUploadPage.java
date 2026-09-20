package org.example.pages;


import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {
    private final By fileInput = By.id("file-upload");
    private final By submitButton = By.id("file-submit");
    private final By uploadedFilesHeader = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public FileUploadPage selectFile(String filePath) {
        sendKeys(fileInput, filePath);
        return this;
    }

    public FileUploadPage clickSubmit() {
        click(submitButton);
        return this;
    }

    public String getUploadedFileName() {
        return getText(uploadedFilesHeader);
    }
}
