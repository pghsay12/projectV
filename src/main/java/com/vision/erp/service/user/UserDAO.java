package com.vision.erp.service.user;

import java.util.List;
import java.util.Map;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Branch;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.User;

public interface UserDAO {
	//회원가입
	public void insertUser(User user) throws Exception;

	//안보여줄거임
	public List<User> selectUserList(Search search) throws Exception;

	//로그인
	public User selectUser(User user) throws Exception;

	//비밀번호변경하기
	public void updatePassword(User user) throws Exception; 

	//인증
	public User selectProofMySelfForId1(HumanResourceCard hrcInfo) throws Exception;

	//인증
	public User selectProofMySelfForPassword1(Map<String, String> map) throws Exception;

	//인증
	public User selectProofMySelfForId2(Branch branch) throws Exception;

	//인증
	public User selectProofMySelfForPassword2(Map<String, String> map) throws Exception;

}
