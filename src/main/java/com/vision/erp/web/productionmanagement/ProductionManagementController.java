package com.vision.erp.web.productionmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingService;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.InteProduction;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.domain.OrderToVendor;
import com.vision.erp.service.domain.OrderToVendorProduct;
import com.vision.erp.service.domain.Product;
import com.vision.erp.service.domain.Statement;
import com.vision.erp.service.domain.Vendor;
import com.vision.erp.service.productionmanagement.ProductionManagementService;

@RestController
public class ProductionManagementController {

	//field
//	@Resource(name = "productionManagementServiceImplcodms")
//	private ProductionManagementService codmsService;
//	
//	@Resource(name = "productionManagementServiceImplrudwn")
//	private ProductionManagementServicerudwn rudwnService;
	
	@Resource(name = "productionManagementServiceImpl")
	private ProductionManagementService productionManagementService;
	
	@Resource(name = "accountingServiceImpl")
	private AccountingService accountingService;


	//constructor
	public ProductionManagementController() {
		super();
		// TODO Auto-generated constructor stub
	}

	//method
	//[�ֹ��������ȸ] - �ֹ��� �����ȸ(����, ����) SearchKeyword�� ������ȣ
	@RequestMapping(value="/pm/getOrderFromBranchList")
	public List<OrderFromBranch> getOrderFromBranchList(@RequestBody Search search) throws Exception{
		return productionManagementService.getOrderFromBranchList(search);
	}
	
	//[�ֹ��������ȸ] - �ֹ��� ����ȸ(����, ����) SearchKeyword�� �ֹ�����ȣ
	@RequestMapping(value="/pm/getOrderFromBranchDetail")
	public OrderFromBranch getOrderFromBranchDetail(@RequestBody Search search) throws Exception{
		return productionManagementService.getOrderFromBranchDetail(search);
	}
	
	//[�ֹ��������ȸ] - �ֹ����/���Ȯ��(����, ����) 
	//�ֹ�����ȣ, �ֹ��������ڵ� (�ֹ����01, �ֹ��Ϸ�02, �ֹ�����03, ��ҿ�û04, ���Ȯ��05) �ʿ�
	@RequestMapping(value="/pm/modifyOrderFromBranchStatus")
	public void modifyOrderFromBranchStatus(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
		productionManagementService.modifyOrderFromBranchStatus(orderFromBranch);
	}
	
	//[�ֹ���û] - �غ�ȭ�� ���� : ���¹�ȣ ��������, ��ǰ��� ��������
	@RequestMapping(value="/pm/addOrderFromBranchPreparing")
	public Map<String, List> addOrderFromBranchPreparing() throws Exception{
		Map<String, List> map = new HashMap<String, List>();
		//��ǰ��� ��������
//		map.put("productList", rudwnService.getProductList());
		
		//���¹�ȣ ��������
//		Search search = new Search();
		//���� ���ó 02�ֹ�
//		search.setSearchKeyword("02");
//		map.put("accountList", accountingService.getAccountList(search));
		
		return map;
	}
	
	//[�ֹ���û] - �ֹ��ϱ�
	//branchNo, orderDate, orderFromBranchProductList(productNo, orderFromBranchProductQuantity) �ʿ�
	@RequestMapping(value="/pm/addOrderFromBranch")
	public void addOrderFromBranch(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
		productionManagementService.addOrderFromBranch(orderFromBranch);
	}
	
	//[�ֹ�������ȸ] - �ֹ���ǰ ���º���(���ϿϷ�02)
	//orderFromBranchNo, productNo �ʿ�
	@RequestMapping(value="/pm/modifyOrderFromBranchProductStatus")
	public void modifyOrderFromBranchProductStatus(@RequestBody OrderFromBranchProduct orderFromBranchProduct) throws Exception{
		productionManagementService.modifyOrderFromBranchProductStatus(orderFromBranchProduct);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//��� ���ֿ�û�Ҷ� ���°���.
	//ResponseEntity<T> ���°�200�̳� 400 �� ����� �����ش�
	@RequestMapping(value="/pm/addOrderPreparing",method=RequestMethod.GET)
	public List<Account> insertOrderFromBranchPreparing() throws Exception{
		
		List<Account> list = new ArrayList<Account>();
		Search search = new Search();
	
		search.setSearchCondition("01");
		list =  accountingService.getAccountList(search);

		return list;
	}

	//��ǰ����ҋ� 
	@RequestMapping(value="/pm/addProductPreparing",method=RequestMethod.GET)
	public List<Vendor> addProductPreparing() throws Exception{
		
		List<Vendor> list = new ArrayList<Vendor>();
		Search search = new Search();
		
		search.setSearchCondition("01");
	    list =  accountingService.getVendorList(search);

		return list;
		}
	
	@RequestMapping(value = "/pm/addProduct",method=RequestMethod.POST)
	public void addProduct(@RequestBody Product product)throws Exception{
		System.out.println("addProduct :: " + product);
		productionManagementService.addProduct(product);
	}

	@RequestMapping(value = "/pm/modifyProduct",method=RequestMethod.POST)
	public void modifyProduct(@RequestBody Product product)throws Exception{
		productionManagementService.modifyProduct(product);
	}

	@RequestMapping(value = "/pm/modifyUsageStatus",method=RequestMethod.POST)
	public void modifyUsageStatus(@RequestBody Product product)throws Exception{
		productionManagementService.modifyUsageStatus(product);
	}

	@RequestMapping(value = "/pm/getProductList",method=RequestMethod.GET)
	public List<Product> getProductList() throws Exception{
		
		List<Product> list 
		= (List<Product>)productionManagementService.getProductList();

		return list;
	}


	@RequestMapping(value = "/pm/getOrderToVendorList",method=RequestMethod.GET)
	public List<OrderToVendor> getOrderToVendorList() throws Exception{
		
		List<OrderToVendor> list 
		= (List<OrderToVendor>)productionManagementService.getOrderToVendorList();

		return list;
	}

	@RequestMapping(value = "/pm/modifyOrderToVenCode/{statementNo}/{orderToVendorNo}",method=RequestMethod.GET)
	public void modifyOrderToVenCode(@PathVariable(value="statementNo") String statementNo, @PathVariable String orderToVendorNo) throws Exception {
	
		Map<String, Object> map = new HashMap<String, Object>();
		OrderToVendor orderToVendor = new OrderToVendor();
		Statement statement = new Statement();
		OrderToVendorProduct orderToVendorProduct = new OrderToVendorProduct();
		
		orderToVendorProduct.setOrderToVendorNo(orderToVendorNo);
		orderToVendor.setOrderToVendorNo(orderToVendorNo);
		statement.setStatementNo(statementNo);
		
		map.put("orderToVendor", orderToVendor);
		map.put("statement", statement);
		map.put("orderToVendorProduct", orderToVendorProduct);
		
		productionManagementService.modifyOrderToVenCode(map);
	}


	@RequestMapping(value = "/pm/getOrderToVendorDetailList",method=RequestMethod.POST)
	public List<OrderToVendorProduct> getOrderToVendorDetailList(@RequestBody OrderToVendorProduct orderToVendorProduct) throws Exception{

		List<OrderToVendorProduct> list 
		= (List<OrderToVendorProduct>)productionManagementService.getOrderToVendorDetailList(orderToVendorProduct);

		return list;
	}

	
	@RequestMapping(value = "/pm/modifyOrderToVenItemCode",method=RequestMethod.POST)
	public void modifyOrderToVenItemCode(@RequestBody OrderToVendorProduct orderToVendorProduct) throws Exception{

		Product product = new Product();

		product.setProductNo(orderToVendorProduct.getProductNo());
		product.setQuantity(orderToVendorProduct.getQuantity());
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("product", product);
		map.put("orderToVendorProduct", orderToVendorProduct);
		
		productionManagementService.modifyOrderToVenItemCode(map);
	}
	
	@RequestMapping(value = "/pm/addOrderToVendor",method=RequestMethod.POST)
	public void insertOrderToVendor(@RequestBody InteProduction inteProduction) throws Exception {
		
		
		OrderToVendor orderToVendor = new OrderToVendor();
		Statement statement = new Statement();
		List<OrderToVendorProduct> productList = inteProduction.getOrderToVendorProduct();
		Map<String, Object> map = new HashMap<String, Object>();

		statement.setTradeAmount(inteProduction.getTotalAmount());
		
		orderToVendor.setTotalAmount(inteProduction.getTotalAmount());

		map.put("statement", statement);
		map.put("orderToVendor", orderToVendor);
		map.put("productList", productList);

		productionManagementService.addOrderToVendor(map);
	}
	
	@RequestMapping(value ="/pm/getProduct/{productNo}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable String productNo) throws Exception {
		return productionManagementService.getDetailProduct(productNo);
	}
}
