//package com.vision.erp.service.productionmanagement.rudwn.impl;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.vision.erp.service.accounting.AccountingDAO;
//import com.vision.erp.service.domain.OrderToVendor;
//import com.vision.erp.service.domain.OrderToVendorProduct;
//import com.vision.erp.service.domain.Product;
//import com.vision.erp.service.domain.Statement;
//import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementDAOrudwn;
//import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementServicerudwn;
//
//@Service("productionManagementServiceImplrudwn")
//public class ProductionManagementServiceImplrudwn implements ProductionManagementServicerudwn {
//
//	@Autowired
//	@Qualifier("productionManagementDAOImplrudwn")
//	private ProductionManagementDAOrudwn productionDAO;
//
//
//	@Autowired
//	@Qualifier("accountingDAOImpl")
//	private AccountingDAO accountingDAO;
//
//
//
//	@Override
//	public void addProduct(Product product) throws Exception {
//		
//		String replacePurchasePrice = product.getPurchasePrice();
//		String resultPurchasePrice = replacePurchasePrice.replaceAll("," , "");
//		String replaceSalesPrice = product.getSalesPrice();
//		String resultSalesPrice = replaceSalesPrice.replaceAll("," , "");
//		String replaceQuantity = product.getQuantity();
//		String resultQuantity = replaceQuantity.replaceAll("," , "");
//		
//		product.setProductUsageStatusCodeNo("01");
//		product.setPurchasePrice(resultPurchasePrice);
//		product.setSalesPrice(resultSalesPrice);
//		product.setQuantity(resultQuantity);
//
//		productionDAO.insertProduct(product);
//
//	}
//
//	@Override
//	public void modifyProduct(Product product) throws Exception {
//		productionDAO.updateProduct(product);
//
//	}
//
//	@Override
//	public void modifyUsageStatus(Product product) throws Exception {
//		productionDAO.updateUsageStatus(product);
//
//	}
//
//	@Override
//	public List<Product> getProductList() throws Exception {
//
//		return productionDAO.selectProductList();
//	}
//
//	@Override
//	public Product getDetailProduct(String productNo) throws Exception {
//		
//		return productionDAO.selectDetailProduct(productNo);
//	}
//
//	@Override
//	public List<OrderToVendor> getOrderToVendorList() throws Exception {
//		// TODO Auto-generated method stub
//		return productionDAO.selectOrderToVendorList();
//	}
//
//	//���ִ�⿡�� ��������ϴ� �޼ҵ�+��ǥ�����ڵ庯��
//	@Override
//	public void modifyOrderToVenCode(Map<String, Object> map) throws Exception {
//
//		OrderToVendor orderToVendor = (OrderToVendor) map.get("orderToVendor");
//		Statement statement = (Statement) map.get("statement");
//		OrderToVendorProduct orderToVendorProduct = (OrderToVendorProduct) map.get("orderToVendorProduct");
//
//		orderToVendor.setOrderToVenStatusCodeNo("01");
//		statement.setStatementUsageStatusCodeNo("02");
//
//		productionDAO.updateOrderToVenCode(orderToVendor);
//		productionDAO.updateOrderToVenItemCode2(orderToVendorProduct);
//		accountingDAO.updateStatementUsageStatus(statement);
//
//	}
//
//	//���ּ���ǰ ���º���(�԰���/�԰�Ϸ�)
//	@Override
//	public void modifyOrderToVenItemCode(Map<String, Object> map) throws Exception {
//
//		OrderToVendorProduct orderToVendorProduct = (OrderToVendorProduct) map.get("orderToVendorProduct");
//		Product product = (Product) map.get("product");
//
//		OrderToVendor orderToVendor =new OrderToVendor();
//		orderToVendor.setOrderToVendorNo(orderToVendorProduct.getOrderToVendorNo());
//		orderToVendor.setOrderToVenStatusCodeNo("01");
//
//
//		//�ش�����ڵ带 �ٲٱ����Ѱ�
//		System.out.println("orderToVendorProduct :: " + orderToVendorProduct);
//		//�ش繰ǰ��� �ø��� ���ؼ�
//		System.out.println("product :: " + product);
//		//���ֹ�ǰ�� ��� �԰� �Ǿ����� Ȯ���ϱ����� ����
//		//System.out.println("sizeCount :: " + sizeCount);
//
//		//�԰��⸦ �԰�Ϸ��
//		productionDAO.updateOrderToVenItemCode(orderToVendorProduct);
//		//��ǰ���ø���
//		productionDAO.updateProductCount(product);
//		//���ִ�⸦ ������������
//		productionDAO.updateOrderToVenCode2(orderToVendor);
//
//
//		int count = 0;
//		//�԰�Ϸᰡ �� �Ǿ����� ���������� ���ֿϷ�� �ٲٱ� ���ؼ� ���������°�
//		List<OrderToVendorProduct> listOrderSize = productionDAO.selectOrderToVendorDetailList(orderToVendorProduct);
//		int sizeCount = listOrderSize.size();
//
//		for(int i=0; i<listOrderSize.size(); i++) {
//
//			if(listOrderSize.get(i).getOrderToVendorProductStatusCodeNo().equals("02")) {
//				count += 1;				
//				if(count == sizeCount) {
//					//���������� ���ֿϷ��
//					productionDAO.updateOrderToVenCode1(orderToVendor);
//				} 
//			}
//		}
//	}
//
//	@Override
//	public List<OrderToVendorProduct> getOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return productionDAO.selectOrderToVendorDetailList(orderToVendorProduct);
//	}
//
//	@Override
//	public String addOrderToVendor(Map<String, Object> map) throws Exception {
//
//		Statement statement = (Statement) map.get("statement");
//		OrderToVendor orderToVendor = (OrderToVendor) map.get("orderToVendor");
//		List<OrderToVendorProduct> orderToVendorProducts = (List<OrderToVendorProduct>) map.get("productList");
//
//		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
//
//		//�ŷ�ó���ߺ��ȵǰ�
//		String addVendorName = "";
//		for(int i = 0; i < orderToVendorProducts.size(); i++) {
//			String vendorName = orderToVendorProducts.get(i).getVendorName();
//			if(-1 == addVendorName.indexOf(vendorName)) {
//				addVendorName += vendorName + ", ";
//			}
//		}	
//		addVendorName=addVendorName.substring(0, addVendorName.length()-2);
//		
//		System.out.println("addVendorName :: " + addVendorName);
//		
//		String date = format.format (System.currentTimeMillis());
//		statement.setTradeDate(date);
//		statement.setTradeTargetName(addVendorName);
//		statement.setStatementCategoryCodeNo("02");
//		statement.setStatementDetail("����");
//		statement.setAccountNo("1002384718373");
//		System.out.println("statement :: " + statement);
//		//��ǥ�� ���
//		accountingDAO.insertStatement(statement);
//
//		String statementNo = statement.getStatementNo();
//
//		orderToVendor.setStatementNo(statementNo);
//
//		//���ּ� ���
//		orderToVendor.setOrderToVenStatusCodeNo("01");
//		productionDAO.insertOrderToVendor(orderToVendor);
//
//		String orderToVendorNo =  orderToVendor.getOrderToVendorNo();
//
//		for(int i = 0; i < orderToVendorProducts.size();i++) {
//			OrderToVendorProduct orderToVendorProduct = orderToVendorProducts.get(i);
//			orderToVendorProduct.setOrderToVendorNo(orderToVendorNo);
//			orderToVendorProduct.setOrderToVendorProductStatusCodeNo("01");
//			productionDAO.insertOrderToVendorProduct(orderToVendorProduct);
//		}
//
//		return null;
//	}
//
//}
