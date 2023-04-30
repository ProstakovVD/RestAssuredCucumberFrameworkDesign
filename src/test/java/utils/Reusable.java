package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reusable {

	private static RequestSpecification req;
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\GlobalData.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
			
			PrintStream log = new PrintStream(new FileOutputStream("reports//logging.txt"));
			req = new RequestSpecBuilder()
				.setBaseUri(getGlobalValue("QAUrl"))
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
			return req;
		
		}
		return req;
		
	}
	
	public static String getJsonPath(Response response, String key) {
		
		JsonPath jp = new JsonPath(response.asString());
		return jp.get(key).toString();
		
	}
	
}
