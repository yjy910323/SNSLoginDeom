package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import unti.UnifiedOAuth;

import com.renren.api.client.RenrenApiConfig;
import com.renren.api.client.utils.HttpURLUtils;

import constants.AppConstants;

import net.sf.json.util.WebUtils;

public class TaobaoAccessServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
        if (code == null || code.length() == 0) {
            response.sendRedirect("login");
            return;
        }
        String tbPostSessionUrl =  "https://oauth.taobao.com/token";

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", AppConstants.TAOBAO_API_KEY);
        parameters.put("client_secret", AppConstants.TAOBAO_API_SECRET);
        parameters.put("redirect_uri", AppConstants.TAOBAO_API_URI);//杩欎釜redirect_uri瑕佸拰涔嬪墠浼犵粰authorization endpoint鐨勫�涓�牱
        parameters.put("grant_type", "authorization_code");
        parameters.put("code", code);
        String tokenResult = HttpURLUtils.doPost(tbPostSessionUrl, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        //System.out.println(tokenJson);
        UnifiedOAuth uoa = UnifiedOAuth.parse(tokenJson, AppConstants.TAOBAO);
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
