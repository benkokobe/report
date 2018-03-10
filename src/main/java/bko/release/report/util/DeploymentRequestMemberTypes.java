package bko.release.report.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cw.scm.member.data.DatabaseMemberData;
import com.cw.scm.member.data.MemberData;
import com.cw.scm.member.data.table.TableData;
import com.cw.scm.member.description.DatabaseMemberDescription;
import com.cw.scm.member.description.DescriptionManager;
import com.cw.scm.member.description.MemberDescription;
import com.cw.scm.member.description.XmlMemberDescription;
import com.cw.scm.member.description.table.TableDescription;

import bko.release.report.domain.DeploymentRequest;
import bko.release.report.domain.PatchMember;

public class DeploymentRequestMemberTypes {

	private DeploymentRequest deploymentRequest;
	// List<String> types;

	HashMap<String, List<String>> types = new HashMap<String, List<String>>();

	public DeploymentRequest getDeploymentRequest() {
		return deploymentRequest;
	}

	public void setDeploymentRequest(DeploymentRequest deploymentRequest) {
		this.deploymentRequest = deploymentRequest;
	}

	// public void setTypes(){
	// List<PatchMember> patchMemberList = deploymentRequest.getMemberList();
	// for (PatchMember patchMember : patchMemberList){
	// this.types.add(patchMember.getMemberType(), );
	// System.out.println("Member type: " + patchMember.getMemberType());
	// }
	// }

	public void generatePatchMemberTypes() {

		String fileName;
		File member_file;
		List<PatchMember> patchMemberList = deploymentRequest.getMemberList();
		XmlMemberDescription memberDbdesc;

		List<TableDescription> tableDescritption;

		// for (String type : this.types){
		String type = "";
		for (PatchMember pMember : patchMemberList) {
			type = pMember.getMemberType();
			fileName = "memberdescription/";
			System.out.println("Type: " + type);
			fileName = fileName + type + ".xml";
			member_file = new File(fileName);
			memberDbdesc = DescriptionManager.getInstance().getDescriptionFromXml(type, member_file);

			List<String> tables = new ArrayList<String>();
			if (memberDbdesc != null) {
				tableDescritption = memberDbdesc.getTableDescriptions();
				for (TableDescription tableDesc : tableDescritption) {
					System.out.println("Table: " + tableDesc.name);
					tables.add(tableDesc.name);
					this.types.put(type, tables);
				}
			}
		}
	}

	public HashMap<String, List<String>> getTypes() {
		return types;
	}

	public void setTypes(HashMap<String, List<String>> types) {
		this.types = types;
	}

	public void main(String[] args) {
	//public static void main(String[] args) {

		// MemberDescription desc =
		// DescriptionManager.getInstance().getSimpleDescription(memberType,
		// null);
		XmlMemberDescription memberDbdesc;
		List<TableDescription> des;

		// DescriptionManager.getInstance();
		List<String> types = DescriptionManager.getMemberTypeList();
		String fileName;
		File member_file;
		// List<TableDescription> des;

//		for (String type : types) {
//
//			fileName = "memberdescription/";
//			System.out.println("Type: " + type);
//			fileName = fileName + type + ".xml";
//			member_file = new File(fileName);
//			memberDbdesc = DescriptionManager.getInstance().getDescriptionFromXml(type, member_file);
//			if (memberDbdesc != null) {
//				des = memberDbdesc.getTableDescriptions();
//				for (TableDescription tableDesc : des) {
//					System.out.println("Table: " + tableDesc.name);
//				}
//			}
//		}
	
		//
		
		//List <TableDescription> descriptions = DescriptionManager.getInstance().getDescriptionFromDatabase("01").getTableDescriptions();
		
		String type = "03";
		fileName = "memberdescription/";
		fileName = fileName + type + ".xml";
		member_file = new File(fileName);
		
		memberDbdesc = DescriptionManager.getInstance().getDescriptionFromXml(type, member_file);
		List <TableDescription> descriptions = memberDbdesc.getTableDescriptions();
		int i = 0;
//		for (TableDescription desc : descriptions){
//			System.out.println("desc.name: [" + i + "]" + desc.name);
//			System.out.println("desc.getFromClause(): " + desc.getFromClause());
//			System.out.println("desc.getFieldByName:  " + desc.fields);
//			i++;
//			
//		}
		
//		String table = "HDD23";
//		File dir = new File("memberdescription/");
//		File[] files = dir.listFiles();
		
//		for (File aFile : files) {
//	        
//	        
//	        String name = aFile.getName();
//	        //str = str.substring(0, str.lastIndexOf("."));
//	        name = name.substring(0, name.lastIndexOf("."));
//	        //System.out.println(name);
//	        
//	        if (name.equalsIgnoreCase("descriptions")) continue;
//	        if (name.equalsIgnoreCase("mapping")) continue;
//	        if (name.equalsIgnoreCase("mapping")) continue;
//	        
//	        member_file = aFile;
//	        memberDbdesc = DescriptionManager.getInstance().getDescriptionFromXml(type, aFile);
//	        descriptions = memberDbdesc.getTableDescriptions();
//	        for (TableDescription desc : descriptions){
//	        	if ( table.equalsIgnoreCase(desc.name)){
//	        		System.out.println("Table: " + table + "[ type: " + name + "]");
//	        	}
//	        }
//	        
//	    }
//		MemberDescription desc;
//		desc = new DatabaseMemberDescription(type);
//		desc.load();
//		System.out.println(" keys : " + desc.getKey());
		
		//DatabaseMemberData databaseMemberData = new DatabaseMemberData("CLXXV", "CL", "03", "1");
		DatabaseMemberData databaseMemberData = new DatabaseMemberData("CLXXV", "CL", "03", "1");
		
		//databaseMemberData.load();
		//getDescriptionFromXml(type, member_file);
		databaseMemberData.getDescription().getXmlFileDesc("03", member_file);
		
		
		//MemberData memberdata;
		//memberdata.getMemberType();
		
		System.out.println("Tables: " + databaseMemberData.getTables());
		List<TableData> tables = databaseMemberData.getTables();
		
		for (TableData  table :  tables){
			//System.out.println("SQL rows: [" + table.toString() + "]" + table.getRows());
			System.out.println("SQL rows: [" + table.toString() + "]" + table.getSelectQuery());
		}
		
		
		
		//databaseMemberData.getTables().
//		for ( TableDescription desc : descriptions){
//			if (desc.name.equalsIgnoreCase(table)){
//				System.out.println( "Table: " + table + " " + desc.name );
//			}
//			  
//		}
		
		
	}
}
