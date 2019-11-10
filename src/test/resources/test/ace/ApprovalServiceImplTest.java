package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalService;
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

public class ApprovalServiceImplTest{

	@Resource(name = "approvalServiceImpl")
	private ApprovalService approvalService;
	
	////////////////////////���缭/////////////////////////////
	//�����ĸ�� ��������
	//@Test
	public void getApprovalFormListTest() throws Exception{
		List<ApprovalForm> list = approvalService.getApprovalFormList();
		for(ApprovalForm af : list) {
			System.out.println(af);
		}
	}
	
	//������ ���, �����ϱ�
	//@Test
	public void addApprovalFormTest() throws Exception{
		ApprovalForm af = new ApprovalForm("�ø���", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�ø���</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">�Ҽ�</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">�� �� ��</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">������ :&nbsp;</td> </tr> </tbody> </table>", "1001", "��ä��");
		approvalService.addApprovalForm(af);
	}
	
	//������ �����ϱ�
	//@Test
	public void modifyApprovalFormTest() throws Exception{
		ApprovalForm af = new ApprovalForm("�⺻��ȼ�", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 66.0pt;\" colspan=\"4\" rowspan=\"4\" height=\"88\">&nbsp;</td> </tr> </tbody> </table>", "1001", "��ä��");
		af.setApprovalFormNo("10001");
		approvalService.modifyApprovalForm(af);
	}
	
	//������ �󼼺���
	//@Test
	public void getApprovalFormDetailTest() throws Exception{
		ApprovalForm af = approvalService.getApprovalFormDetail("10001");
		System.out.println(af);
	}
	
	//������ �����ϱ�(���缭��Ĺ�ȣ, �������ڵ� �ʿ�)
	//@Test
	public void convertApprovalFromTest() throws Exception{
		ApprovalForm af = new ApprovalForm();
		af.setApprovalFormUsageStatusCodeNo("02");
		af.setApprovalFormNo("10020");
		approvalService.convertApprovalFrom(af);
	}
	
	///////////////////////����///////////////////////////////
	//���� ����ϱ�
	//�׽�Ʈ �̿ϼ� humanResourceCard ���� �� �ٽ� Ȯ��
	//@Test
	public void addApprovalTest() throws Exception{
		Approval approval = new Approval("��ä��_�ø���", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspa<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">�ø���</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">����</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">�����Դ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">����</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">���������</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">�������� �˴ϴ�.... ������ ������ �ƴϿ���</td> </tr> </tbody> </table> <p>&nbsp;</p>cing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">�⺻��ȼ�</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">����</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">����</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">&nbsp;</td> </tr> </tbody> </table>", "10001", "02", "1");
		Approver first = new Approver();
		first.setOrdinal("0");
		first.setEmployeeNo("1001");
		Approver second = new Approver();
		second.setOrdinal("1");
		second.setEmployeeNo("1002");
		Approver third = new Approver();
		third.setOrdinal("2");
		third.setEmployeeNo("1000");
		approval.setFirstApprover(first);
		approval.setSecondApprover(second);
		approval.setThirdApprover(third);
		approval.setApprovalFormNo("10022");
		
		approvalService.addApproval(approval);
	}

	//������ ��������, SearchCondition���� ����2, �ݷ�3, �Ϸ�4, ��⵵ 02/ SearchKeyword���� �����ȣ �����ִ��� Ȯ���ϱ�
	//@Test
	public void getApprovalListTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("1000");
		search.setSearchCondition("1");
		List<Approval> list = approvalService.getApprovalList(search);
		for(Approval ap : list) {
			System.out.println(ap);
		}
	}
	
	//���� �󼼺���
	//@Test
	public void getApprovalDetailTest() throws Exception{
		Approval approval = approvalService.getApprovalDetail("10022");
		System.out.println(approval);
	}
	
	//�����ڰ� ����/�ݷ��ϰ� ���缭���� �����ϱ�
	//���缭�� �����ڱ��� ä�����־����
	//@Test
	public void modifyApprovalStatusTest() throws Exception{
		Approval approval = approvalService.getApprovalDetail("10022");
		approvalService.modifyApprovalStatus(approval, "1002", "approval");
	}
	
	
}