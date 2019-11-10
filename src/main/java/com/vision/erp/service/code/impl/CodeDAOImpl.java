package com.vision.erp.service.code.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.domain.Code;

@Repository("codeDAOImpl")
public class CodeDAOImpl implements CodeDAO {

	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//�׷��ڵ帮��Ʈ ��ü ��������
	@Override
	public List<Code> selectGroupCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CodeMapper.selectGroupCodeList", search);
	}

	//�ڵ� ���
	@Override
	public int insertCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("CodeMapper.insertCode", code);
	}

	//�׷��ڵ忡 �ش��ϴ� �ڵ帮��Ʈ ��������, searchKeyword = group_code, searchCondition=0=�����/1=����
	@Override
	public List<Code> selectCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CodeMapper.selectCodeList", search);
	}

	//�ڵ� ����(�ڵ�� ����)
	@Override
	public int updateCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("CodeMapper.updateCode", code);
	}

	//�ڵ� �ϳ��� ��������, �ڵ�� �ߺ�Ȯ��
	@Override
	public Code selectDuplicateCodeNo(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CodeMapper.selectDuplicateCodeNo", code);
	}

	//�׷��ڵ� ������ �ڵ��ȣ �ڵ�����
	@Override
	public Code selectLatestCodeNo(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CodeMapper.selectLatestCodeNo", groupCode);
	}

	//�ڵ� ����N/����Y
	@Override
	public int updateCodeUsageStatus(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("CodeMapper.updateCodeUsageStatus", code);
	}

	@Override
	public void updateCodeUsageStatusList(List<Code> codelist) throws Exception {
		// TODO Auto-generated method stub
		for(Code code : codelist) {
			sqlSession.update("CodeMapper.updateCodeUsageStatus", code);
		} 
	}

}
