package com.vision.erp.service.code;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Code;

public interface CodeService {
	//�׷��ڵ帮��Ʈ ��ü ��������
	public List<Code> getGroupCodeList() throws Exception;
	
	//�ڵ� ���
	public void addCode(Code code) throws Exception;
	
	//�׷��ڵ忡 �ش��ϴ� �ڵ帮��Ʈ ��������
	public List<Code> getCodeList(Search search) throws Exception;
	
	//�ڵ� ����(�ڵ�� ����)
	public void modifyCode(Code code) throws Exception;

	//�ڵ� �ϳ��� ��������, �ڵ�� �ߺ�Ȯ��
	public Code checkDuplicateCodeNo(Code code) throws Exception;

	//�׷��ڵ� ������ �ڵ��ȣ �ڵ�����
	public String generateCodeNo(String groupCode) throws Exception;

	//�ڵ� ����/����
	public void convertCodeUsageStatus(Code code) throws Exception;
	
	//�ڵ� ����
	public void convertCodeUsageStatusList(List<Code> codelist) throws Exception;
}
