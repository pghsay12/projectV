//package com.vision.erp.service.productionmanagement.rudwn;
//
//import java.util.List;
//import java.util.Map;
//
//import com.vision.erp.service.domain.InteProduction;
//import com.vision.erp.service.domain.OrderToVendor;
//import com.vision.erp.service.domain.OrderToVendorProduct;
//import com.vision.erp.service.domain.Product;
//
//public interface ProductionManagementDAOrudwn {
//	//��ǰ���
//	public void insertProduct(Product product)throws Exception;
//
//	//��ǰ����
//	public void updateProduct(Product product)throws Exception;
//
//	//��ǰ���º��� (���/���x)
//	public void updateUsageStatus(Product product)throws Exception;
//
//	//��ǰ��Ϻ�����
//	public List<Product> selectProductList() throws Exception;
//
//	//��ǰ�󼼺���
//	public Product selectDetailProduct(String productNo) throws Exception;
//
//	//���ָ��
//	public List<OrderToVendor> selectOrderToVendorList() throws Exception;
//
//	//���ֻ��º���(���ִ��/���ֿϷ�/��������/�������)
//	public void updateOrderToVenCode(OrderToVendor orderToVendor) throws Exception;
//	
//	public void updateOrderToVenCode1(OrderToVendor orderToVendor) throws Exception;
//	
//	public void updateOrderToVenCode2(OrderToVendor orderToVendor) throws Exception;
//
//	//���ּ���ǰ ���º���(�԰���/�԰�Ϸ�)
//	public void updateOrderToVenItemCode(OrderToVendorProduct orderToVendorProduct) throws Exception;
//	
//	public void updateOrderToVenItemCode2(OrderToVendorProduct orderToVendorProduct) throws Exception;
//	
//	//���ּ���ǰ ���º���� ��ǰ�����߰���.���񽺿��� ó���Ұ���
//	public void updateProductCount(Product product) throws Exception;
//
//	//���ּ���ǰ(�󼼺���)
//	public List<OrderToVendorProduct> selectOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct) throws Exception;
//	
//	//���ֿ�û 
//	public String insertOrderToVendor(OrderToVendor orderToVendor) throws Exception;
//
//	//���ֹ�ǰ���(���ֿ�û�� insert all���ؼ� ���)
//	public void insertOrderToVendorProduct(OrderToVendorProduct orderToVendorProduct) throws Exception;
//
//}
