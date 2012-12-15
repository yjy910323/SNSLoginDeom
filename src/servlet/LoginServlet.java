package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weibo4j.util.WeiboConfig;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.renren.api.client.RenrenApiConfig;

import constants.AppConstants;

public class LoginServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
        StringBuffer renrenparams = new StringBuffer();
        renrenparams.append("client_id=").append(AppConstants.RENREN_API_ID);
        renrenparams.append("&").append("response_type=").append("code");
        renrenparams.append("&").append("redirect_uri=").append("http://127.0.0.1:8080/SNSLogin/renren_login");
        //renrenparams.append("&").append("display=").append("page");
        renrenparams.append("&").append("scope=").append("read_user_status,status_update,read_user_feed,publish_feed,photo_upload");
        //renrenparams.append("&").append("x_renew=").append("true"); //璁剧疆姣忔浣跨敤浜轰汉杩炴帴鐢ㄦ埛閮介渶瑕佺櫥闄�
        
        
        
        StringBuffer weiboparams = new StringBuffer();
        weiboparams.append("client_id=").append(AppConstants.WEIBO_API_KEY);
        weiboparams.append("&").append("response_type=").append("code");
        weiboparams.append("&").append("redirect_uri=").append(URLEncoder.encode("http://127.0.0.1:8080/SNSLogin/weibo_login",("UTF-8")));
        weiboparams.append("&").append("scope=").append("friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog ");
        
        
        
        StringBuffer doubanparams = new StringBuffer();
        doubanparams.append("client_id=").append(DefaultConfigs.API_KEY);
        doubanparams.append("&").append("redirect_uri=").append(URLEncoder.encode("http://127.0.0.1:8080/SNSLogin/douban_login",("UTF-8")));
        doubanparams.append("&").append("response_type=").append("code");
        doubanparams.append("&").append("scope=").append("douban_basic_common,shuo_basic_r,shuo_basic_w,community_advanced_doumail_r,community_advanced_doumail_w,community_basic_note,book_basic_r,movie_basic_r,music_basic_r,event_basic_r,event_basic_w");
        
        
        StringBuffer qwbparams = new StringBuffer();
        qwbparams.append("client_id=").append(AppConstants.QWB_API_KEY);
        qwbparams.append("&").append("response_type=").append("code");
        qwbparams.append("&").append("redirect_uri=").append(URLEncoder.encode(AppConstants.QWB_API_URI,("UTF-8")));
        
        
        StringBuffer kaixinparams = new StringBuffer();
        kaixinparams.append("client_id=").append(AppConstants.KAIXIN_API_KEY);
        kaixinparams.append("&").append("response_type=").append("code");
        kaixinparams.append("&").append("redirect_uri=").append(URLEncoder.encode(AppConstants.KAIXIN_API_URI,("UTF-8")));
        kaixinparams.append("&").append("scope=").append("friends_birthday+friends_intro+friends_marriage+friends_blood+friends_bodyform+" +
        		"friends_education+friends_career+create_records+user_records+friends_records+create_album+user_photo friends_photo+" +
        		"upload_photo+user_messagebox+send_message+user_rgroup+user_diary+friends_diary+user_diary friends_diary+user_forward+" +
        		"places_checkin+user_places+friends_places+create_repaste+user_repaste+friends_repaste");
        
        
        
        StringBuffer baiduparams = new StringBuffer();
        baiduparams.append("client_id=").append(AppConstants.BAIDU_API_KEY);
        baiduparams.append("&").append("response_type=").append("code");
        baiduparams.append("&").append("redirect_uri=").append(URLEncoder.encode(AppConstants.BAIDU_API_URI,("UTF-8")));
        baiduparams.append("&").append("scope=").append("super_msg");
        
        
        
        StringBuffer nwbparams = new StringBuffer();
        nwbparams.append("client_id=").append(AppConstants.NWB_API_KEY);
        nwbparams.append("&").append("response_type=").append("code");
        nwbparams.append("&").append("redirect_uri=").append(URLEncoder.encode(AppConstants.NWB_API_URI,("UTF-8")));
        
        
        
        StringBuffer taobaoparams = new StringBuffer();
        taobaoparams.append("client_id=").append(AppConstants.TAOBAO_API_KEY);
        taobaoparams.append("&").append("response_type=").append("code");
        taobaoparams.append("&").append("redirect_uri=").append(URLEncoder.encode(AppConstants.TAOBAO_API_URI,("UTF-8")));
        
        
        
        
        request.setAttribute("renrenparams", renrenparams.toString());
        request.setAttribute("weiboparams", weiboparams.toString());
        request.setAttribute("doubanparams", doubanparams.toString());
        request.setAttribute("qwbparams", qwbparams.toString());
        request.setAttribute("kaixinparams", kaixinparams.toString());
        request.setAttribute("baiduparams", baiduparams.toString());
        request.setAttribute("nwbparams", nwbparams.toString());
        request.setAttribute("taobaoparams", taobaoparams.toString());
        
        
        
        RequestDispatcher welcomeDispatcher = request.getRequestDispatcher("/views/login.jsp");
        welcomeDispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
