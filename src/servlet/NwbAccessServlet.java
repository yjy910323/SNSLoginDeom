package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import t4j.OAuthVersion;
import t4j.TBlog;
import t4j.TBlogException;
import t4j.http.OAuth2AccessToken;

import com.renren.api.client.RenrenApiConfig;
import com.renren.api.client.utils.HttpURLUtils;

import constants.AppConstants;

public class NwbAccessServlet extends HttpServlet {

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
        
        TBlog tblog = new TBlog(OAuthVersion.V2);
        tblog.setRedirectURL(AppConstants.NWB_API_URI);
        try {
			OAuth2AccessToken at = tblog.getOAuth2AccessTokenByCode(code);
			System.out.println(at);
		} catch (TBlogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        
        
        
//        String nwbOAuthTokenEndpoint = "https://api.t.163.com/oauth2/access_token";
//        
//        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("client_id",AppConstants.NWB_API_KEY);
//        parameters.put("client_secret",AppConstants.NWB_API_SECRET);
//        parameters.put("redirect_uri", URLEncoder.encode(AppConstants.NWB_API_URI,("UTF-8")));//杩欎釜redirect_uri瑕佸拰涔嬪墠浼犵粰authorization endpoint鐨勫�涓�牱
//        parameters.put("grant_type", "authorization_code");
//        parameters.put("code", code);
//        
//        
//        String tokenResult = HttpURLUtils.doPost(nwbOAuthTokenEndpoint, parameters);
//        //JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
//        System.out.println(tokenResult);
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
