package TroGiang.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TroGiang.Page.DashBoardPage_CapNhatUngTuyenTroGiang;
import TroGiang.Page.LoginPage;

public class TC41_CapNhatUngTuyenTroGiang {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoardPage_CapNhatUngTuyenTroGiang dashBoardPage;
    private final String url = "https://cntttest.vanlanguni.edu.vn:18081/Ta2025";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver",
                "C:\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage_CapNhatUngTuyenTroGiang(driver);
    }

    @Test(priority = 1, description = "Kiểm thử xem kết quả cập nhật đăng ký Trợ giảng")
    public void testXemUngTuyenTroGiang() {
        try {
            // 1️⃣ Mở URL và xử lý chứng chỉ
            driver.navigate().to(url);
            loginPage.handleCertificateWarning();
            loginPage.selectAccount();

            System.out.println("✅ Đăng nhập thành công.");

            // 2️⃣ Điều hướng đến trang Trợ giảng → Đăng ký
            dashBoardPage.navigateToTaskList();
            System.out.println("✅ Đã mở menu 'Trợ giảng'.");
            Thread.sleep(2000);

            dashBoardPage.navigateToTask();
            System.out.println("✅ Đã nhấn vào 'Đăng ký'.");
            Thread.sleep(2000);

            // 3️⃣ Chọn phần và đăng ký
            dashBoardPage.ChoosePart();
            System.out.println("✅ Đã chọn phần trong danh sách Trợ giảng.");

            dashBoardPage.DangKy();
            System.out.println("✅ Đã nhấn nút 'Đăng ký'.");

            dashBoardPage.NhapThongTin(driver);
            System.out.println("✅ Đã nhập thông tin đăng ký.");
            
            dashBoardPage.submitBTN();
            System.out.println("✅ Đã nhấn nút Submit.");

            // 4️⃣ Kiểm tra kết quả
            dashBoardPage.KQDangKy();
            System.out.println("✅ Đã hiển thị kết quả đăng ký Trợ giảng.");

        } catch (Exception e) {
            System.err.println("❌ Kiểm thử thất bại: " + e.getMessage());
            e.printStackTrace();
            assert false : "Lỗi trong quá trình kiểm thử: " + e.getMessage();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            driver.quit();
        }
    }

}
