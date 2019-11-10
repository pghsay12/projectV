package com.vision.erp.web.accounting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.ImageFileUpload;
import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingService;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.Card;
import com.vision.erp.service.domain.Salary;
import com.vision.erp.service.domain.SalaryBook;
import com.vision.erp.service.domain.Statement;
import com.vision.erp.service.domain.Vendor;

@RestController
public class AccountingController {

	@Resource(name = "accountingServiceImpl")
	private AccountingService accountingService;
	
	public AccountingController() {
		super();
	}

	//�ŷ�ó���
	@RequestMapping(value = "/accounting/addVendor", method = RequestMethod.POST)
	public void addVendor(@RequestBody Vendor vendor) throws Exception{
		
		System.out.println("/accounting/addVendor");
		System.out.println("���� vendor domain ��"+vendor);
		
		vendor.setVendorTel(vendor.getLocalPhoneCode()+"-"+vendor.getVendorTel());
		
		accountingService.addVendor(vendor);
	}
	
	//�ŷ�ó ����ȸ
	@RequestMapping(value = "/accounting/getVendorDetail/{vendorNo}", method = RequestMethod.GET)
	public Vendor getVendorDetail(@PathVariable String vendorNo) throws Exception{
		
		System.out.println("/accounting/getVendorDetail");
		System.out.println(vendorNo);
		
		Vendor vendor = accountingService.getVendorDetail(vendorNo);
		
		vendor.setLocalPhoneCode(vendor.getVendorTel().substring(0, vendor.getVendorTel().indexOf("-")));
		vendor.setVendorTel(vendor.getVendorTel().substring(vendor.getVendorTel().indexOf("-")+1));
		System.out.println(vendor);
		
		return vendor;
	}
	
	//�ŷ�ó ����
	@RequestMapping(value = "/accounting/modifyVendor", method = RequestMethod.POST)
	public void modifyVendor(@RequestBody Vendor vendor) throws Exception{
		
		System.out.println("/accounting/modifyVendor");
		vendor.setVendorTel(vendor.getLocalPhoneCode()+"-"+vendor.getVendorTel());
		
		accountingService.modifyVendor(vendor);
	}
	
	//�ŷ�ó ������ ����
	@RequestMapping(value = "/accounting/convertVendorUsageStatus", method = RequestMethod.POST)
	public void convertVendorUsageStatus(@RequestBody List<Object> objectList) throws Exception{
		
		System.out.println("/accounting/convertVendorUsageStatus");
		System.out.println("���� �ŷ�ó ��ȣ :: "+objectList);
		
		List<Vendor> vendorList = new ArrayList<Vendor>();
		for(int i = 0; i<objectList.size(); i++) {
			Vendor vendor = new Vendor();
			vendor.setVendorNo((String)objectList.get(i));
			vendor.setVendorUsageStatusCodeNo("02");
			vendorList.add(vendor);
		}
		System.out.println(vendorList);
		accountingService.convertVendorUsageStatus(vendorList);
	}
	
	//�ŷ�ó ��� ��������
	@RequestMapping(value = "/accounting/getVendorList", method = RequestMethod.POST)
	public List<Vendor> getVendorList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getVendorList");
		System.out.println("search ���� :: "+search);
		
		List<Vendor> list = accountingService.getVendorList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//���� ���
	@RequestMapping(value = "/accounting/addAccount", method = RequestMethod.POST)
	public void addAccount(@RequestBody Account account) throws Exception{
		
		System.out.println("/accounting/addAccount");
		
		accountingService.addAccount(account);
	}
	
	//���� ����ȸ
	@RequestMapping(value = "/accounting/getAccountDetail/{accountRegNo}", method = RequestMethod.GET)
	public Account getAccountDetail(@PathVariable String accountRegNo) throws Exception{
		
		System.out.println("/accounting/getAccountDetail");
		System.out.println(accountRegNo);
		
		Account account = accountingService.getAccountDetail(accountRegNo);
		
		return account;
	}
	
	//���� ����
	@RequestMapping(value = "/accounting/modifyAccount", method = RequestMethod.POST)
	public void modifyAccount(@RequestBody Account account) throws Exception{
		
		System.out.println("/accounting/modifyAccount");
		
		accountingService.modifyAccount(account);
	}
	
	//���� ������ ����
	@RequestMapping(value = "/accounting/convertAccountUsageStatus", method = RequestMethod.POST)
	public void convertAccountUsageStatus(@RequestBody List<Object> objectList) throws Exception{
		
		System.out.println("/accounting/convertAccountUsageStatus");
		System.out.println("���� �ŷ�ó ��ȣ :: "+objectList);
		
		List<Account> accountList = new ArrayList<Account>();
		for(int i = 0; i<objectList.size(); i++) {
			Account account = new Account();
			account.setAccountRegNo((String)objectList.get(i));
			account.setAccountUsageStatusCodeNo("02");
			accountList.add(account);
		}
		accountingService.convertAccountUsageStatus(accountList);
	}
	
	//���� �����ȸ
	@RequestMapping(value = "/accounting/getAccountList", method = RequestMethod.POST)
	public List<Account> getAccountList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getAccountList");
		System.out.println("search ���� :: "+search);
		
		List<Account> list = accountingService.getAccountList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//���¹�ȣ �ߺ�üũ
	@RequestMapping(value = "/accounting/checkDuplicateAccount/{accountNo}", method = RequestMethod.GET)
	public boolean checkDuplicateAccount(@PathVariable String accountNo) throws Exception{
		
		System.out.println("/accounting/checkDuplicateAccount");
		System.out.println("���� accountNo ::"+accountNo);
		
		int checkAccount = accountingService.checkDuplicateAccount(accountNo);
		
		if(checkAccount == 0) {
			return true;
		}else {
			return false;
		}
				
	}
	
	//�޿� ���
	@RequestMapping(value = "/accounting/addSalary/{salaryDate}", method = RequestMethod.GET)
	public void addSalary(@PathVariable String salaryDate) throws Exception{
		
		System.out.println("/accounting/addSalary");
		System.out.println("���� salaryDate :: "+salaryDate);
		salaryDate = salaryDate.substring(0, 4)+"/"+salaryDate.substring(4);
		System.out.println(salaryDate);
		accountingService.addSalary(salaryDate);
	}
	
	//�޿� ����ȸ
	@RequestMapping(value = "/accounting/getSalaryDetail/{salaryNumbering}", method = RequestMethod.GET)
	public Salary getSalaryDetail(@PathVariable String salaryNumbering) throws Exception{
		
		System.out.println("/accounting/getSalaryDetail");
		System.out.println("���� salaryNumbering :: "+salaryNumbering);
		
		Salary salary = accountingService.getSalaryDetail(salaryNumbering);
		
		return salary;
	}
	
	//�޿� ����
	@RequestMapping(value = "/accounting/modifySalary", method = RequestMethod.POST)
	public void modifySalary(@RequestBody Salary salary) throws Exception{
		
		System.out.println("/accounting/modifySalary");
		
		accountingService.modifySalary(salary);
	}
	
	//�޿� ���� ����
	@RequestMapping(value = "/accounting/modifySalaryStatus", method = RequestMethod.POST)
	public void modifySalaryStatus(@RequestBody Salary salary) throws Exception{
		
		System.out.println("/accounting/modifySalaryStatus");
		
		accountingService.modifySalaryStatus(salary);
	}
	
	//�޿� �����ȸ
	@RequestMapping(value = "/accounting/getSalaryList", method = RequestMethod.POST)
	public List<Salary> getSalaryList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getSalaryList");
		System.out.println("search ���� :: "+search);
		
		List<Salary> list = accountingService.getSalaryList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//�޿��� �ߺ�üũ
	@RequestMapping(value = "/accounting/checkDuplicateSalaryDate/{salaryDate}", method = RequestMethod.GET)
	public boolean checkDuplicateSalaryDate(@PathVariable String salaryDate) throws Exception{
		
		System.out.println("/accounting/checkDuplicateSalaryDate");
		System.out.println("���� salaryDate ::"+salaryDate);
		salaryDate = salaryDate.substring(0, 4)+"/"+salaryDate.substring(4);
		System.out.println(salaryDate);
		int checkSalaryDate = accountingService.checkDuplicateSalaryDate(salaryDate);
		
		if(checkSalaryDate == 0) {
			return true;
		}else {
			return false;
		}
				
	}
	
	//�޿����� �����ȸ
	@RequestMapping(value = "/accounting/getSalaryBookList", method = RequestMethod.POST)
	public List<SalaryBook> getSalaryBookList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getSalaryBookList");
		System.out.println("search ���� :: "+search);
		
		List<SalaryBook> list = accountingService.getSalaryBookList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//��ǥ ���
	@RequestMapping(value = "/accounting/addStatement", method = RequestMethod.POST)
	public void addStatement(@RequestBody Statement statement) throws Exception{
		
		System.out.println("/accounting/addStatement");
		
		//Ư������ ��ȯ
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; 
		statement.setTradeAmount(statement.getTradeAmount().replaceAll(match, ""));
		
		accountingService.addStatement(statement);
	}
	
	//��ǥ ����ȸ
	@RequestMapping(value = "/accounting/getStatementDetail/{statementNo}", method = RequestMethod.GET)
	public Statement getStatementDetail(@PathVariable String statementNo) throws Exception{
		
		System.out.println("/accounting/getStatementDetail");
		System.out.println("���� statementNo :: "+statementNo);
		
		Statement statement = accountingService.getStatementDetail(statementNo);
		
		return statement;
	}
	
	//��ǥ ����
	@RequestMapping(value = "/accounting/modifyStatement", method = RequestMethod.POST)
	public void modifyStatement(@RequestBody Statement statement) throws Exception{
		
		System.out.println("/accounting/modifyStatement");
		
		//Ư������ ��ȯ
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; 
		statement.setTradeAmount(statement.getTradeAmount().replaceAll(match, ""));
		
		accountingService.modifyStatement(statement);
	}
	
	//��ǥ ������ ����
	@RequestMapping(value = "/accounting/convertStatementUsageStatus", method = RequestMethod.POST)
	public void convertStatementUsageStatus(@RequestBody List<Object> objectList) throws Exception{
		
		System.out.println("/accounting/convertStatementUsageStatus");
		
		
		accountingService.convertStatementUsageStatus(objectList);
	}
	
	//��ǥ �����ȸ
	@RequestMapping(value = "/accounting/getStatementList", method = RequestMethod.POST)
	public List<Statement> getStatementList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getStatementList");
		System.out.println("search ���� :: "+search);
		
		List<Statement> list = accountingService.getStatementList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//ī�� ���
	@RequestMapping(value = "/accounting/addCard", method = RequestMethod.POST)
	public void addCard(@RequestBody Card card) throws Exception{
		
		System.out.println("/accounting/addCard");
		System.out.println("���� ī�� ���� :: "+card);
		System.out.println(card.getCardImageFile());
		
		if(card.getCardImageFile() != null) {
			Map<String, Object> cardImageMap = card.getCardImageFile();
			card.setCardImage(ImageFileUpload.fileUpload(cardImageMap));
		}
	}
	
	//ī�� ����ȸ
	@RequestMapping(value = "/accounting/getCardDetail/{cardRegNo}", method = RequestMethod.GET)
	public Card getCardDetail(@PathVariable String cardRegNo) throws Exception{
		
		System.out.println("/accounting/getCardDetail");
		System.out.println("���� statementNo :: "+cardRegNo);
		
		Card card = accountingService.getCardDetail(cardRegNo);
		
		return card;
	}
	
	//ī�� ����
	@RequestMapping(value = "/accounting/modifyCard", method = RequestMethod.POST)
	public void modifyCard(@RequestBody Card card) throws Exception{
		
		System.out.println("/accounting/modifyCard");
		System.out.println("���� ī�� ���� :: "+card);
		System.out.println(card.getCardImageFile());
		
		if(card.getCardImageFile() != null) {
			Map<String, Object> cardImageMap = card.getCardImageFile();
			card.setCardImage(ImageFileUpload.fileUpload(cardImageMap));
		}
		
		accountingService.modifyCard(card);
	}
	
	//ī�� ������ ����
	@RequestMapping(value = "/accounting/convertCardUsageStatus", method = RequestMethod.POST)
	public void convertCardUsageStatus(@RequestBody List<Object> objectList) throws Exception{
		
		System.out.println("/accounting/convertCardUsageStatus");
		System.out.println("���� ī�� ��ȣ :: "+objectList);
		
		List<Card> cardList = new ArrayList<Card>();
		for(int i = 0; i<objectList.size(); i++) {
			Card card = new Card();
			card.setCardRegNo((String)objectList.get(i));
			card.setCardUsageStatusCodeNo("02");
			cardList.add(card);
		}
		System.out.println(cardList);
		
		accountingService.convertCardUsageStatus(cardList);	
		
	}
	
	//ī�� �����ȸ
	@RequestMapping(value = "/accounting/getCardList", method = RequestMethod.POST)
	public List<Card> getCardList(@RequestBody Search search) throws Exception{
		
		System.out.println("/accounting/getCardList");
		System.out.println("search ���� :: "+search);
		
		List<Card> list = accountingService.getCardList(search);
		
		System.out.println("�ҷ��� list ���� :: "+list);
		
		return list;
	}
	
	//ī���ȣ �ߺ���ȸ
	@RequestMapping(value = "/accounting/checkDuplicateCard/{cardNo}", method = RequestMethod.GET)
	public boolean checkDuplicateCard(@PathVariable String cardNo) throws Exception{
		
		System.out.println("/accounting/checkDuplicateCard");
		System.out.println("���� cardNo ::"+cardNo);
		
		int checkCardNo = accountingService.checkDuplicateCard(cardNo);
		
		if(checkCardNo == 0) {
			return true;
		}else {
			return false;
		}
				
	}
	
	//�޿����� �м�
	@RequestMapping(value = "/accounting/getAnalyzeSalaryBook/{salaryDate}", method = RequestMethod.GET)
	public List<Object> getAnalyzeSalaryBook(@PathVariable String salaryDate) throws Exception{

		System.out.println("/accounting/getAnalyzeSalaryBook");
		System.out.println("���� salaryDate ::"+salaryDate);
		salaryDate = salaryDate.substring(0, 4)+"/"+salaryDate.substring(4);
		System.out.println(salaryDate);
		
		List<SalaryBook> analyzeDepartmentSalary = accountingService.getAnalyzeDepartmentSalary(salaryDate);
		List<SalaryBook> analyzerankSalary = accountingService.getAnalyzeRankSalary(salaryDate);
		
		List<Object> analyzeSalaryBook = new ArrayList<Object>();
		analyzeSalaryBook.add(analyzeDepartmentSalary);
		analyzeSalaryBook.add(analyzerankSalary);
		
		return analyzeSalaryBook;
	}
}
