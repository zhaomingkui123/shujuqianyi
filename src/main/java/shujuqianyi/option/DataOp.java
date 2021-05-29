package shujuqianyi.option;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataOp {

	@Autowired
	private DataSource datasource;

	public int insertImage(String path) throws Exception {
		System.out.println("----insertPhoto");
		Connection conn = null;
		int i = 0;
		Statement st = null;
		ResultSet rs = null;
		conn = datasource.getConnection();

		conn.setAutoCommit(false);// 设置数据库为不自动提交，必须的一步
		st = conn.createStatement();// 获取一个可以执行sql语句的对象

		i = st.executeUpdate("insert into DATAOUTANDIN (id,some) values ('3','1')");

		rs = st.executeQuery("select some from DATAOUTANDIN where id='3' for update");
		if (rs.next()) {
			// 得到流
			oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob(1);
			// 从得到的低级流构造一个高级流
			PrintStream ps = new PrintStream(clob.getAsciiOutputStream());
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
			byte[] buff = new byte[1024];
			int n = 0;
			// 从输入到输出
			while ((n = bis.read(buff)) != -1) {
				ps.write(buff, 0, n);

			}
			// 清空流的缓存
			ps.flush();
			// 关闭流，注意一定要关
			ps.close();
			bis.close();
		}
		conn.commit();
		rs.close();
		st.close();
		conn.close();
		return i;
	}

	public int getImage() throws Exception {
		int j = 0;
		Statement st = null;
		ResultSet rs = null;
		Connection conn = datasource.getConnection();
		conn.setAutoCommit(false);// 设置数据库为不自动提交，必须的一步
		st = conn.createStatement();// 获取一个可以执行sql语句的对象
		rs = st.executeQuery("select t.id,t.some from DATAOUTANDIN t");
		// if (rs.next()) {
		// java.sql.Clob clob = rs.getClob(2);
		// InputStream ins = clob.getAsciiStream();
		// // 用文件模拟输出流
		// File file = new File("d:\\tttttttttttttt.PNG");
		// OutputStream fout = new FileOutputStream(file);
		// // 下面将BLOB数据写入文件
		// byte[] b = new byte[1024];
		// int len = 0;
		// while ((len = ins.read(b)) != -1) {
		// fout.write(b, 0, len);
		// }
		if (rs.next()) {
			String id = rs.getString(1);
			java.sql.Clob clob = rs.getClob(2);
			InputStream ins = clob.getAsciiStream();
			// 用文件模拟输出流
//			File file = new File("d:\\tttttttttttttt.PNG");
			OutputStream fout = new ByteArrayOutputStream();
			// 下面将BLOB数据写入文件
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = ins.read(b)) != -1) {
				fout.write(b, 0, len);
			}
			// 依次关闭
			j = 2;
			fout.close();
			ins.close();
			conn.commit();
			conn.close();
		}
		rs.close();
		st.close();
		return j;
	}
}
