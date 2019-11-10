package com.vision.erp.service.productionmanagement.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingDAO;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.domain.OrderToVendor;
import com.vision.erp.service.domain.OrderToVendorProduct;
import com.vision.erp.service.domain.Product;
import com.vision.erp.service.domain.Statement;
import com.vision.erp.service.productionmanagement.ProductionManagementDAO;
import com.vision.erp.service.productionmanagement.ProductionManagementService;

@Service("productionManagementServiceImpl")
public class ProductionManagementServiceImpl implements ProductionManagementService {

//	//field
//	@Resource(name="productionManagementDAOImplcodms")
//	private ProductionManagementDAO productionManagementDAOcodms;
//	
//	@Resource(name="productionManagementDAOImplrudwn")
//	private ProductionManagementDAOrudwn productionManagementDAOrudwn;
	
	@Resource(name = "productionManagementDAOImpl")
	private ProductionManagementDAO productionManagementDAO;
	
	@Resource(name="accountingDAOImpl")
	private AccountingDAO accountingDAO;
	
	//method
	//[����] �ֹ������
	@Override
	public void addOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception {
		
		//���� ���� ����ϰ� �ֹ����� �����ϱ�
		List<OrderFromBranchProduct> finalList = new ArrayList<OrderFromBranchProduct>(); 
		int orderFromBranchTotalAmount = 0;
		for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
			OrderFromBranchProduct resultOp = calculateOrderFromBranchProduct(op);
			finalList.add(resultOp);
			orderFromBranchTotalAmount += Integer.parseInt(resultOp.getOrderFromBranchProductAmount());
		}
		orderFromBranch.setOrderFromBranchProductList(finalList);
		orderFromBranch.setOrderFromBranchTotalAmount(""+orderFromBranchTotalAmount);
		
		//���� ��¥�� �ֹ����� �Է��ϱ�
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
		String date = format.format (System.currentTimeMillis());
		orderFromBranch.setOrderDate(date);
		
		//��ǥ����ϰ� �ֹ����� ��ǥ��ȣ �����ϱ�
		orderFromBranch.setStatementNo(addStatement(orderFromBranch).getStatementNo());
		
		//�ֹ��� ���
		//������ȣ, ��ǥ��ȣ, �Ѱ����� �־����
		productionManagementDAO.insertOrderFromBranch(orderFromBranch);
		
		//�ֹ���ǰ ���
		//�ֹ�����ȣ, ��ǰ��ȣ, ����, ����, �ݾ��� �־����
		for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
			productionManagementDAO.insertOrderFromBranchProduct(op.setOrderFromBranchNo(orderFromBranch.getOrderFromBranchNo()));
		}
		
	}
	
	//[����, ����]�ֹ������º���(�ֹ����01, �ֹ��Ϸ�02, �ֹ�����03, ��ҿ�û04, ���Ȯ��05)
	@Override
	public void modifyOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception {
		//�ֹ������� �����ϱ�
		productionManagementDAO.updateOrderFromBranchStatus(orderFromBranch);
		
		//��ҿ�û�� �ֹ���ǰ ����öȸ�ϱ�
		if(orderFromBranch.getOrderFromBranchStatusCodeNo().equals("04")) {
			for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
				//�ֹ���ǰ����(���ϴ��01, ���ϿϷ�02, ����öȸ03)
				op.setOrderFromBranchProductStatusCodeNo("03");
				productionManagementDAO.updateOrderFromBranchProductStatus(op);
			}
		}
		
		//���Ȯ���� ��ǥ ����ϱ�
		if(orderFromBranch.getOrderFromBranchStatusCodeNo().equals("05")) {
			Statement stmt = accountingDAO.selectStatementDetail(orderFromBranch.getStatementNo());
			stmt.setStatementUsageStatusCodeNo("02");
			accountingDAO.updateStatementUsageStatus(stmt);
		}
	}

	//[����, ����]�ֹ�������Ʈ ��������(�ֹ���ǰ ä����) ������ȣ searchKeyword�� ä���
	@Override
	public List<OrderFromBranch> getOrderFromBranchList(Search search) throws Exception {
		return productionManagementDAO.selectOrderFromBranchList(search);
	}

	//[����, ����]�ֹ��� �󼼺��� �ֹ�����ȣ searchKeyword�� ä���
	@Override
	public OrderFromBranch getOrderFromBranchDetail(Search search) throws Exception {
		// TODO Auto-generated method stub
		return productionManagementDAO.selectOrderFromBranchDetail(search);
	}

	//[����] �ֹ���ǰ ���º���(���ϴ��01, ���ϿϷ�02, ����öȸ03)
	//�ֹ�����ȣ, ��ǰ��ȣ �־����
	@Override
	public void modifyOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		//��ǰ���º����ϱ�
		productionManagementDAO.updateOrderFromBranchProductStatus(orderFromBranchProduct);
		
		if(orderFromBranchProduct.getOrderFromBranchProductStatusCodeNo().equals("02")) {
			//�ֹ����� ��ǰ�� ù ���϶�� �ֹ��� ���¸� �ֹ��������� ����
			changeOrderFromBranchStatus(orderFromBranchProduct, "03");
			//��� ��ǰ ���ϿϷ�� �ֹ������� �ֹ��Ϸ�� ����
			changeOrderFromBranchStatus(orderFromBranchProduct, "02");
		}
		
	}
	
	//���Ͻ� �ֹ������� ����
	private void changeOrderFromBranchStatus(OrderFromBranchProduct orderFromBranchProduct, String orderFromBranchStatusCodeNo) throws Exception{
		//�ֹ���ǰ�� �ش�Ǵ� �ֹ��� ��������
		Search search = new Search();
		search.setSearchKeyword(orderFromBranchProduct.getOrderFromBranchNo());
		OrderFromBranch ob = productionManagementDAO.selectOrderFromBranchDetail(search);
		
		//�ֹ����� �ش�Ǵ� �̹�۹�ǰ ���� Ȯ���ϱ�
		int notDeliveredYet = productionManagementDAO.selectOrderFromBranchProduct(ob.getOrderFromBranchNo());
		
		//if(��� ��ǰ ���ϿϷ�� �ֹ������� �ֹ��Ϸ�� ���� || ù ��ǰ ���Ͻ� �ֹ��� ���� �ֹ��������� ����)
		if(notDeliveredYet==0 || (ob.getOrderFromBranchStatusCodeNo().equals("01")&&orderFromBranchProduct.getOrderFromBranchProductStatusCodeNo().equals("02"))) {
			ob.setOrderFromBranchStatusCodeNo(orderFromBranchStatusCodeNo);
			productionManagementDAO.updateOrderFromBranchStatus(ob);
		}
	}

	//�ֹ���ǰ �ݾ� ����ϱ�
	private OrderFromBranchProduct calculateOrderFromBranchProduct(OrderFromBranchProduct op) throws Exception{
		Product product = productionManagementDAO.selectDetailProduct(op.getProductNo());
		op.setPrice(product.getSalesPrice());
		op.setOrderFromBranchProductAmount(""+(Integer.parseInt(product.getSalesPrice())*Integer.parseInt(op.getOrderFromBranchProductQuantity())));
		System.out.println("CalculateOrderFromBranchProduct() : "+op);
		return op;
	}
	
	//��ǥ ����ϱ�
	private Statement addStatement(OrderFromBranch orderFromBranch) throws Exception {
		Statement statement = new Statement();
		statement.setTradeDate(orderFromBranch.getOrderDate());
		statement.setTradeTargetName(orderFromBranch.getBranchName());
		statement.setStatementCategoryCodeNo("01");
		statement.setStatementDetail("�ֹ�");
		statement.setAccountNo(orderFromBranch.getAccountNo());
		statement.setTradeAmount(orderFromBranch.getOrderFromBranchTotalAmount());
		accountingDAO.insertStatement(statement);
		
		return statement;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	@Override
	public void addProduct(Product product) throws Exception {
		
		String replacePurchasePrice = product.getPurchasePrice();
		String resultPurchasePrice = replacePurchasePrice.replaceAll("," , "");
		String replaceSalesPrice = product.getSalesPrice();
		String resultSalesPrice = replaceSalesPrice.replaceAll("," , "");
		String replaceQuantity = product.getQuantity();
		String resultQuantity = replaceQuantity.replaceAll("," , "");
		
		product.setProductUsageStatusCodeNo("01");
		product.setPurchasePrice(resultPurchasePrice);
		product.setSalesPrice(resultSalesPrice);
		product.setQuantity(resultQuantity);

		productionManagementDAO.insertProduct(product);

	}

	@Override
	public void modifyProduct(Product product) throws Exception {
		productionManagementDAO.updateProduct(product);

	}

	@Override
	public void modifyUsageStatus(Product product) throws Exception {
		productionManagementDAO.updateUsageStatus(product);

	}

	@Override
	public List<Product> getProductList() throws Exception {

		return productionManagementDAO.selectProductList();
	}

	@Override
	public Product getDetailProduct(String productNo) throws Exception {
		
		return productionManagementDAO.selectDetailProduct(productNo);
	}

	@Override
	public List<OrderToVendor> getOrderToVendorList() throws Exception {
		// TODO Auto-generated method stub
		return productionManagementDAO.selectOrderToVendorList();
	}

	//���ִ�⿡�� ��������ϴ� �޼ҵ�+��ǥ�����ڵ庯��
	@Override
	public void modifyOrderToVenCode(Map<String, Object> map) throws Exception {

		OrderToVendor orderToVendor = (OrderToVendor) map.get("orderToVendor");
		Statement statement = (Statement) map.get("statement");
		OrderToVendorProduct orderToVendorProduct = (OrderToVendorProduct) map.get("orderToVendorProduct");

		orderToVendor.setOrderToVenStatusCodeNo("01");
		statement.setStatementUsageStatusCodeNo("02");

		productionManagementDAO.updateOrderToVenCode(orderToVendor);
		productionManagementDAO.updateOrderToVenItemCode2(orderToVendorProduct);
		accountingDAO.updateStatementUsageStatus(statement);

	}

	//���ּ���ǰ ���º���(�԰���/�԰�Ϸ�)
	@Override
	public void modifyOrderToVenItemCode(Map<String, Object> map) throws Exception {

		OrderToVendorProduct orderToVendorProduct = (OrderToVendorProduct) map.get("orderToVendorProduct");
		Product product = (Product) map.get("product");

		OrderToVendor orderToVendor =new OrderToVendor();
		orderToVendor.setOrderToVendorNo(orderToVendorProduct.getOrderToVendorNo());
		orderToVendor.setOrderToVenStatusCodeNo("01");


		//�ش�����ڵ带 �ٲٱ����Ѱ�
		System.out.println("orderToVendorProduct :: " + orderToVendorProduct);
		//�ش繰ǰ��� �ø��� ���ؼ�
		System.out.println("product :: " + product);
		//���ֹ�ǰ�� ��� �԰� �Ǿ����� Ȯ���ϱ����� ����
		//System.out.println("sizeCount :: " + sizeCount);

		//�԰��⸦ �԰�Ϸ��
		productionManagementDAO.updateOrderToVenItemCode(orderToVendorProduct);
		//��ǰ���ø���
		productionManagementDAO.updateProductCount(product);
		//���ִ�⸦ ������������
		productionManagementDAO.updateOrderToVenCode2(orderToVendor);


		int count = 0;
		//�԰�Ϸᰡ �� �Ǿ����� ���������� ���ֿϷ�� �ٲٱ� ���ؼ� ���������°�
		List<OrderToVendorProduct> listOrderSize = productionManagementDAO.selectOrderToVendorDetailList(orderToVendorProduct);
		int sizeCount = listOrderSize.size();

		for(int i=0; i<listOrderSize.size(); i++) {

			if(listOrderSize.get(i).getOrderToVendorProductStatusCodeNo().equals("02")) {
				count += 1;				
				if(count == sizeCount) {
					//���������� ���ֿϷ��
					productionManagementDAO.updateOrderToVenCode1(orderToVendor);
				} 
			}
		}
	}

	@Override
	public List<OrderToVendorProduct> getOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct)
			throws Exception {
		// TODO Auto-generated method stub
		return productionManagementDAO.selectOrderToVendorDetailList(orderToVendorProduct);
	}

	@Override
	public String addOrderToVendor(Map<String, Object> map) throws Exception {

		Statement statement = (Statement) map.get("statement");
		OrderToVendor orderToVendor = (OrderToVendor) map.get("orderToVendor");
		List<OrderToVendorProduct> orderToVendorProducts = (List<OrderToVendorProduct>) map.get("productList");

		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");

		//�ŷ�ó���ߺ��ȵǰ�
		String addVendorName = "";
		for(int i = 0; i < orderToVendorProducts.size(); i++) {
			String vendorName = orderToVendorProducts.get(i).getVendorName();
			if(-1 == addVendorName.indexOf(vendorName)) {
				addVendorName += vendorName + ", ";
			}
		}	
		addVendorName=addVendorName.substring(0, addVendorName.length()-2);
		
		System.out.println("addVendorName :: " + addVendorName);
		
		String date = format.format (System.currentTimeMillis());
		statement.setTradeDate(date);
		statement.setTradeTargetName(addVendorName);
		statement.setStatementCategoryCodeNo("02");
		statement.setStatementDetail("����");
		statement.setAccountNo("1002384718373");
		System.out.println("statement :: " + statement);
		//��ǥ�� ���
		accountingDAO.insertStatement(statement);

		String statementNo = statement.getStatementNo();

		orderToVendor.setStatementNo(statementNo);

		//���ּ� ���
		orderToVendor.setOrderToVenStatusCodeNo("01");
		productionManagementDAO.insertOrderToVendor(orderToVendor);

		String orderToVendorNo =  orderToVendor.getOrderToVendorNo();

		for(int i = 0; i < orderToVendorProducts.size();i++) {
			OrderToVendorProduct orderToVendorProduct = orderToVendorProducts.get(i);
			orderToVendorProduct.setOrderToVendorNo(orderToVendorNo);
			orderToVendorProduct.setOrderToVendorProductStatusCodeNo("01");
			productionManagementDAO.insertOrderToVendorProduct(orderToVendorProduct);
		}

		return null;
	}

}
