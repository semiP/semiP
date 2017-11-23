package mypage;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import common.pagingAction;

public class inqFormAction extends ActionSupport {
	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private List<inquiryVO> list = new ArrayList<inquiryVO>();

	// ������
	public inqFormAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close(); // �о� ������ �ݱ�
	}

	public String execute() throws Exception {

		list = sqlMapper.queryForList("inq.selectAll"); // list�� ��� �� ������ ����
		return SUCCESS;
	}


	public List<inquiryVO> getList() {
		return list;
	}

	public void setList(List<inquiryVO> list) {
		this.list = list;
	}


}
