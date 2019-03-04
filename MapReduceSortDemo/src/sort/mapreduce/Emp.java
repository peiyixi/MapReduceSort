package sort.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

//代表员工
//数据：7369,SMITH,CLERK,7902,1980/12/17,800,0,20
public class Emp implements WritableComparable<Emp> {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredata;
	private int sal;
	private int comm;
	private int deptno;
//	@Override
//	public int compareTo(Emp o) {
//		// 定义自己的排序规则
//		//按照薪水进行排序
//		if(this.sal>=o.sal) {
//			return 1;
//		}else {
//			return -1;
//		}
//
//	}
	@Override
	public int compareTo(Emp o) {
		// 定义自己的排序规则
		//先按照部门号排序，再照薪水进行排序
		//注意：没有“=”
		if(this.deptno>o.getDeptno()) {
			return 1;
		}else if(this.deptno<o.getDeptno()){
			return -1;
		}
		
		//当部门号相等时 按照工资排序
		if(this.sal>=o.sal) {
			return 1;
		}else {
			return -1;
		}

	}
	// 序列化的顺序要和反序列化的顺序一样
	@Override
	public void readFields(DataInput input) throws IOException {
		// 实现反序列化，从输入流中读取对象
		this.empno = input.readInt();
		this.ename = input.readUTF();
		this.job = input.readUTF();
		this.mgr = input.readInt();
		this.hiredata = input.readUTF();
		this.sal = input.readInt();
		this.comm = input.readInt();
		this.deptno = input.readInt();

	}

	@Override
	public void write(DataOutput output) throws IOException {
		// 实现序列化，把对象输出到输出流
		output.writeInt(empno);
		output.writeUTF(ename);
		output.writeUTF(job);
		output.writeInt(mgr);
		output.writeUTF(hiredata);
		output.writeInt(sal);
		output.writeInt(comm);
		output.writeInt(deptno);

	}

	@Override
	public String toString() {	
		return "Emp [empno="+empno+",ename="+ename+",sal="+sal+",deptno="+deptno+"]";
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredata() {
		return hiredata;
	}

	public void setHiredata(String hiredata) {
		this.hiredata = hiredata;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}




}
