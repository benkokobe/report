package bko.release.report.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cw.scm.member.data.DatabaseMemberData;
import com.cw.scm.member.data.table.TableData;
import com.cw.scm.member.description.XmlMemberDescription;

import bko.release.report.domain.MemberSqlQuery;
import bko.release.report.domain.MyMemberDescription;

public class MyMemberDescriptionManager {
	
	private static final Logger log = LoggerFactory.getLogger(MyMemberDescriptionManager.class);
	
	private MyMemberDescription myMemberDescription;
	
	public MyMemberDescription getMyMemberDescription() {
		return myMemberDescription;
	}

	public void setMyMemberDescription(MyMemberDescription myMemberDescription) {
		this.myMemberDescription = myMemberDescription;
	}

	DatabaseMemberData databaseMemberData;
	
	List<MemberSqlQuery>  mySqlQueries;
	
	
	public void setMember(String memberName, String group, String type, String companyId){
		
		XmlMemberDescription memberDbdesc;
		File member_file;
		String fileName;
		fileName = "memberdescription/";
		fileName = fileName + type + ".xml";
		member_file = new File(fileName);
		
		//databaseMemberData = new DatabaseMemberData("CLXXV", "CL", "03", "1");
		this.databaseMemberData = new DatabaseMemberData(memberName, group, type, companyId);
		
		this.databaseMemberData.getDescription().getXmlFileDesc(type, member_file);
		
		//List<TableData> tables = databaseMemberData.getTables();
	}
	
	public void initialize_description(){
		
		
		this.myMemberDescription = new MyMemberDescription();

		this.myMemberDescription.setLinkedTables(this.databaseMemberData.getTables());
		
		this.mySqlQueries = new ArrayList<MemberSqlQuery>();
		
		MemberSqlQuery memberQuery;
		
		
		for (TableData table : this.myMemberDescription.getLinkedTables()){
			memberQuery = new MemberSqlQuery();
			//System.out.println("Table: " + table.toString() + ": "  + table.getSelectQuery());
			memberQuery.setTable(table.toString());
			memberQuery.setQuery(table.getSelectQuery());
			this.mySqlQueries.add(memberQuery);
		}
		this.myMemberDescription.setMySqlQueries(mySqlQueries);
		
	}
	public void display(){
		
		//System.out.println("Tables:" + this.myMemberDescription.getLinkedTables() );
		System.out.println("SQL");
		for(MemberSqlQuery query : this.mySqlQueries){
			System.out.println("Tabel: " + query.getTable());
			System.out.println("Query: " + query.getQuery());
		}
		
	}
	
	//public static void main(String[] args) {
	public void main(String[] args) {
		
		MyMemberDescriptionManager  myDescription  = new MyMemberDescriptionManager();
		myDescription.setMember("CLXXV", "CL", "03", "1");
		myDescription.initialize_description();
		
		myDescription.display();

	}
}
