package com.kernel.action;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.kernel.httputil.DWHttpClient;
import com.kernel.httputil.DWHttpResponse;
import com.kernel.util.PropUtil;

public class IndexPageAction {
	private DWHttpClient request = new DWHttpClient();
	private DWHttpResponse response;
	private String url;
	private static PropUtil PropUtil = new PropUtil(
			"config/httptest.properties");
	private static Logger logger = Logger.getLogger(IndexPageAction.class);
	String baseUrl;

	/**
	 * 初始化，构造登录请求URL连接
	 */
	public IndexPageAction() {
		baseUrl = PropUtil.get("baseUrl") + "/view/index.html";
		logger.debug("url is :" + url);

	}

	//发送请求，并得到返回结果
	public boolean login() {
		boolean flag = false;
		response = request.sendGetRequest(baseUrl);
		response.printResponse();
		if (response.getStatusCode() == 200) {
			flag = true;
			logger.debug("---------------Enter indexPage success---------------");
		}
		return flag;

	}

}
