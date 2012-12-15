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

import kx2_4j.KxException;
import kx2_4j.KxSDK;
import kx2_4j.http.AccessToken;

import com.renren.api.client.utils.HttpURLUtils;

import constants.AppConstants;

public class KaixinAccessServlet extends HttpServlet {

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
			KxSDK kaixinOAuth = new KxSDK();
			AccessToken at = kaixinOAuth.getOAuthAccessTokenFromCode(code);
			System.out.println(at.toString());
		} catch (KxException e) {
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
