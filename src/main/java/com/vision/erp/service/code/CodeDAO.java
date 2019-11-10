package com.vision.erp.service.code;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Code;

public interface CodeDAO {
	//�׷��ڵ帮��Ʈ ��ü ��������, Searchkeyword�� �׷��ڵ�� �׷��ڵ�� ������ �� ����
	public List<Code> selectGroupCodeList(Search search) throws Exception;
	
	//�ڵ� ���
	public int insertCode(Code code) throws Exception;
	
	//�׷��ڵ忡 �ش��ϴ� �ڵ帮��Ʈ ��������
	public List<Code> selectCodeList(Search search) throws Exception;
	
	//�ڵ� ����(�ڵ�� ����)
	public int updateCode(Code code) throws Exception;

	//�ڵ� �ϳ��� ��������, �ڵ�� �ߺ�Ȯ��
	public Code selectDuplicateCodeNo(Code code) throws Exception;
	
	//�׷��ڵ� ������ �ڵ��ȣ �ڵ�����
	public Code selectLatestCodeNo(String groupCode) throws Exception;

	//�ڵ� ����/����
	public int updateCodeUsageStatus(Code code) throws Exception;
	
	//�ڵ� ����
	public void updateCodeUsageStatusList(List<Code> codelist) throws Exception;
	
}
