package sort.mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


//只有k2可以排序	
public class EmpSortMapper extends Mapper<LongWritable,Text,Emp,NullWritable>{

	@Override
	protected void map(LongWritable k1, Text v1,Context context)
			throws IOException, InterruptedException {
		//数据：7369,SMITH,CLERK,7902,1980/12/17,800,0,20
		String data = v1.toString();
		String[] words = data.split(",");
		//生成员工对象
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(words[0]));
		emp.setEname(words[1]);
		emp.setJob(words[2]);
		emp.setMgr(Integer.parseInt(words[3]));
		emp.setHiredata(words[4]);
		emp.setSal(Integer.parseInt(words[5]));
		emp.setComm(Integer.parseInt(words[6]));
		emp.setDeptno(Integer.parseInt(words[7]));
		
		//输出员工对象					空值
		context.write(emp,NullWritable.get());
	}

}
