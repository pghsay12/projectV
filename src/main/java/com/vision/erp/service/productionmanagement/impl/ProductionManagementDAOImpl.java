package com.vision.erp.service.productionmanagement.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.domain.OrderToVendor;
import com.vision.erp.service.domain.OrderToVendorProduct;
import com.vision.erp.service.domain.Product;
import com.vision.erp.service.productionmanagement.ProductionManagementDAO;

@Repository("productionManagementDAOImpl")
public class ProductionManagementDAOImpl implements ProductionManagementDAO {
	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	//[����]�ֹ���û-�ֹ������
	@Override
	public int insertOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("OrderFromBranchMapper.insertOrderFromBranch", orderFromBranch);
	}

	//[����]�ֹ���û-�ֹ���ǰ���
	@Override
	public int insertOrderFromBranchProduct(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("OrderFromBranchMapper.insertOrderFromBranchProduct", orderFromBranchProduct);
	}

	//[����, ����]�ֹ������º���(�ֹ���ҿ�û, �ֹ����Ȯ��, �ֹ��Ϸ�)
	@Override
	public int updateOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("OrderFromBranchMapper.updateOrderFromBranchStatus", orderFromBranch);
	}

	//[����, ����]�ֹ�������Ʈ ��������(�ֹ���ǰ ä����) ������ȣ searchKeyword�� ä���
	@Override
	public List<OrderFromBranch> selectOrderFromBranchList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderFromBranchMapper.selectOrderFromBranch", search);
	}

	//[����]�ֹ���ǰ ���º���(���ϿϷ�, ���ϴ��, �������)
	@Override
	public int updateOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("OrderFromBranchMapper.updateOrderFromBranchProductStatus", orderFromBranchProduct);
	}

	//[����]�ֹ���ǰ ��� ���ϿϷ����� Ȯ��, ���ϴ���� ��ǰ���� return
	@Override
	public int selectOrderFromBranchProduct(String orderFromBranchNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderFromBranchMapper.selectOrderFromBranchProduct", orderFromBranchNo).size();
	}

	//[����, ����]�ֹ��� �󼼺���
	@Override
	public OrderFromBranch selectOrderFromBranchDetail(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("OrderFromBranchMapper.selectOrderFromBranchDetail", search);
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void insertProduct(Product product) throws Exception {
		sqlSession.insert("ProductMapper.insertProduct", product);

	}

	@Override
	public Product selectDetailProduct(String productNo) throws Exception {

		return sqlSession.selectOne("ProductMapper.selectDetailProduct", productNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);

	}

	@Override
	public void updateUsageStatus(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateUsageStatus", product);

	}

	@Override
	public List<Product> selectProductList() throws Exception {

		return sqlSession.selectList("ProductMapper.selectproductList");
	}

	@Override
	public List<OrderToVendor> selectOrderToVendorList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderToVendorMapper.selectOrderToVendorList");
	}

	@Override
	public void updateOrderToVenCode(OrderToVendor orderToVendor) throws Exception {

		sqlSession.update("OrderToVendorMapper.modifyOrderToVenCode",orderToVendor);

	}
	
	@Override
	public void updateOrderToVenCode1(OrderToVendor orderToVendor) throws Exception {

		sqlSession.update("OrderToVendorMapper.modifyOrderToVenCode1",orderToVendor);

	}
	
	@Override
	public void updateOrderToVenCode2(OrderToVendor orderToVendor) throws Exception {
		sqlSession.update("OrderToVendorMapper.modifyOrderToVenCode2",orderToVendor);

	}
	
	

	@Override
	public void updateOrderToVenItemCode(OrderToVendorProduct orderToVendorProduct) throws Exception {
		sqlSession.update("OrderToVendorProductMapper.modifyOrderToVenItemCode",orderToVendorProduct);

	}
	
	@Override
	public void updateOrderToVenItemCode2(OrderToVendorProduct orderToVendorProduct) throws Exception {
		System.out.println("����� ���ӳ� @@@@@@@@@@@");
		System.out.println("orderToVendorProduct �� :::::::; " + orderToVendorProduct);
		sqlSession.update("OrderToVendorProductMapper.modifyOrderToVenItemCode2",orderToVendorProduct);

	}
	
	

	@Override
	public void updateProductCount(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProductCount", product);

	}

	@Override
	public List<OrderToVendorProduct> selectOrderToVendorDetailList(OrderToVendorProduct orderToVendorProduct) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderToVendorProductMapper.orderToVendorDetailList",orderToVendorProduct);
	}

	//���ֿ�û
	@Override
	public String insertOrderToVendor(OrderToVendor orderToVendor) throws Exception {
		
		
		sqlSession.insert("OrderToVendorMapper.insertOrderToVendor", orderToVendor);

		return orderToVendor.getStatementNo();
	}

	//���ֹ�ǰ���
	@Override
	public void insertOrderToVendorProduct(OrderToVendorProduct orderToVendorProduct) throws Exception {
		System.out.println("DAO :: "+orderToVendorProduct);
		// TODO Auto-generated method stub
		sqlSession.insert("OrderToVendorProductMapper.insertOrderToVenItem",orderToVendorProduct);
	}
	
	
}
