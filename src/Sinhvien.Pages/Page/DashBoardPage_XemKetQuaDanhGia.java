package TroGiang.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage_XemKetQuaDanhGia {
    private WebDriverWait wait;

    // Các Locator
    private By TaskList = By.id("child-trogiang-reviewtask");
    private By Task = By.id("parent-trogiang");
    private By HK = By.cssSelector("#hocky > option:nth-child(16)");
    private By HP = By.cssSelector("#nganh > option:nth-child(7)");
    private By ChooseHK = By.id("hocky");
    private By ChooseHP = By.id("nganh");

    // Constructor
    public DashBoardPage_XemKetQuaDanhGia(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToTask() {
        wait.until(ExpectedConditions.elementToBeClickable(Task)).click();
    }

	public void navigateToTaskList() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(TaskList)).click();
	}
	public void chooseterm() {
		wait.until(ExpectedConditions.elementToBeClickable(ChooseHK)).click();
		wait.until(ExpectedConditions.elementToBeClickable(HK)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ChooseHP)).click();
		wait.until(ExpectedConditions.elementToBeClickable(HP)).click();
	}
}