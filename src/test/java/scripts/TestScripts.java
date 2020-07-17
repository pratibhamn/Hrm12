package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import pom.HomePage;

public class TestScripts extends BaseTest{
	@Test(enabled=false)
	public void testCreateEmployee() {
		HomePage p=new HomePage(driver);
		p.setuserName("Admin");
		p.setPwd("admin123");
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.click_Pim();
		p.click_AddEmp();
		p.setFirstName("Abhi");
		p.setLastName("SR");
		p.clickSaveBtn();
	}
	@Test(enabled=true)
	public void testSortListBox() throws EncryptedDocumentException, IOException {
		HomePage p=new HomePage(driver);
		p.setuserName(Excel.readData("Sheet1", 0, 1));
		p.setPwd(Excel.readData("Sheet1", 1, 1));
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.click_Pim();
		p.add_EmpList();
		GenericUtils.sortListbox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
	}
	

}
