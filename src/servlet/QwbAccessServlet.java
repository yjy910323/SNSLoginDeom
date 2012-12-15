package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unti.UnifiedOAuth;


import com.renren.api.client.utils.HttpURLUtils;
import com.tencent.weibo.oauthv2.OAuthV2;

import constants.AppConstants;

public class QwbAccessServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
        if (code == null || code.length() == 0) {
            response.sendRedirect("login");
            return;
        }
        
        String qwbOAuthTokenEndpoint = "https://open.t.qq.com/cgi-bin/oauth2/access_token";
        
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", AppConstants.QWB_API_KEY);
        parameters.put("client_secret", AppConstants.QWB_API_SECRET);
        parameters.put("redirect_uri", URLEncoder.encode(AppConstants.QWB_API_URI, "UTF-8"));
        parameters.put("grant_type", "authorization_code");
        parameters.put("code", code);
        String tokenResult = HttpURLUtils.doPost(qwbOAuthTokenEndpoint, parameters);
        //System.out.println(tokenResult);	
        UnifiedOAuth uoa = UnifiedOAuth.parse(tokenResult, AppConstants.QWB);
        uoa.print();
        
        
        
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		
	}

}
