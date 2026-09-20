package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    private final By example2Link = By.partialLinkText("Example 2");
    private final By startButton = By.cssSelector("#start button");
    private final By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage clickExample2() {
        click(example2Link);
        return this;
    }

    public DynamicLoadingPage clickStart() {
        click(startButton);
        return this;
    }

    public String getLoadedText() {
        return getText(finishText);
    }
}