package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.DocDelivery.DocDeliveryContractCopyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataFileDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataReVerifyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataVerifyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryStartDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskAcceptCreditDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskInputCreditDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManageChangePage;
import com.auction.page.customermanage.CustomerManagePage;
import com.auction.page.insurancemanage.InsuranceRegisterDetailToDo;
import com.auction.page.mytask.MyTaskAutoFinanceDetailToDo;
import com.auction.page.mytask.MyTaskBranchCompanyAccountDetailToDo;
import com.auction.page.mytask.MyTaskBranchCompanyManagerDetailToDo;
import com.auction.page.mytask.MyTaskFinanceDepartmentAccountDetailToDo;
import com.auction.page.mytask.MyTaskFinanceDepartmentHeadDetailToDo;
import com.auction.page.mytask.MyTaskFinanceManagerDetailToDo;
import com.auction.page.mytask.MyTaskLoanStartDetailToDo;
import com.auction.page.mytask.MyTaskMainSignBillInvestDetailToDo;
import com.auction.page.mytask.MyTaskMiddleCheckDetailToDo;
import com.auction.page.mytask.MyTaskOfficeDetailToDo;
import com.auction.page.mytask.MyTaskPrimaryCheckDetailToDo;
import com.auction.page.mytask.MyTaskSecondSignBillInvestDetailToDo;
import com.auction.page.mytask.MyTaskSignBillDistributionDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarEvaluateStartDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarPreEvaluationDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarReEvaluationDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferReportDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferVerifyDetailToDo;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class HomePage extends BasePage {
	private Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��HomePage��");
	}

	/**
	 * �����¼ҳ��
	 * 
	 * @return
	 */
	public LoginPage goLoginPage() {
		return new LoginPage(driver);
	}
	
	/**
	 * ע����¼
	 * @return
	 */
	public LoginPage Logincancel(){
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']/div[1]/nav/div[2]/div/div/ul/li[4]/span"));
		driver.pause(1000);
		driver.click(By.id("exitSure"));
		return new LoginPage(driver);
	}
	

	/**
	 * �˳���¼�����¼ҳ��
	 * 
	 * @return
	 */
	public LoginPage logout() {
		driver.click(By.partialLinkText("ע��"));
		return new LoginPage(driver);
	}
	
	/**
	 * ����ͻ�����ҳ��-�޸�
	 * @return
	 */
	public CustomerManageChangePage goCustomerManageChangePage() {
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/ul/li[2]/a"));
		driver.pause(1000);
		return new CustomerManageChangePage(driver);
	}
	
	/**
	 * ����ͻ�����ҳ��-����
	 * @return
	 */
	public CustomerManagePage goCustomerManagePage() {
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/ul/li[2]/a"));
		driver.pause(1000);
		return new CustomerManagePage(driver);
	}
	
	/**
	 * �������ŷ���ҳ��
	 * @return
	 */
	public StartCreditPage goStartCreditPage() {
		driver.selectDefaultFrame();
		driver.click(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='3001']"));
		driver.pause(1000);
		return new StartCreditPage(driver);
	}
	
	/**
	 * ����¼������ҳ��
	 * @return
	 */
	public MyTaskInputCreditDetailToDo goInputCreditPage() {
		return new MyTaskInputCreditDetailToDo(driver);
	}
	
	/**
	 * �����������ҳ��
	 * @return
	 */
	public MyTaskAcceptCreditDetailToDo goAcceptCreditPage() {
		return new MyTaskAcceptCreditDetailToDo(driver);
	}
	
	/**
	 * �����ҵ�����ҳ��
	 * @return
	 */
	public MyTaskPage goMyTaskPage(int flag) {
		driver.selectDefaultFrame();
		if(flag==1){
			driver.click(By.xpath("//*[@id='side-menu']/li[2]/a"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
			driver.pause(1000);
		}else{
			String text = driver.getAttribute(By.xpath("//*[@id='side-menu']/li[2]"), "class");
			System.out.println("---------------------1111111"+text+"222222222-----------------------");
			if(text.equals("active")){
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
				driver.pause(1000);
			}else{
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/a"));
				driver.pause(1000);
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
				driver.pause(1000);
			}

		}
		return new MyTaskPage(driver);
	}
	

	
	/**
	 * �����ҵ�����-���ſ�ʼҳ��
	 * @return
	 */
	public MyTaskStartCreditDetailToDo goMyTaskStartCreditDetailToDo() {
		return new MyTaskStartCreditDetailToDo(driver);
	}

		
	/**
	 * ��������ҳ��
	 * @return
	 */
	public MyTaskLoanStartDetailToDo goMyTaskLoanStartDetailToDo() {
		driver.click(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='3002']"));
		return new MyTaskLoanStartDetailToDo(driver);
	}
	
	/**
	 * ����ǩ������ҳ��
	 * @return
	 */
	public MyTaskSignBillDistributionDetailToDo goMyTaskSignBillDistributionDetailToDo() {
		return new MyTaskSignBillDistributionDetailToDo(driver);
	}
	
	/**
	 * ������ǩ������ҳ��
	 * @return
	 */
	public MyTaskMainSignBillInvestDetailToDo goMyTaskMainSignBillInvestDetailToDo() {
		return new MyTaskMainSignBillInvestDetailToDo(driver);
	}
	
	/**
	 * ���븱ǩ������ҳ��
	 * @return
	 */
	public MyTaskSecondSignBillInvestDetailToDo goMyTaskSecondSignBillInvestDetailToDo() {
		return new MyTaskSecondSignBillInvestDetailToDo(driver);
	}
	
	/**
	 * ��������¼��ҳ��
	 * @return
	 */
	public MyTaskOfficeDetailToDo goMyTaskOfficeDetailToDo() {
		return new MyTaskOfficeDetailToDo(driver);
	}
	
	/**
	 * ����������ҳ��
	 * @return
	 */
	public MyTaskPrimaryCheckDetailToDo goMyTaskPrimaryCheckDetailToDo() {
		return new MyTaskPrimaryCheckDetailToDo(driver);
	}
	
	/**
	 * �����м����ҳ��
	 * @return
	 */
	public MyTaskMiddleCheckDetailToDo goMyTaskMiddleCheckDetailToDo() {
		return new MyTaskMiddleCheckDetailToDo(driver);
	}
	
	/**
	 * ����ֹ�˾�ܾ���ҳ��
	 * @return
	 */
	public MyTaskBranchCompanyManagerDetailToDo goMyTaskBranchCompanyManagerDetailToDo() {
		return new MyTaskBranchCompanyManagerDetailToDo(driver);
	}
	
	/**
	 * �����������ڲ�ҳ��
	 * @return
	 */
	public MyTaskAutoFinanceDetailToDo goMyTaskAutoFinanceDetailToDo() {
		return new MyTaskAutoFinanceDetailToDo(driver);
	}
	
	/**
	 * �����������ҳ��
	 * @return
	 */
	public MyTaskFinanceManagerDetailToDo goMyTaskFinanceManagerDetailToDo() {
		return new MyTaskFinanceManagerDetailToDo(driver);
	}
	
	/**
	 * �����ʽ�����ҳ��
	 * @return
	 */
	public MyTaskFinanceDepartmentHeadDetailToDo goMyTaskFinanceDepartmentHeadDetailToDo() {
		return new MyTaskFinanceDepartmentHeadDetailToDo(driver);
	}
	
	/**
	 * �����ʽ𲿳���ҳ��
	 * @return
	 */
	public MyTaskFinanceDepartmentAccountDetailToDo goMyTaskFinanceDepartmentAccountDetailToDo() {
		return new MyTaskFinanceDepartmentAccountDetailToDo(driver);
	}
	
	/**
	 * �����ʽ𲿳���ҳ��
	 * @return
	 */
	public MyTaskBranchCompanyAccountDetailToDo goMyTaskBranchCompanyAccountDetailToDo() {
		return new MyTaskBranchCompanyAccountDetailToDo(driver);
	}
	
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public MyTaskSecondCarEvaluateStartDetailToDo goMyTaskSecondCarEvaluateStartDetailToDo() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[8]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='8001']"));
		return new MyTaskSecondCarEvaluateStartDetailToDo(driver);
	}
	
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public MyTaskSecondCarTransferDetailToDo goMyTaskSecondCarTransferDetailToDo() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[8]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='8002']"));
		return new MyTaskSecondCarTransferDetailToDo(driver);
	}
	
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public MyTaskSecondCarPreEvaluationDetailToDo goMyTaskSecondCarPreEvaluationDetailToDo() {
		return new MyTaskSecondCarPreEvaluationDetailToDo(driver);
	}
	
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public MyTaskSecondCarTransferVerifyDetailToDo goMyTaskSecondCarTransferVerifyDetailToDo() {
		return new MyTaskSecondCarTransferVerifyDetailToDo(driver);
	}
	
	/**
	 * ������ֳ�������������ҳ��
	 * @return
	 */
	public MyTaskSecondCarTransferReportDetailToDo goMyTaskSecondCarTransferReportDetailToDo() {
		return new MyTaskSecondCarTransferReportDetailToDo(driver);
	}
	
	/**
	 * ������ֳ�����ҳ��
	 * @return
	 */
	public MyTaskSecondCarReEvaluationDetailToDo goMyTaskSecondCarReEvaluationDetailToDo() {
		return new MyTaskSecondCarReEvaluationDetailToDo(driver);
	}
	
	/**
	 * �����ĵ�����ҳ��
	 * @return
	 */
	public DocDeliveryStartDetailToDo goDocDeliveryStartDetailToDo() {
		driver.click(By.xpath("//*[@id='side-menu']/li[7]"));
		driver.click(By.xpath("//*[@id='side-menu']/li[7]/ul/li[1]"));
		return new DocDeliveryStartDetailToDo(driver);
	}
	/**
	 * �����������ҳ��
	 * @return
	 */
	public DocDeliveryDataVerifyDetailToDo goDocDeliveryDataVerifyDetailToDo() {
		return new DocDeliveryDataVerifyDetailToDo(driver);
	}
	
	/**
	 * �����ͬ��дҳ��
	 * @return
	 */
	public DocDeliveryContractCopyDetailToDo goDocDeliveryContractCopyDetailToDo() {
		return new DocDeliveryContractCopyDetailToDo(driver);
	}
	/**
	 * �������ϸ���ҳ��
	 * @return
	 */
	public DocDeliveryDataReVerifyDetailToDo goDocDeliveryDataReVerifyDetailToDo() {
		return new DocDeliveryDataReVerifyDetailToDo(driver);
	}
	/**
	 * �������Ϲ鵵ҳ��
	 * @return
	 */
	public DocDeliveryDataFileDetailToDo goDocDeliveryDataFileDetailToDo() {
		return new DocDeliveryDataFileDetailToDo(driver);
	}
	/**
	 * ���뱣�չ���ҳ��
	 * @return
	 */
	public InsuranceRegisterDetailToDo goInsuranceRegisterDetailToDo() {
		if(driver.getAttribute(By.xpath("//*[@id='side-menu']/li[9]"), "class").equals("active")){
			driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='9001']"));
		}else{
			driver.click(By.xpath("//*[@id='side-menu']/li[9]/a"));
			driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='9001']"));
		}
		return new InsuranceRegisterDetailToDo(driver);
	}
	
}
