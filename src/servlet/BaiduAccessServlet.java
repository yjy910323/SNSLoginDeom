package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.api.BaiduOAuth2Client;
import com.baidu.api.BaiduOAuthException;
import com.baidu.api.BaiduOAuthToken;

import constants.AppConstants;

public class BaiduAccessServlet extends HttpServlet {

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
        
        BaiduOAuth2Client bo2c = new BaiduOAuth2Client(AppConstants.BAIDU_API_KEY,AppConstants.BAIDU_API_SECRET);
        bo2c.setRedirectUri(AppConstants.BAIDU_API_URI);
        try {
        	BaiduOAuthToken at = bo2c.getAccessTokenByAuthorizationCode(code);
        	System.out.println(at);
		} catch (BaiduOAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
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
