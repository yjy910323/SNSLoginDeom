package unti;

import org.json.simple.JSONObject;

import constants.AppConstants;


public class UnifiedOAuth {
	private String accessToken;
	private String refreshToken;
	private String expiresIn;
	private String type;
	
	
	public UnifiedOAuth(){
		
	}
	
	
	public UnifiedOAuth(String accessToken,String refreshToken,String expiresIn,String type){
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expiresIn = expiresIn;
		this.type = type;
	}
	
	//开心转换
	public static UnifiedOAuth parse(kx2_4j.http.AccessToken at){
		return new UnifiedOAuth(at.getToken(),at.getRefresh_Token(),"2592000",AppConstants.KAIXIN);
	}
	
	//微博转换
	public static UnifiedOAuth parse(weibo4j.http.AccessToken at){
		return new UnifiedOAuth(at.getAccessToken(),at.getRefreshToken(),at.getExpireIn(),AppConstants.WEIBO);
	}
	
	//豆瓣转换
	public static UnifiedOAuth parse(com.dongxuexidu.douban4j.model.app.AccessToken at){
		return new UnifiedOAuth(at.getAccessToken(),at.getRefreshToken(),at.getExpiresIn().toString(),AppConstants.DOUBAN);
	}
	
	//百度转换
	public static UnifiedOAuth parse(com.baidu.api.BaiduOAuthToken at){
		return new UnifiedOAuth(at.getAccessToken(),at.getRefreshToken(),String.valueOf(at.getExpiresIn()),AppConstants.BAIDU);
	}
	
	//网易微博转换
	public static UnifiedOAuth parse(t4j.http.OAuth2AccessToken at){
		return new UnifiedOAuth(at.getAccess_token(),at.getRefresh_token(),String.valueOf(at.getExpires_in()),AppConstants.NWB);
	}
	
	//将标准json转换成oauth
	public static UnifiedOAuth parse(JSONObject json){
		UnifiedOAuth uoa = new UnifiedOAuth();
		uoa.setType(json.get("type").toString());
		uoa.setAccessToken(json.get("accessToken").toString());
		uoa.setExpiresIn(json.get("expiresIn").toString());
		uoa.setRefreshToken(json.get("refreshToken").toString());
		return null;
	}
	

	//JSON & Type 转换
	public static UnifiedOAuth parse(JSONObject json,String type){
		UnifiedOAuth uoa = new UnifiedOAuth();
		if(type.equals(AppConstants.RENREN)){
			uoa.setType(AppConstants.RENREN);
			uoa.setAccessToken(json.get("access_token").toString());
			uoa.setExpiresIn(json.get("expires_in").toString());
			uoa.setRefreshToken(json.get("refresh_token").toString());
		}
		if(type.equals(AppConstants.TAOBAO)){
			uoa.setType(AppConstants.TAOBAO);
			uoa.setAccessToken(json.get("access_token").toString());
			uoa.setExpiresIn(json.get("expires_in").toString());
			uoa.setRefreshToken(json.get("refresh_token").toString());
		}
		return uoa;
	}
	
	
	
	public static UnifiedOAuth parse(String str,String type){
		UnifiedOAuth uoa = new UnifiedOAuth();
		if(type.equals(AppConstants.QWB)){
			String s[] = str.split("&");
			uoa.setType(AppConstants.QWB);
			uoa.setAccessToken(s[0].split("=")[1]);
			uoa.setExpiresIn(s[1].split("=")[1]);
			uoa.setRefreshToken(s[2].split("=")[1]);
		}
		return uoa;
		
	}
	
	
	public JSONObject toJSON(){
		JSONObject json = new JSONObject();
		json.put("accessToken", this.accessToken);
		json.put("refreshToken", this.refreshToken);
		json.put("expiresIn", this.expiresIn);
		json.put("type", this.type);
		return json;
	}
	
	
	
	
	public com.renren.api.client.param.impl.AccessToken toRenrenAccessToken(){
		return new com.renren.api.client.param.impl.AccessToken(this.accessToken);
	}
	
	
	//toString
	public String toString(){
		return this.type + " AccessToken:accessToken = " + this.accessToken + " refreshToken = " + this.refreshToken +
				" expiresIn = " + this.expiresIn;
	}
	//打印accessToken信息
	public void print(){
		System.out.println(this.toString());
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
