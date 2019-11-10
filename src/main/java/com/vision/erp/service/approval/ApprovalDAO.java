package com.vision.erp.service.approval;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

public interface ApprovalDAO {

	/////////////////////���缭���//////////////////////////
	//���缭��� ����Ʈ ��������
	public List<ApprovalForm> selectApprovalFormList() throws Exception;
	
	//���缭��� ����ϱ�, �����ϱ�
	public int insertApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//���缭��� �����ϱ�
	public int updateApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//���缭��� �󼼺���
	public ApprovalForm selectApprovalFormDetail(String approvalFormNo) throws Exception;
	
	//���缭��� �����ϱ�
	public int updateApprovalFormUsageStatus(ApprovalForm approvalForm) throws Exception;

	//���缭��� useCount �ø���
	public int updateApprovalFormUseCount(String approvalFormNo) throws Exception;
	
	/////////////////////����/////////////////////////////
	//������
	public int insertApproval(Approval approval) throws Exception;
	
	//������ ����ϱ�
	public int insertApprover(Approver approver) throws Exception;
	
	//������ ��������
	public List<Approver> selectApproverList(String approvalNo) throws Exception;
	
	//������ ��������(����2, �ݷ�3, �Ϸ�4, ��⵵ 02 �ٸ� �ڱ������ϻ�)
	public List<Approval> selectApprovalList(Search search) throws Exception;
	
	//���缭 �󼼺���
	public Approval selectApprovalDetail(String approvalNo) throws Exception;
	
	//���缭���� �����ϱ�(����, �Ϸ�, �ݷ�)
	public int updateApprovalStatus(Approval approval) throws Exception;
	
	//�������� ������� �����ϱ�(�̿�0, ����1)
	public int updateApproverStatus(Approver approver) throws Exception;
	
	//�����Ѱ����ڼ� �����ϱ�
	public int updateApproverCountFromApproval(String approvalNo) throws Exception;
	
	//���� �Ϸ��� �� �ִ��� Ȯ���ϱ�(�����Ѱ�����=�Ѱ����ڼ�)
	public boolean selectApprovalEnd(String approvalNo) throws Exception;
}
