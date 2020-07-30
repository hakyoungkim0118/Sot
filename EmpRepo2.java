package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpRepo2 {
	private Connection conn;

	public EmpRepo2() {
		conn = DBConnection.getConnection();
	}

	// findAll
	public List<EmpInfo> findAll() {
		EmpInfo emp = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;

		List<EmpInfo> empList = new ArrayList<EmpInfo>();
		
		try {
			String sql = "select * from emp";
			stmt = conn.prepareStatement(sql);
			rest = stmt.executeQuery();
			
			while (rest.next()) {
				emp = new EmpInfo();
				emp.setEmpno(rest.getInt(1));
				emp.setEname(rest.getString(2));
				emp.setJob(rest.getString(3));
				emp.setMgr(rest.getInt(4));
				emp.setHiredate(rest.getString(5));
				emp.setSal(rest.getInt(6));
				emp.setComm(rest.getInt(7));
				emp.setDeptno(rest.getInt(8));
				
				empList.add(emp);
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rest != null)
					rest.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("EmpInfoRepository에서 empInfo1에서 close 할때 ");
				System.out.println(ex.getErrorCode() + ex.getMessage() + ex.getSQLState());
			}
		}
		
		return empList;
	}

	//find by id
	public EmpInfo findById(int empNo) { 
			EmpInfo emp = null;
			PreparedStatement stmt = null;
			ResultSet rest = null;
			
			try {
				String sql = "select * from emp where empno = " + empNo;
				stmt = conn.prepareStatement(sql);
				rest = stmt.executeQuery(sql);
						
				while (rest.next()) {
					emp = new EmpInfo();
					emp.setEmpno(rest.getInt(1));
					emp.setEname(rest.getString(2));
					emp.setJob(rest.getString(3));
					emp.setMgr(rest.getInt(4));
					emp.setHiredate(rest.getString(5));
					emp.setSal(rest.getInt(6));
					emp.setComm(rest.getInt(7));
					emp.setDeptno(rest.getInt(8));
				}
			System.out.println("나와라결과야 "+emp);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				System.out.println("백종원2");
				try {
					if(rest != null) rest.close();
					if(stmt != null) stmt.close();
				}catch(SQLException ex){
					System.out.println("EmpInfoRepository에서 empInfo1에서 close 할때 ");
					System.out.println(ex.getErrorCode()+ex.getMessage()+ex.getSQLState());
				}
			}
			return emp;
		}
	
	//find by Dept
	public StringBuilder findByDept(int deptNo) {
		EmpInfo emp = null;
		DeptInfo dept = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			String sql = "select * from emp, dept where emp.deptno ="+ deptNo + "and dept.deptno =" + deptNo;
			stmt = conn.prepareStatement(sql);
			rest = stmt.executeQuery(sql);
					
			while (rest.next()) {
				emp = new EmpInfo();
				emp.setEmpno(rest.getInt(1));
				emp.setEname(rest.getString(2));
				emp.setJob(rest.getString(3));
				emp.setMgr(rest.getInt(4));
				emp.setHiredate(rest.getString(5));
				emp.setSal(rest.getInt(6));
				emp.setComm(rest.getInt(7));
				emp.setDeptno(rest.getInt(8));
				dept = new DeptInfo();
				dept.setDeptno(rest.getInt(9));
				dept.setDname(rest.getString(10));
				dept.setLoc(rest.getString(11));
				
				sb.append(emp);
				sb.append(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("백종원2");
			try {
				if(rest != null) rest.close();
				if(stmt != null) stmt.close();
			}catch(SQLException ex){
				System.out.println("EmpInfoRepository에서 empInfo1에서 close 할때 ");
				System.out.println(ex.getErrorCode()+ex.getMessage()+ex.getSQLState());
			}
		}
		return sb;
	}

}
