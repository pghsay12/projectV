package com.vision.erp.web.approval;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalService;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;

@RestController
public class ApprovalController {
	//field
	@Resource(name = "approvalServiceImpl")
	private ApprovalService approvalService;

	//constructor
	public ApprovalController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//method
	//[���缭��ĸ����ȸ] - ���缭��ĸ����ȸ
	@RequestMapping(value="/approval/getApprovalFormList")
	public List<ApprovalForm> getApprovalFormList() throws Exception{
		return approvalService.getApprovalFormList();
	}
	
	//[���缭��ĸ����ȸ] - ���缭��Ļ���
	//approvalFormNo, approvalFormUsageStatusCodeNo �ʿ�(01 �����, 02 ����)
	@RequestMapping(value="/approval/convertApprovalFormUsageStatus")
	public void convertApprovalFormUsageStatus(@RequestBody ApprovalForm approvalForm) throws Exception{
		approvalService.convertApprovalFrom(approvalForm);
	}
	
	//[���缭��ĵ��] - ���缭��ĵ��, ����
	//approvalFormTitle, approvalForm, registrantEmployeeNo, ����� registrantEmployeeName
	@RequestMapping(value="/approval/addApprovalForm")
	public void addApprovalForm(@RequestBody ApprovalForm approvalForm) throws Exception{
		approvalService.addApprovalForm(approvalForm);
	}
	
	//[���缭��ĸ����ȸ] - ���缭��Ļ���ȸ
	@RequestMapping(value="/approval/getApprovalFormDetail/{formNo}")
	public ApprovalForm getApprovalFormDetail(@PathVariable("formNo") String approvalFormNo) throws Exception{
		return approvalService.getApprovalFormDetail(approvalFormNo);
	}
	
	//[���缭��ļ���] - ���缭��ļ���
	//approvalFormNo, approvalFormTitle, approvalForm, registrantEmployeeNo, registrantEmployeeName �ʿ�
	@RequestMapping(value="/approval/modifyApprovalForm")
	public void modifyApprovalForm(@RequestBody ApprovalForm approvalForm) throws Exception{
		approvalService.modifyApprovalForm(approvalForm);
	}
	
	//[�����û] - ������(���)
	//approvalTitle, approvalContent, approvalFormNo, approvalStatusCodeNo, approverCount(Approver ordinal, employeeNo ä�����־����) �ʿ�
	@RequestMapping(value="/approval/addApproval")
	public void addApproval(@RequestBody Approval approval) throws Exception{
		approvalService.addApproval(approval);
	}
	
	//[��������ȸ] - ���õ� �����Կ� ���� ��� ���
	//SearchCondition���� ����2, �ݷ�3, �Ϸ�4, ��⵵ 2
	//	  SearchCondition����<if test="searchCondition==1">
	//	  AND al.approver_count = er.ordinal
	//	  AND al.approval_status_code IN ('02')
	//</if>
	//<if test="searchCondition==2">
	//	  AND er.ordinal = '0'
	//	  AND al.approval_status_code IN ('02')
	//</if>
	//<if test="searchCondition==4">
	//	  AND er.ordinal = '0'
	//	  AND al.approval_status_code IN ('04')
	//</if>
	//<if test="searchCondition==3">
	//	  AND er.ordinal = '0'
	//	  AND al.approval_status_code IN ('03')
	//</if>
	//SearchKeyword���� �����ȣ
	@RequestMapping(value="/approval/getApprovalList")
	public List<Approval> getApprovalList(@RequestBody Search search) throws Exception{
		return approvalService.getApprovalList(search);
	}
	
	//[��������ȸ] - �������ȸ
	@RequestMapping(value="/approval/getApprovalDetail/{approvalNo}")
	public Approval getApprovalDetail(@PathVariable("approvalNo") String approvalNo) throws Exception{
		return approvalService.getApprovalDetail(approvalNo);
	}
	
	//[�������ȸ] - ����/�ݷ��ϱ�
	@RequestMapping(value="/approval/modifyApprovalStatus/{approvalNo}/{employeeNo}/{approvalOrReturn}")
	public void modifyApprovalStatus(@PathVariable("approvalNo") String approvalNo, @PathVariable("employeeNo") String employeeNo, @PathVariable("approvalOrReturn") String approvalOrReturn) throws Exception{
		approvalService.modifyApprovalStatus(approvalService.getApprovalDetail(approvalNo), employeeNo, approvalOrReturn);
	}
	
}
