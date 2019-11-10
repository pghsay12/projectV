package com.vision.erp.service.approval.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalDAO;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

@Repository("approvalDAOImpl")
public class ApprovalDAOImpl implements ApprovalDAO {
	
	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//constructor
	public ApprovalDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/////////////////////���缭���//////////////////////////
	//���缭��� ����Ʈ ��������
	@Override
	public List<ApprovalForm> selectApprovalFormList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalFormMapper.selectApprovalFormList");
	}

	//���缭��� ����ϱ�, �����ϱ�
	@Override
	public int insertApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("ApprovalFormMapper.insertApprovalForm", approvalForm);
	}

	//���缭��� �����ϱ�
	@Override
	public int updateApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalForm", approvalForm);
	}

	//���缭��� �󼼺���
	@Override
	public ApprovalForm selectApprovalFormDetail(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ApprovalFormMapper.selectApprovalFormDetail", approvalFormNo);
	}

	//���缭��� �����ϱ�
	@Override
	public int updateApprovalFormUsageStatus(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalFormUsageStatus", approvalForm);
	}

	//���缭��� useCount �ø���
	@Override
	public int updateApprovalFormUseCount(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalFormUseCount", approvalFormNo);
	}

	
	/////////////////////����/////////////////////////////
	//������
	@Override
	public int insertApproval(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(approval);
		return sqlSession.insert("ApprovalMapper.insertApproval", approval);
	}

	//������ ����ϱ�
	@Override
	public int insertApprover(Approver approver) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("ApprovalMapper.insertApprover", approver);
	}

	//������ ��������
	@Override
	public List<Approver> selectApproverList(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalMapper.selectApproverList", approvalNo);
	}

	//������ ��������(����2, �ݷ�3, �Ϸ�4, ��⵵ 02 �ٸ� �ڱ������ϻ�)
	@Override
	public List<Approval> selectApprovalList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalMapper.selectApprovalList", search);
	}

	//���缭 �󼼺���
	@Override
	public Approval selectApprovalDetail(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ApprovalMapper.selectApprovalDetail", approvalNo);
	}

	//���缭���� �����ϱ�(����, �Ϸ�, �ݷ�)
	@Override
	public int updateApprovalStatus(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApprovalStatus", approval);
	}

	//�������� ������� �����ϱ�(�̿�0, ����1)
	@Override
	public int updateApproverStatus(Approver approver) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApproverStatus", approver);
	}
	
	//�����Ѱ����ڼ� �����ϱ�
	@Override
	public int updateApproverCountFromApproval(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApproverCountFromApproval", approvalNo);
	}

	//���� �Ϸ��� �� �ִ��� Ȯ���ϱ�(�����Ѱ�����=�Ѱ����ڼ�)
	@Override
	public boolean selectApprovalEnd(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		Approval approval = selectApprovalDetail(approvalNo);
		if(approval.getApproverCount().equals(approval.getTotalApproverCount())) {
			return true;
		}
		return false;
	}
	

}
