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
//public interface ProductionManagementServicerudwn {
//
//	//��ǰ���
//	public void addProduct(Product product)throws Exception;
//
//	//��ǰ����
//	public void modifyProduct(Product product)throws Exception;
//
//	//��ǰ���º��� (���/���x)
//	public void modifyUsageStatus(Product product)throws Exception;
//
//	//��ǰ��Ϻ�����
//	public List<Product> getProductList() throws Exception;
//
//	//��ǰ�󼼺���
//	public Product getDetailProduct(String productNo) throws Exception;
//
//	//���ָ��
//	public List<OrderToVendor> getOrderToVendorList() throws Exception;
//
//	//���ֻ��º���(���ִ��/���ֿϷ�/��������/�������)
//	public void modifyOrderToVenCode(Map<String, Object> map) throws Exception;
//
//	//���ּ���ǰ ���º���(�԰���/�԰�Ϸ�)
//	public void modifyOrderToVenItemCode(Map<String, Object> map) throws Exception;
//	
//
//	//���ּ���ǰ(�󼼺���)
//	/**
//	 * ���ּ���ǰ�󼼺�����
//	 * @param orderToVendorProduct �ŷ�ó��ǰ�� �����ֱ����� 
//	 * @return	����Ʈ	
//	 * @throws Exception ����
//	 */
//	public List<OrderToVendorProduct> getOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct) throws Exception;
//
//	//���ֿ�û 
//	public String addOrderToVendor(Map<String, Object> map) throws Exception;
//
//}
