package com.sample.demo.association.jointable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class app {
	  public static void main(String[] args) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("spy1.properties");

			// set the properties value
			prop.setProperty("realdriver", "com.mysql.jdbc.Driver");
			prop.setProperty("appender", "com.p6spy.engine.logging.appender.StdoutLogger");
			prop.setProperty("logfile", "spy.log");

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	  }
	}