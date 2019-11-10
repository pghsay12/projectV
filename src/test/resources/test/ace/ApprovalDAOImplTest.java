package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalDAO;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class ApprovalDAOImplTest{

	@Resource(name = "approvalDAOImpl")
	private ApprovalDAO approvalDAO;
	
	/////////////////////���缭���//////////////////////////
	//���缭��� ����Ʈ ��������
	//@Test
	public void selectApprovalFormListTest() throws Exception{
		List<ApprovalForm> list = approvalDAO.selectApprovalFormList();
		for(ApprovalForm af : list) {
			System.out.println(af);
		}
	}
	
	//���缭��� ����ϱ�, �����ϱ�
	//@Test
	public void insertApprovalForm() throws Exception{
		ApprovalForm af = new ApprovalForm("�ް���û��", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl65\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�ް���û��</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">��û��</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">�Ⱓ</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl65\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">���Ͱ��� �ް��� ��û�մϴ�.</td> </tr> </tbody> </table>", "1002", "������");
		int i =  approvalDAO.insertApprovalForm(af);
		System.out.println(i);
	}
	
	//���缭��� �����ϱ�
	//@Test
	public void updateApprovalFormTest() throws Exception{
		ApprovalForm af = new ApprovalForm("�⺻��ȼ�", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 66.0pt;\" colspan=\"4\" rowspan=\"4\" height=\"88\">&nbsp;</td> </tr> </tbody> </table>", "1001", "��ä��");
		af.setApprovalFormNo("10001");
		int i = approvalDAO.updateApprovalForm(af);
		System.out.println(i);
	}
	
	//���缭��� �󼼺���
	//@Test
	public void selectApprovalFormDetailTest() throws Exception{
		ApprovalForm af = approvalDAO.selectApprovalFormDetail("10001");
		System.out.println(af);
	}
	
	//���缭��� �����ϱ�
	//@Test
	public void updateApprovalFormUsageStatusTest() throws Exception{
		ApprovalForm af = new ApprovalForm("�⺻��ȼ�", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 66.0pt;\" colspan=\"4\" rowspan=\"4\" height=\"88\">&nbsp;</td> </tr> </tbody> </table>", "1001", "��ä��");
		af.setApprovalFormNo("10001");
		af.setApprovalFormUsageStatusCodeNo("01");
		int i = approvalDAO.updateApprovalFormUsageStatus(af);
		System.out.println(i);
	}
	
	//���缭��� useCount �ø���
	//@Test
	public void updateApprovalFormUseCountTest() throws Exception{
		int i = approvalDAO.updateApprovalFormUseCount("10001");
		System.out.println(i);
		//selectApprovalFormDetailTest();
	}
	
	
	/////////////////////����/////////////////////////////
	//������
	//@Test
	public void insertApprovalTest() throws Exception{
		Approval ap = new Approval("��ä��_�����û��", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspa<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">����</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">�����ϰ�;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">����</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">���������</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">�������� �˴ϴ�.... ������ ������ �ƴϿ���</td> </tr> </tbody> </table> <p>&nbsp;</p>cing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">&nbsp;</td> </tr> </tbody> </table>", "10001", "02", "5");
		int i = approvalDAO.insertApproval(ap);
		System.out.println(i + ", " + ap);
	}
	
	//������ ����ϱ�
	//@Test
	public void insertApprover() throws Exception{
		Approver ap = new Approver("10022", "1000", "1");
		int i =approvalDAO.insertApprover(ap);
		System.out.println(i);
	}
	
	//������ ��������
	//@Test
	public void selectApproverListTest() throws Exception{
		List<Approver> list = approvalDAO.selectApproverList("10022");
		for(Approver ap : list) {
			System.out.println(ap);
		}
	}
	
	//������ ��������(����2, �ݷ�3, �Ϸ�4, ��⵵ 02 �ٸ� �ڱ������ϻ�)
	//@Test
	public void selectApprovalListTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("1000");
		search.setSearchCondition("1");
		List<Approval> list = approvalDAO.selectApprovalList(search);
		for(Approval approval : list) {
			System.out.println(approval);
		}
	}
	
	//���缭 �󼼺���
	//@Test
	public void selectApprovalDetailTest() throws Exception{
		Approval approval = approvalDAO.selectApprovalDetail("10022");
		System.out.println(approval);
	}
	
	//���缭���� �����ϱ�(����, �Ϸ�, �ݷ�)
	//@Test
	public void updateApprovalStatusTest() throws Exception{
		Approval ap = new Approval();
		ap.setApprovalNo("10000");
		ap.setApprovalStatusCodeNo("03");
		int i = approvalDAO.updateApprovalStatus(ap);
		System.out.println(i);
	}
	
	//�������� ������� �����ϱ�(����, �ݷ�)
	//@Test
	public void updateApproverStatusTest() throws Exception{
		Approver approver = new Approver();
		approver.setApprovalNo("10022");
		approver.setOrdinal("0");
		approver.setApprovalStatus("1");
		int i = approvalDAO.updateApproverStatus(approver);
		System.out.println(i);
	}
	
	//�����Ѱ����ڼ� �����ϱ�
	//@Test
	public void updateApproverCountFromApprovalTest() throws Exception{
		int i = approvalDAO.updateApproverCountFromApproval("10000");
		System.out.println(i);
	}
	
	//����Ϸ� Ȯ���ϱ�
	@Test
	public void isApprovalEndTest() throws Exception{
		System.out.println(approvalDAO.selectApprovalEnd("10000"));
	}
}