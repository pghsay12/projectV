package com.vision.erp.service.code.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.code.CodeService;
import com.vision.erp.service.domain.Code;

@Service("codeServiceImpl")
public class CodeServiceImpl implements CodeService {

	//field
	@Resource(name="codeDAOImpl")
	private CodeDAO codeDAO;
	
	//method
	//�׷��ڵ帮��Ʈ ��ü ��������
	@Override
	public List<Code> getGroupCodeList() throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectGroupCodeList(null);
	}

	//�ڵ� ���
	@Override
	public void addCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		
		//�׷��ڵ�� ��������
		Search search = new Search();
		search.setSearchKeyword(code.getGroupCode());
		
		codeDAO.insertCode(code.setGroupCodeName(codeDAO.selectGroupCodeList(search).get(0).getGroupCodeName()));
	}

	//�׷��ڵ忡 �ش��ϴ� �ڵ帮��Ʈ ��������
	//search condition�� ������� ����, search keyword�� �׷��ڵ�
	@Override
	public List<Code> getCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectCodeList(search);
	}

	//�ڵ� ����(�ڵ�� ����)
	@Override
	public void modifyCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.updateCode(code);
	}

	//�ڵ� �ϳ��� ��������, �ڵ�� �ߺ�Ȯ��
	@Override
	public Code checkDuplicateCodeNo(Code code) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectDuplicateCodeNo(code);
	}

	//�׷��ڵ� ������ �ڵ��ȣ �ڵ�����
	@Override
	public String generateCodeNo(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		//String.format("�ٲ� ���İ� �������� ���ǹ�", "��������")
		//"%02d"==> % : ����� ����, 0 : ä���� ����, 2 : �� �ڸ���, d : ���� ����	[���� : https://devbible.tistory.com/78]
		return String.format("%02d", Integer.parseInt(codeDAO.selectLatestCodeNo(groupCode).getCodeNo())+1);
	}

	//�ڵ� ����/����
	@Override
	public void convertCodeUsageStatus(Code code) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.updateCodeUsageStatus(code);
	}

	@Override
	public void convertCodeUsageStatusList(List<Code> codelist) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.updateCodeUsageStatusList(codelist);
	}

}
