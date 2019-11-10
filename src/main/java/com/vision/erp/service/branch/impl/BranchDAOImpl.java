package com.vision.erp.service.branch.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.service.branch.BranchDAO;
import com.vision.erp.service.domain.BranchDailySales;
import com.vision.erp.service.domain.SalesMenu;
import com.vision.erp.service.domain.SalesProduct;

@Repository("branchDAOImpl")
public class BranchDAOImpl implements BranchDAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public void insertDailySales(List<SalesProduct> salesProductList) throws Exception {
		
		sqlSession.insert("SalesProductMapper.insertSalesProduct", salesProductList);
	}

	@Override
	public List<SalesProduct> selectDailySalesDetail(String branchNo, String salesDate) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("branchNo", branchNo);
		map.put("salesDate", salesDate);
		return sqlSession.selectList("SalesProductMapper.selectDailySalesDetail", map);
	}

	@Override
	public List<BranchDailySales> selectDailySalesList(String branchNo) throws Exception {
		return sqlSession.selectList("SalesProductMapper.selectBranchDailySalesList", branchNo);
	}

	@Override
	public void updateSalesProduct(List<SalesProduct> salesProductList) throws Exception {
		sqlSession.update("SalesProductMapper.updateSalesProduct", salesProductList);
	}

	@Override
	public List<SalesMenu> selectSalesMenuList() throws Exception {
		return sqlSession.selectList("SalesMenuMapper.selectMenuList");
	}

	@Override
	public List<BranchDailySales> selectDuplicateSalesDateByBranch(BranchDailySales branchDailySales) throws Exception {
		return sqlSession.selectList("SalesProductMapper.selectDuplicateSalesDateByBranch", branchDailySales);
	}

	
}
