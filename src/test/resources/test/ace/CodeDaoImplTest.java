package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.domain.Code;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class CodeDaoImplTest{

	@Resource(name = "codeDAOImpl")
	private CodeDAO codeDAO;
	
	//�׷��ڵ帮��Ʈ ��ü ��������
	//@Test
	public void selectGroupCodeListTest() throws Exception {
		List<Code> list = codeDAO.selectGroupCodeList(null);
		for(Code code : list) {
			System.out.println(code);
		}
	}
	
	//�ڵ� ���
	//@Test
	public void insertCodeTest() throws Exception{
		Code code = new Code("test", "�׽�Ʈ", "01", "�׽�Ʈ01", "Y");
		int result = codeDAO.insertCode(code);
		System.out.println(result);
	}
	
	//�׷��ڵ忡 �ش��ϴ� �ڵ帮��Ʈ ��������
	//@Test
	public void selectCodeListTest() throws Exception{
		Search search = new Search();
		search.setSearchCondition("0");
		search.setSearchKeyword("depart");
		List<Code> list = codeDAO.selectCodeList(search);
		for(Code code : list) {
			System.out.println(code);
		}
	}
	
	//�ڵ� ����(�ڵ�� ����)
	//@Test
	public void updateCodeTest() throws Exception{
		Code code = new Code("test", "�׽�Ʈ", "01", "�׽�Ʈ01����", "Y");
		int result = codeDAO.updateCode(code);
		System.out.println(result);
	}
	
	//�ڵ� �ϳ��� ��������(�ڵ�� �ߺ�Ȯ��)
	//@Test
	public void selectDuplicateCodeNoTest() throws Exception{
		Code code = new Code("test", "�׽�Ʈ", "01", "�׽�Ʈ01����", "Y");
		Code resultCode = codeDAO.selectDuplicateCodeNo(code);
		System.out.println(resultCode);
	}
}