package cn.itcast.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.UserInfo;
import cn.itcast.ssm.service.ItemsService;
import net.sf.json.JSONObject;

@Controller
public class LoginController{
	
	@Autowired
	private ItemsService itemsService;
	
	// 登陆
	@RequestMapping("/login")
	
	public @ResponseBody Map<String, Object> login(HttpSession session, String username,String password)
			throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String success_true="/items/nav.action";

		// 调用service进行用户身份验证
		UserInfo uf =new UserInfo();
		uf.setUsername(username);
		uf.setPassword(password);

		Boolean islogin = itemsService.findUserByNameAndPassword(uf);

		if(Boolean.TRUE.equals(islogin)==false){
			String messagewarming ="用户名或密码错误!";
			map.put("error", messagewarming);  
			return map;
			
		}
//		if(Boolean.TRUE.equals(islogin)){
//			// 在session中保存用户身份信息
//			session.setAttribute("username", userinfo.getUsername());
//			// 重定向到商品列表页面
//			return "redirect:/items/queryItems.action";
//		}
		// 在session中保存用户身份信息
		session.setAttribute("username", username);
		session.setAttribute("password", password);

		map.put("success", true);
		map.put("success_redict", success_true);
		session.setAttribute("islogin", map);
		// 重定向到商品列表页面
		return map;

		

	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

}
