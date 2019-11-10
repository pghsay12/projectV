package com.vision.erp.service.user;

import java.util.List;
import java.util.Map;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Branch;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.User;

public interface UserDAO {
	//ȸ������
	public void insertUser(User user) throws Exception;

	//�Ⱥ����ٰ���
	public List<User> selectUserList(Search search) throws Exception;

	//�α���
	public User selectUser(User user) throws Exception;

	//��й�ȣ�����ϱ�
	public void updatePassword(User user) throws Exception; 

	//����
	public User selectProofMySelfForId1(HumanResourceCard hrcInfo) throws Exception;

	//����
	public User selectProofMySelfForPassword1(Map<String, String> map) throws Exception;

	//����
	public User selectProofMySelfForId2(Branch branch) throws Exception;

	//����
	public User selectProofMySelfForPassword2(Map<String, String> map) throws Exception;

}
