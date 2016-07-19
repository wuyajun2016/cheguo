package com.kernel.httputil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.kernel.util.Base64;

/**
 * Utility that makes HTTP requests to the web service interfaces Other classes
 * will extend this utility to implement specific HTTP requests to unit test
 * each service method
 * 
 * @since 0.4.0
 */
public class DWHttpClient {

	private DefaultHttpClient client = new DefaultHttpClient();
	private Logger logger = Logger.getLogger(DWHttpClient.class);
	private static final String CHARSET = "UTF-8";

	/**
	 * Sends a HTTP GET request with the provided uri
	 * 
	 * @param url
	 *            the url to send the request to
	 * @return DWHttpResponse
	 */
	public DWHttpResponse sendGetRequest(String url) {
		HttpGet method = new HttpGet(url);
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("Content-Type",
				WebConstant.WEB_ACCEPT_HTML));
		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + url);
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("----------------------------------------------");
		
		DWHttpResponse response = sendRequest(method);
		return response;
	}

	/**
	 * Sends a HTTP POST request to the specified url
	 * 
	 * @param url
	 *            the url to send the request
	 * @param requestData
	 *            the data to send
	 * @return DWHttpResponse
	 */
	public DWHttpResponse sendPostRequest(String url, Map<String,String> body) {
		HttpPost method = new HttpPost(url);  //创建一个HttpPost对象
		method.addHeader(new BasicHeader("Accept", WebConstant.WEB_ACCEPT_JSON));
		method.addHeader(new BasicHeader("ContentType",
				WebConstant.WEB_CONTENT_TYPE_JSON));
		logger.debug("----------------------------------------------");
		logger.debug("Http Request Url : " + url);
		logger.debug("Http Request Method : " + method.getMethod());
		logger.debug("Http Request Headers : ");
		Header[] headers = method.getAllHeaders();
		for (Header h : headers) {
			logger.debug(h.getName() + ":" + h.getValue());
		}
		logger.debug("Http Request body : ");
		logger.debug(body);
		logger.debug("----------------------------------------------");

		DWHttpResponse response = null;

		try {
//			StringEntity se = new StringEntity(body, "utf-8");
//			se.setContentEncoding(WebConstant.CHARSET_UTF8);
//			se.setContentType(WebConstant.WEB_ACCEPT_JSON);
//			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	        nvps.add(new BasicNameValuePair("userName", body.get("username")));  
	        nvps.add(new BasicNameValuePair("password", Base64.decode(body.get("password"), "utf-8")));  
	        method.setEntity(new UrlEncodedFormEntity(nvps));
	        
			//method.setEntity(se); //使用HttpPost类的setEntity方法设置请求参数
			response = sendRequest(method);
		} catch (Exception e) {
			logger.error("sendPostRequest error : ", e);
		}

		return response;
	}

	/**
	 * This method sends an HTTP request based on the specified method
	 * 
	 * @param method
	 * @return DWHttpResponse
	 */
	private DWHttpResponse sendRequest(HttpRequestBase method) {

		DWHttpResponse res = new DWHttpResponse();
		HttpEntity entity = null;
		try {
			HttpResponse HttpResponse = client.execute(method);  //使用DefaultHttpClient类的execute方法发送HTTP GET或HTTP POST请求，并返回HttpResponse对象
			
			res.setStatusCode(HttpResponse.getStatusLine().getStatusCode());
			res.setStatusLine(HttpResponse.getStatusLine().toString());
			
			entity = HttpResponse.getEntity();  //通过HttpResponse接口的getEntity方法返回响应信息，并进行相应的处理
			String charset = EntityUtils.getContentCharSet(entity);  //取出应答字符串
			res.setBody(EntityUtils.toString(entity, charset));

			Header[] headers = HttpResponse.getAllHeaders();
			for (Header h : headers) {
				res.addHeader(h.getName(), h.getValue());
			}

		} catch (Exception e) {
			logger.error("sendRequest error : ", e);
		}

		return res;

	}
}
