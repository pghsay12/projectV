package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Code;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.impl.ProductionManagementDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class ProductManagementDAOImplcodmsTest{

	@Resource(name = "productionManagementDAOImplcodms")
	private ProductionManagementDAOImpl codmsDAO;
	
	//[����]�ֹ���û-�ֹ������
	//@Test
	public void insertOrderFromBranchTest() throws Exception{
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		int i = codmsDAO.insertOrderFromBranch(ofb);
		System.out.println(i+", "+ofb.getOrderFromBranchNo());
	}
	
	
	//[����]�ֹ���û-�ֹ���ǰ���
	//@Test
	public void insertOrderFromBranchProductTest() throws Exception{
		OrderFromBranchProduct ofbp = new OrderFromBranchProduct("10005", "300", "10005", "2", "600");
		int i = codmsDAO.insertOrderFromBranchProduct(ofbp);
		System.out.println(i);
	}
	
	
	//[����, ����]�ֹ������º���(�ֹ���ҿ�û, �ֹ����Ȯ��, �ֹ��Ϸ�)
	//@Test
	public void updateOrderFromBranchStatusTest() throws Exception{
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		ofb.setOrderFromBranchNo("10005");
		ofb.setOrderFromBranchStatusCodeNo("04");
		int i = codmsDAO.updateOrderFromBranchStatus(ofb);
		System.out.println(i);
	}
	
	//[����, ����]�ֹ�������Ʈ ��������(�ֹ���ǰ ä����) ������ȣ searchKeyword�� ä���
	//@Test
	public void selectOrderFromBranchTest() throws Exception{
		Search search = new Search();
		List<OrderFromBranch> list = codmsDAO.selectOrderFromBranchList(search);
		for(OrderFromBranch ofb : list) {
			System.out.println(ofb);
		}
	}
	
	//[����]�ֹ���ǰ ���º���(���ϿϷ�, ���ϴ��, �������)
	//@Test
	public void updateOrderFromBranchProductStatusTest() throws Exception{
		OrderFromBranchProduct ofbp = new OrderFromBranchProduct("10005", "300", "10005", "2", "600");
		ofbp.setNumbering("10001");
		ofbp.setOrderFromBranchProductStatusCodeNo("03");
		int i = codmsDAO.updateOrderFromBranchProductStatus(ofbp);
		System.out.println(i);
	}
	
	
	//[����]�ֹ���ǰ ��� ���ϿϷ����� Ȯ��, ���ϴ���� ��ǰ���� return
	//@Test
	public void selectOrderFromBranchProduct() throws Exception {
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		ofb.setOrderFromBranchNo("10005");
		int i = codmsDAO.selectOrderFromBranchProduct(ofb.getOrderFromBranchNo());
		System.out.println("���ϴ���� ��ǰ���� : "+i);
	}
	
	
}