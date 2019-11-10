package com.vision.erp.service.productionmanagement;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.domain.OrderToVendor;
import com.vision.erp.service.domain.OrderToVendorProduct;
import com.vision.erp.service.domain.Product;

public interface ProductionManagementDAO {
	//[����]�ֹ���û-�ֹ������
	public int insertOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception;
	
	//[����]�ֹ���û-�ֹ���ǰ���
	public int insertOrderFromBranchProduct(OrderFromBranchProduct orderFromBranchProduct) throws Exception;
		
	//[����, ����]�ֹ������º���(�ֹ���ҿ�û, �ֹ����Ȯ��, �ֹ��Ϸ�)
	public int updateOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception;
	
	//[����, ����]�ֹ�������Ʈ ��������(�ֹ���ǰ ä����) ������ȣ searchKeyword�� ä���
	public List<OrderFromBranch> selectOrderFromBranchList(Search search) throws Exception;
	
	//[����, ����]�ֹ��� �󼼺���
	public OrderFromBranch selectOrderFromBranchDetail(Search search) throws Exception;
	
	//[����]�ֹ���ǰ ���º���(���ϿϷ�, ���ϴ��, �������)
	public int updateOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception;
	
	//[����]�ֹ���ǰ ��� ���ϿϷ����� Ȯ��, ���ϴ���� ��ǰ���� return
	public int selectOrderFromBranchProduct(String orderFromBranchNo) throws Exception;
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//��ǰ���
	public void insertProduct(Product product)throws Exception;

	//��ǰ����
	public void updateProduct(Product product)throws Exception;

	//��ǰ���º��� (���/���x)
	public void updateUsageStatus(Product product)throws Exception;

	//��ǰ��Ϻ�����
	public List<Product> selectProductList() throws Exception;

	//��ǰ�󼼺���
	public Product selectDetailProduct(String productNo) throws Exception;

	//���ָ��
	public List<OrderToVendor> selectOrderToVendorList() throws Exception;

	//���ֻ��º���(���ִ��/���ֿϷ�/��������/�������)
	public void updateOrderToVenCode(OrderToVendor orderToVendor) throws Exception;
	
	public void updateOrderToVenCode1(OrderToVendor orderToVendor) throws Exception;
	
	public void updateOrderToVenCode2(OrderToVendor orderToVendor) throws Exception;

	//���ּ���ǰ ���º���(�԰���/�԰�Ϸ�)
	public void updateOrderToVenItemCode(OrderToVendorProduct orderToVendorProduct) throws Exception;
	
	public void updateOrderToVenItemCode2(OrderToVendorProduct orderToVendorProduct) throws Exception;
	
	//���ּ���ǰ ���º���� ��ǰ�����߰���.���񽺿��� ó���Ұ���
	public void updateProductCount(Product product) throws Exception;

	//���ּ���ǰ(�󼼺���)
	public List<OrderToVendorProduct> selectOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct) throws Exception;
	
	//���ֿ�û 
	public String insertOrderToVendor(OrderToVendor orderToVendor) throws Exception;

	//���ֹ�ǰ���(���ֿ�û�� insert all���ؼ� ���)
	public void insertOrderToVendorProduct(OrderToVendorProduct orderToVendorProduct) throws Exception;
	
}
