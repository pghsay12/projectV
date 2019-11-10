package com.vision.erp.service.approval;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;

public interface ApprovalService {
	
	////////////////////////���缭/////////////////////////////
	//�����ĸ�� ��������
	public List<ApprovalForm> getApprovalFormList() throws Exception;
	
	//������ ���, �����ϱ�
	public void addApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//������ �����ϱ�
	public void modifyApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//������ �󼼺���
	public ApprovalForm getApprovalFormDetail(String approvalFormNo) throws Exception;
	
	//������ �����ϱ�
	public void convertApprovalFrom(ApprovalForm approvalForm) throws Exception;
	

	///////////////////////����///////////////////////////////
	//���� ����ϱ�
	public void addApproval(Approval approval) throws Exception;
	
	//������ ��������
	public List<Approval> getApprovalList(Search search) throws Exception;
	
	//���� �󼼺���
	public Approval getApprovalDetail(String approvalNo) throws Exception;
	
	//�����ڰ� ����/�ݷ��ϰ� ���缭���� �����ϱ�
	//���缭�� �����ڱ��� ä�����־����
	public void modifyApprovalStatus(Approval approval, String employeeNo, String approvalOrReturn) throws Exception;
	
}
