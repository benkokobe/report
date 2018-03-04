package bko.release.report.domain;

import java.util.List;

import com.cw.scm.member.data.table.TableData;

public class MyMemberDescription {
	
	private String name;
	private String group;
	private String type;
	private String companyId;
	
	List<MemberSqlQuery>  mySqlQueries;
	
	
	public List<MemberSqlQuery> getMySqlQueries() {
		return mySqlQueries;
	}


	public void setMySqlQueries(List<MemberSqlQuery> mySqlQueries) {
		this.mySqlQueries = mySqlQueries;
	}


	private List<TableData> linkedTables ;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public List<TableData> getLinkedTables() {
		return linkedTables;
	}


	public void setLinkedTables(List<TableData> linkedTables) {
		this.linkedTables = linkedTables;
	}
	
	

}
