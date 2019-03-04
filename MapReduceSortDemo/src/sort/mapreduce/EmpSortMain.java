package sort.mapreduce;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class EmpSortMain {

	public static void main(String[] args) throws Exception {
		//1、创建任务对象 定义主程序入口
				Job job = Job.getInstance(new Configuration());
				job.setJarByClass(EmpSortMain.class);
			   //2、setMapper
				
				job.setMapperClass(EmpSortMapper.class);
				job.setMapOutputKeyClass(Emp.class);
				job.setMapOutputValueClass(NullWritable.class);
				//指定自己的比较规则
				//job.setSortComparatorClass(MyNumberComparator.class);
				//3、setReducer
				//job.setReducerClass(EmpInfoReducer.class);
				job.setOutputKeyClass(Emp.class);
				job.setOutputValueClass(NullWritable.class);
				//4、定义输入和输出
				FileInputFormat.setInputPaths(job, new Path(args[0]));
				FileOutputFormat.setOutputPath(job,new Path(args[1]));
				//5、执行程序
				job.waitForCompletion(true);
	}

}
