package com.vision.erp.web.code;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeService;
import com.vision.erp.service.domain.Code;

@RestController
public class CodeController {
	//field
	@Resource(name = "codeServiceImpl")
	private CodeService codeService;

	//constructor
	public CodeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//method
	//[�׷��ڵ���ȸ] - �׷��ڵ�����ȸ 
	//���� ���� �� ������
	@RequestMapping(value="/code/getGroupCodeList")
	public List<Code> getGroupCodeList() throws Exception{
		return codeService.getGroupCodeList();
	}
	
	//[�׷��ڵ���ȸ] - �ڵ� �׷캰��ȸ(�����, ���� ����)
	//searchKeyword = �׷��ڵ�
	//searchCondition = 0 : �����, = 1 : ����
	@RequestMapping(value="/code/getCodeList")
	public List<Code> getCodeList(@RequestBody Search search) throws Exception{
		return codeService.getCodeList(search);
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ� ����/�����ϱ� �׷��ڵ�, �ڵ��ȣ, �ڵ������ �ʿ�
	//codeUsageStatus = Y : ����, N : ����
	@RequestMapping(value="/code/convertCodeUsageStatus")
	public void convertCodeUsageStatus(@RequestBody Code code) throws Exception{
		codeService.convertCodeUsageStatus(code);
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ� ����/�����ϱ� �׷��ڵ�, �ڵ��ȣ, �ڵ������ �ʿ�
	//codeUsageStatus = D : ��������
	@RequestMapping(value="/code/convertCodeUsageStatusList")
	public void convertCodeUsageStatusList(@RequestBody List<Code> codelist) throws Exception{
		codeService.convertCodeUsageStatusList(codelist);
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ� ��Ͽ�û�� �ڵ��ȣ �ڵ�����
	//����Ϸ��� �׷��ڵ� ��������
	@RequestMapping(value="/code/addCodePreparing/{groupCode}")
	public Code addCodePreparing(@PathVariable String groupCode) throws Exception{
		return new Code().setCodeNo(codeService.generateCodeNo(groupCode));
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ�� �ߺ�Ȯ�� �׷��ڵ�, �ڵ�� �ʿ�
	@RequestMapping(value="/code/checkDuplicateCodeName")
	public boolean checkDuplicateCodeName(@RequestBody Code code) throws Exception {
		Code dbCode = codeService.checkDuplicateCodeNo(code);
		if(dbCode==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ� ����ϱ� �׷��ڵ�, �ڵ��ȣ, �ڵ�� �ʿ�
	@RequestMapping(value="/code/addCode")
	public void addCode(@RequestBody Code code) throws Exception{
		codeService.addCode(code);
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ�����ϱ� �׷��ڵ�, �ڵ��ȣ, �ڵ�� �ʿ�
	@RequestMapping(value="/code/modifyCode")
	public void modifyCode(@RequestBody Code code) throws Exception{
		codeService.modifyCode(code);
	}
	
	//[�ڵ�׷캰��ȸ] - �ڵ� ������ �ϳ��� �ڵ� �������� �׷��ڵ�, �ڵ�� �ʿ�
	@RequestMapping(value="/code/getCode")
	public Code getCode(@RequestBody Code code) throws Exception {
		return codeService.checkDuplicateCodeNo(code);
	}

}
