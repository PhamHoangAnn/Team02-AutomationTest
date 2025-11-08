package TroGiang.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage_XoaUngTuyenTroGiang {
    private WebDriverWait wait;

    // Các Locator
    private By Task = By.id("child-trogiang-apply");
    private By TaskList = By.id("parent-trogiang");
    private By HK = By.cssSelector("#hocky > option:nth-child(16)");
    private By HP = By.cssSelector("#nganh > option:nth-child(2)");
    private By HocKy = By.id("hocky");
    private By Nganh = By.id("nganh");
    private By Dangky = By.cssSelector("#applyLHP-6165");
    private By KQDangKy = By.id("child-trogiang-resultapply");
    private By submitBTN = By.xpath("/html/body/div[7]/div/div[6]/button[1]");
    private By KQHK = By.cssSelector("#hocky > option:nth-child(16)");
    private By KQHP = By.cssSelector("#nganh > option:nth-child(7)");
    private By btnHuy = By.id("btnHuydangky");
    
    // Constructor
    public DashBoardPage_XoaUngTuyenTroGiang(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== Các hành động =====

    /** Mở menu "Trợ giảng" */
    public void navigateToTaskList() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(TaskList));
        menu.click();
        System.out.println("✅ Đã mở menu 'Trợ giảng'");
    }

    /** Nhấn vào mục "Đăng ký" */
    public void navigateToTask() {
        // Đợi phần tử hiển thị sau khi mở menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(Task));
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(Task));
        item.click();
        System.out.println("✅ Đã chọn mục 'Đăng ký' trong menu Trợ giảng");
    }

    /** Chọn học kỳ và ngành */
    public void ChoosePart() {
        wait.until(ExpectedConditions.elementToBeClickable(HocKy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(HK)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Nganh)).click();
        wait.until(ExpectedConditions.elementToBeClickable(HP)).click();
        System.out.println("✅ Đã chọn học kỳ và ngành");
    }

    /** Nhấn nút "Đăng ký" */
    public void DangKy() {
        wait.until(ExpectedConditions.elementToBeClickable(Dangky)).click();
        System.out.println("✅ Đã nhấn nút 'Đăng ký'");
    }

    /** Nhấn nút "Hủy đăng ký" */
    public void HuyDangKy() {
    	wait.until(ExpectedConditions.elementToBeClickable(btnHuy)).click();;
    }

    public void submitBTN() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBTN)).click();
        System.out.println("✅ Đã nhấn nút Submit");
    }

    

    /** Mở trang Kết quả đăng ký */
    public void KQDangKy() {
        wait.until(ExpectedConditions.elementToBeClickable(KQDangKy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(KQHK)).click();
        wait.until(ExpectedConditions.elementToBeClickable(KQHP)).click();
        System.out.println("✅ Đã mở trang 'Kết quả đăng ký'");
    }
}