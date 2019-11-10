package test.ace;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.ProductionManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml",
		"classpath:config/common-context.xml"
})

public class ProductManagementServiceImplcodmsTest{

	@Resource(name = "productionManagementServiceImplcodms")
	private ProductionManagementService codmsService;
	
	//�ֹ������
	//@Test
	public void addOrderFromBranchTest() throws Exception{
		OrderFromBranch ob = new OrderFromBranch();
		ob.setOrderFromBranchTotalAmount("1300");
		ob.setBranchNo("b1004");
		ob.setBranchName("�����");
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy/MM/dd");
		String date = format.format (System.currentTimeMillis());
		ob.setOrderDate(date);
		ob.setAccountNo("138294382947");
		List<OrderFromBranchProduct> list = new ArrayList<OrderFromBranchProduct>();
		OrderFromBranchProduct op1 = new OrderFromBranchProduct("10005", "300", null, "3", "900");
		OrderFromBranchProduct op2 = new OrderFromBranchProduct("10006", "400", null, "1", "400");
		list.add(op1);
		list.add(op2);
		ob.setOrderFromBranchProductList(list);
		
		codmsService.addOrderFromBranch(ob);
	}
	
	//�ֹ��� ���� ����
	//@Test
	public void modifyOrderFromBranchStatusTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("10041");
		codmsService.getOrderFromBranchDetail(search);
		OrderFromBranch ob = codmsService.getOrderFromBranchDetail(search);
		ob.setOrderFromBranchStatusCodeNo("05");
		codmsService.modifyOrderFromBranchStatus(ob);
	}
	
	//[����, ����]�ֹ�������Ʈ ��������(�ֹ���ǰ ä����) ������ȣ searchKeyword�� ä���
	//@Test
	public void getOrderFromBranchListTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("b1004");
		List<OrderFromBranch> list = codmsService.getOrderFromBranchList(search);
		for(OrderFromBranch ob : list) {
			System.out.println(ob);
		}
	}
	
	//[����, ����]�ֹ��� �󼼺��� �ֹ�����ȣ searchKeyword�� ä���
	//@Test
	public void getOrderFromBranchDetailTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("10041");
		System.out.println(codmsService.getOrderFromBranchDetail(search));
	}
	
	//[����] �ֹ���ǰ ���º���(���ϴ��01, ���ϿϷ�02, ����öȸ03)
	//�ֹ�����ȣ, ��ǰ��ȣ �־����
	//@Test
	public void modifyOrderFromBranchProductStatusTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("10040");
		codmsService.modifyOrderFromBranchProductStatus(codmsService.getOrderFromBranchDetail(search).getOrderFromBranchProductList().get(0).setOrderFromBranchProductStatusCodeNo("02"));
	}
	
}