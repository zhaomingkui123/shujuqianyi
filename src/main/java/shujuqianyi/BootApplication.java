package shujuqianyi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import shujuqianyi.option.DataOp;

@SpringBootApplication
public class BootApplication {

	
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = SpringApplication.run(BootApplication.class, args);

		DataOp dataOp = applicationContext.getBean(DataOp.class);
        //hulauadkfjajfja
		
		//dataOp.insertImage("C:\\Users\\Administrator\\Desktop\\捕获.PNG");
		
		System.out.println(dataOp.getImage());
		
		
	}

	

}
