package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import unti.UnifiedOAuth;

import com.renren.api.client.RenrenApiClient;
import com.renren.api.client.RenrenApiConfig;
import com.renren.api.client.utils.HttpURLUtils;

import constants.AppConstants;

/**
 * 浜轰汉杩炴帴鐨勭櫥褰曠晫闈紝灏嗚烦杞埌浜轰汉缃戣处鍙风櫥闄嗙晫闈紝
 * @author Administrator
 *
 */
public class RenrenAccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenrenAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                                  throws ServletException,
                                                                                  IOException {
        // TODO Auto-generated method stub
        String code = request.getParameter("code");
        if (code == null || code.length() == 0) {
            //缂轰箯鏈夋晥鍙傛暟锛岃烦杞埌鐧诲綍椤靛�?
            response.sendRedirect("login");
            return;
        }
        
        
        String rrOAuthTokenEndpoint = "https://graph.renren.com/oauth/token";
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", RenrenApiConfig.renrenApiKey);
        parameters.put("client_secret", RenrenApiConfig.renrenApiSecret);
        parameters.put("redirect_uri", "http://127.0.0.1:8080/SNSLogin/renren_login");//杩欎釜redirect_uri瑕佸拰涔嬪墠浼犵粰authorization endpoint鐨勫�涓�牱
        parameters.put("grant_type", "authorization_code");
        parameters.put("code", code);
        String tokenResult = HttpURLUtils.doPost(rrOAuthTokenEndpoint, parameters);
        JSONObject tokenJson = (JSONObject) JSONValue.parse(tokenResult);
        //System.out.println(tokenJson);
        UnifiedOAuth uoa = UnifiedOAuth.parse(tokenJson, AppConstants.RENREN);
        uoa.print();
        
        
        RenrenApiClient rac = RenrenApiClient.getInstance();
        int id = rac.getUserService().getLoggedInUser(uoa.toRenrenAccessToken());
        System.out.println(rac.getUserService().getInfo(String.valueOf(id),"uid,name,sex,star,zidou,vip,birthday,tinyurl,headurl,mainurl,hometown_location,work_history,university_history,hs_info,work_info,email_hash",uoa.toRenrenAccessToken()));
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        // TODO Auto-generated method stub
    }

}
