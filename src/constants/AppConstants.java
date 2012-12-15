package constants;

import kx2_4j.KaixinConfig;
import t4j.NwbConfig;
import weibo4j.util.WeiboConfig;

import com.baidu.api.BaiduConfig;
import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.renren.api.client.RenrenApiConfig;
import com.tencent.weibo.constants.APIConstants;

public class AppConstants {
	
	
	
	public static final String RENREN = "Renren";
	public static final String RENREN_API_KEY = RenrenApiConfig.renrenAppID;
	public static final String RENREN_API_SERCET = RenrenApiConfig.renrenApiSecret;
	public static final String RENREN_API_URL = RenrenApiConfig.renrenApiUrl;
	public static final String RENREN_API_ID = RenrenApiConfig.renrenAppID;
	 
	public static final String WEIBO = "Weibo";
	public static final String WEIBO_API_KEY = WeiboConfig.getValue("client_ID");
	public static final String WEIBO_API_SECRET = WeiboConfig.getValue("client_SERCRET");
	public static final String WEIBO_API_URI = WeiboConfig.getValue("redirect_URI");
	 
	public static final String DOUBAN = "Douban";
	public static final String DOUBAN_API_KEY = DefaultConfigs.API_KEY;
	public static final String DOUBAN_API_SECRET = DefaultConfigs.SECRET_KEY;
	 //public static final String DOUBAN_API_URL = DefaultConfigs.API_URL_PREFIX;
	 
	public static final String QWB = "Qwb";
	public static final String QWB_API_KEY = APIConstants.API_KEY;
	public static final String QWB_API_SECRET = APIConstants.API_SERCET;
	public static final String QWB_API_URI = APIConstants.API_URI;
	
	public static final String KAIXIN = "Kaixin";
	public static final String KAIXIN_API_KEY = KaixinConfig.getValue("client_KEY");
	public static final String KAIXIN_API_ID = KaixinConfig.getValue("client_ID");
	public static final String KAIXIN_API_SECRET = KaixinConfig.getValue("client_SECRET");
	public static final String KAIXIN_API_URI = KaixinConfig.getValue("redirect_URI");
	
	public static final String BAIDU = "Baidu";
	public static final String BAIDU_API_ID = BaiduConfig.getValue("client_ID");
	public static final String BAIDU_API_KEY = BaiduConfig.getValue("client_KEY");
	public static final String BAIDU_API_SECRET = BaiduConfig.getValue("client_SECRET");
	public static final String BAIDU_API_URI = BaiduConfig.getValue("redirect_URI");
	
	public static final String NWB = "Nwb";
	public static final String NWB_API_KEY = NwbConfig.getValue("tblog4j.oauth.consumerKey");
	public static final String NWB_API_SECRET = NwbConfig.getValue("tblog4j.oauth.consumerSecret");
	public static final String NWB_API_URI = NwbConfig.getValue("tblog4j.oauth.uri");
	
	public static final String TAOBAO = "Taobao";
	public static final String TAOBAO_API_KEY = "12622343";
	public static final String TAOBAO_API_SECRET = "6558f135800dd5e86b6c163ce3ac77dd";
	public static final String TAOBAO_API_URI = "http://127.0.0.1/SNSLogin/taobao_login";
	
	
	
	
}