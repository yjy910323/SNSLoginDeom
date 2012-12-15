package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.AppConstants;

import unti.UnifiedOAuth;
import weibo4j.Account;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;

public class WeiboAccessServlet extends HttpServlet {

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
		
		try {
			Oauth oauth = new Oauth();
			//System.out.println(oauth.getAccessTokenByCode(code));
			UnifiedOAuth uoa = UnifiedOAuth.parse(oauth.getAccessTokenByCode(code));
			
			
			Users um = new Users();
			um.client.setToken(uoa.getAccessToken());
			Account am = new Account();
			am.client.setToken(uoa.getAccessToken());
			try {
				;
				User user = um.showUserById(am.getUid().get("uid").toString());
				System.out.println(user.toString());
			} catch (WeiboException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (WeiboException e) {
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
