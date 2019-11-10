//package com.vision.erp.web.productionmanagementcodms;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vision.erp.common.Search;
//import com.vision.erp.service.accounting.AccountingService;
//import com.vision.erp.service.domain.OrderFromBranch;
//import com.vision.erp.service.domain.OrderFromBranchProduct;
//import com.vision.erp.service.productionmanagement.codms.ProductionManagementService;
//import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementServicerudwn;
//
//@RestController
//public class ProductionManagementControllercodms {
//
//	//field
//	@Resource(name = "productionManagementServiceImplcodms")
//	private ProductionManagementService codmsService;
//	
//	@Resource(name = "productionManagementServiceImplrudwn")
//	private ProductionManagementServicerudwn rudwnService;
//	
//	@Resource(name = "accountingServiceImpl")
//	private AccountingService accountingService;
//
//
//	//constructor
//	public ProductionManagementControllercodms() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	//method
//	//[�ֹ��������ȸ] - �ֹ��� �����ȸ(����, ����) SearchKeyword�� ������ȣ
//	@RequestMapping(value="/pm/getOrderFromBranchList")
//	public List<OrderFromBranch> getOrderFromBranchList(@RequestBody Search search) throws Exception{
//		return codmsService.getOrderFromBranchList(search);
//	}
//	
//	//[�ֹ��������ȸ] - �ֹ��� ����ȸ(����, ����) SearchKeyword�� �ֹ�����ȣ
//	@RequestMapping(value="/pm/getOrderFromBranchDetail")
//	public OrderFromBranch getOrderFromBranchDetail(@RequestBody Search search) throws Exception{
//		return codmsService.getOrderFromBranchDetail(search);
//	}
//	
//	//[�ֹ��������ȸ] - �ֹ����/���Ȯ��(����, ����) 
//	//�ֹ�����ȣ, �ֹ��������ڵ� (�ֹ����01, �ֹ��Ϸ�02, �ֹ�����03, ��ҿ�û04, ���Ȯ��05) �ʿ�
//	@RequestMapping(value="/pm/modifyOrderFromBranchStatus")
//	public void modifyOrderFromBranchStatus(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
//		codmsService.modifyOrderFromBranchStatus(orderFromBranch);
//	}
//	
//	//[�ֹ���û] - �غ�ȭ�� ���� : ���¹�ȣ ��������, ��ǰ��� ��������
//	@RequestMapping(value="/pm/addOrderFromBranchPreparing")
//	public Map<String, List> addOrderFromBranchPreparing() throws Exception{
//		Map<String, List> map = new HashMap<String, List>();
//		//��ǰ��� ��������
////		map.put("productList", rudwnService.getProductList());
//		
//		//���¹�ȣ ��������
////		Search search = new Search();
//		//���� ���ó 02�ֹ�
////		search.setSearchKeyword("02");
////		map.put("accountList", accountingService.getAccountList(search));
//		
//		return map;
//	}
//	
//	//[�ֹ���û] - �ֹ��ϱ�
//	//branchNo, orderDate, orderFromBranchProductList(productNo, orderFromBranchProductQuantity) �ʿ�
//	@RequestMapping(value="/pm/addOrderFromBranch")
//	public void addOrderFromBranch(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
//		codmsService.addOrderFromBranch(orderFromBranch);
//	}
//	
//	//[�ֹ�������ȸ] - �ֹ���ǰ ���º���(���ϿϷ�02)
//	//orderFromBranchNo, productNo �ʿ�
//	@RequestMapping(value="/pm/modifyOrderFromBranchProductStatus")
//	public void modifyOrderFromBranchProductStatus(@RequestBody OrderFromBranchProduct orderFromBranchProduct) throws Exception{
//		codmsService.modifyOrderFromBranchProductStatus(orderFromBranchProduct);
//	}
//}
