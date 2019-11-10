package com.vision.erp.web.user;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.SendSMS;
import com.vision.erp.service.domain.Branch;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.SMS;
import com.vision.erp.service.domain.User;
import com.vision.erp.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;


	//�α����ϱ����� �� �����ҷ���
	@RequestMapping(value="/user/getLoginUser",method=RequestMethod.POST)
	public User getLoginUser(@RequestBody User user) throws Exception{
			
			System.out.println("/user/getLoginUser");

			User dbuser = userService.getUser(user);
			
			if(dbuser != null) {
				if(user.getUserId().equals(dbuser.getUserId()) && user.getPassword().equals(dbuser.getPassword()) ) {
					dbuser.setPassword(null);
					dbuser.setLoginFlag(true);
					return  dbuser;
				}
			}else {
				user.setLoginFlag(false);
				user.setUserId(null);
				user.setPassword(null);
			}
			
			return user;
	}

	//���̵�ã��
		@RequestMapping(value="/user/getForgotId",method=RequestMethod.POST)
		public User getForgotId(@RequestBody Map<String, String> map) throws Exception{
			
			System.out.println("/user/getForgotId");
			
			HumanResourceCard humanResourceCard = new HumanResourceCard();
			Branch branch = new Branch();
			
			SendSMS sendSMS = SendSMS.getSendSMSInstance();
			SMS sms = new SMS();
			sms.setSender("010-4468-0115");
			sms.setReciever(map.get("phone").replace("-", ""));
			
			String message = "";
			
			humanResourceCard.setEmployeeName(map.get("name"));
			humanResourceCard.setEmployeePhone(map.get("phone"));
			branch.setBranchManagerName(map.get("name"));
			branch.setBranchManagerPhone(map.get("phone"));
			
			User user = userService.getProofMySelfForId1(humanResourceCard);
			if( user != null) {
				message = "ȸ������ ���̵�� ["+user.getUserId()+"]�Դϴ�.";
				sms.setContent(message);
				sendSMS.sendSMS(sms);
				return user;
			}else {
				user = userService.getProofMySelfForId2(branch);
				if( user != null) {
					message = "ȸ������ ���̵�� ["+user.getUserId()+"]�Դϴ�.";
					sms.setContent(message);
					sendSMS.sendSMS(sms);
					return user;
				}else {
					return new User();
				}
			}
		}

	//��й�ȣ ã��
	@RequestMapping(value="/user/getForgotPassword",method=RequestMethod.POST)
	public boolean getForgotPassword(@RequestBody Map<String, String> map) throws Exception{

		User user = userService.getProofMySelfForPassword1(map);
		if(user != null) {
			return true;
		}else {
			user = userService.getProofMySelfForPassword2(map);
			if(user != null) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	@RequestMapping(value = "/user/getIdentifyCode", method=RequestMethod.POST)
	public StringBuffer getIdentifyCode(@RequestBody Map<String, String> map) throws Exception{
		
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i<5; i++) {
			if(random.nextBoolean()) {
				buf.append((char)((int)(random.nextInt(26))+65));
			}else {
				buf.append((random.nextInt(10)));
			}
		}
		
		System.out.println(buf);
		
		SendSMS sendSMS = SendSMS.getSendSMSInstance();
		SMS sms = new SMS();
		sms.setSender("010-3739-1105");
		sms.setReciever(map.get("phone").replace("-", ""));
		
		String message = "";
		
		User user = userService.getProofMySelfForPassword1(map);
		if(user != null) {
			message = "������ ������ȣ�� ["+buf+"]�Դϴ�. �ùٸ��� �Է��ϼ���.";
			sms.setContent(message);
			sendSMS.sendSMS(sms);
			return buf;
		}else {
			user = userService.getProofMySelfForPassword2(map);
			if(user != null) {
				message = "������ ������ȣ�� ["+buf+"]�Դϴ�. �ùٸ��� �Է��ϼ���.";
				sms.setContent(message);
				sendSMS.sendSMS(sms);
				return buf;
			}else {
				return null;
			}
		}
	}

	//����������
	@RequestMapping(value="/user/getInfo/{employeeNo}",method=RequestMethod.GET)
	public Map<String, Object> getInfo(@PathVariable String employeeNo) throws Exception{
		System.out.println("/user/getInfo/{employeeNo}");
		return userService.getInfo(employeeNo);
	}

	//��й�ȣ����
	@RequestMapping(value="/user/modifyPassword",method=RequestMethod.POST)
	public void modifyPassword(@RequestBody User user) throws Exception{
		System.out.println("/user/modifyPassword");
		userService.modifyPassword(user);
	}


}
