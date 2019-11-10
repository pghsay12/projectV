package com.vision.erp.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingDAO;
import com.vision.erp.service.businesssupport.BusinessSupportDAO;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.Branch;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.Salary;
import com.vision.erp.service.domain.User;
import com.vision.erp.service.domain.WorkAttitude;
import com.vision.erp.service.humanresource.HumanResourceDAO;
import com.vision.erp.service.user.UserDAO;
import com.vision.erp.service.user.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDAOImpl")
	private UserDAO userDAO;
	
	@Autowired
	@Qualifier("humanResourceDAOImpl")
	private HumanResourceDAO humanResourceDAO;
	
	@Autowired
	@Qualifier("accountingDAOImpl")
	private AccountingDAO accountingDAO;
	
	@Autowired
	@Qualifier("businessSupportDAOImpl")
	private BusinessSupportDAO businessSupportDAO;
	
	//ȸ������
	@Override
	public void addUser(User user) throws Exception {
		
		userDAO.insertUser(user);
		
	}
	@Override
	public User getUser(User user) throws Exception {
		
		return userDAO.selectUser(user);
	}
	//�Ⱥ����ٰ���
	@Override
	public List<User> getUserList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectUserList(search);
	}
	//����������(�޼ҵ��̿�)�λ�ī��/����/�޿��̷�/��������(�� �޼ҵ� ���°žƴ�)
	@Override
	public Map<String,Object> getInfo(String employeeNo) throws Exception {
		
		Search search = new Search();
		Map<String, Object> map = new HashMap<String, Object>();
		search.setSearchKeyword(employeeNo);
		
		HumanResourceCard humanResourceCard = humanResourceDAO.selectHumanResourceCardDetailByEmployeeNo(employeeNo);
		List<Salary> salary = accountingDAO.selectSalaryList(search);
		List<WorkAttitude> workAttitude = humanResourceDAO.selectWorkAttitudeList(search);
		Branch branch = businessSupportDAO.selectBranchDetail(employeeNo);
		
		map.put("humanResourceCard", humanResourceCard);
		map.put("salary", salary);
		map.put("workAttitude", workAttitude);
		map.put("branch", branch);
		
		return map;
	}
	//��й�ȣ����
	@Override
	public void modifyPassword(User user) throws Exception {
		
		userDAO.updatePassword(user);
		
	}
	//������̵�Ȯ��
	@Override
	public User getProofMySelfForId1(HumanResourceCard hrcInfo) throws Exception {
		
		return userDAO.selectProofMySelfForId1(hrcInfo);
	}
	//�����й�ȣȮ��
	@Override
	public User getProofMySelfForPassword1(Map<String, String> map) throws Exception {
		
		return userDAO.selectProofMySelfForPassword1(map);
	}
	//������̵����
	@Override
	public User getProofMySelfForId2(Branch branch) throws Exception {
		
		return userDAO.selectProofMySelfForId2(branch);
	}
	//�����й�ȣȮ��
	@Override
	public User getProofMySelfForPassword2(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectProofMySelfForPassword2(map);
	}

	
	

}
