/**
 * 
 */
package com.songo.gather.weixin.mp.utils;

/**
 * <p>decription:</p>
 * <p>date:2015年4月22日 下午4:43:19</p>
 * @author gsu·napoleon
 */
public enum GlobalReturnCode {

	SYSTEM_BUSY(-1, "系统繁忙，此时请开发者稍候再试"),
	SUCCESS(0, "请求成功"),
	APP_SECRET_ERROR_OR_ACCESS_TOKEN_INVALID(40001, "获取access_token时AppSecret错误，或者access_token无效"),
	ILLEGAL_CERTIFICATE_TYPE(40002, "不合法的凭证类型"),
	ILLEGAL_OPEN_ID(40003, "不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID"),
	ILLEGAL_MEDIA_FILE_TYPE(40004, "不合法的媒体文件类型"),
	ILLEGAL_FILE_TYPE(40005, "不合法的文件类型"),
	ILLEGAL_FILE_SIZE(40006, "不合法的文件大小"),
	ILLEGAL_MEDIA_FILE_ID(40007, "不合法的媒体文件id"),
	ILLEGAL_INFORMATION_TYPE(40008, "不合法的消息类型"),
	ILLEGAL_IMAGE_FILE_SIZE(40009, "不合法的图片文件大小"),
	ILLEGAL_VOICE_FILE_SIZE(40010, "不合法的语音文件大小"),
	ILLEGAL_VIDEO_FILE_SIZE(40011, "不合法的视频文件大小"),
	ILLEGAL_THUMBNAILS_FILE_SIZE(40012, "不合法的缩略图文件大小"),
	ILLEGAL_APP_ID(40013, "不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写"),
	ILLEGAL_ACCESS_TOKEN(40014, "不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口"),
	ILLEGAL_MEUN_TYPE(40015, "不合法的菜单类型"),
	ILLEGAL_BUTTON_NUMBER(40016, "不合法的按钮个数"),
	ILLEGAL_BUTTON_NUMBERS(40017, "不合法的按钮个数"),
	ILLEGAL_BUTTON_NAME_LENGTH(40018, "不合法的按钮名字长度"),
	ILLEGAL_BUTTON_KEY_LENGTH(40019, "不合法的按钮KEY长度"),
	ILLEGAL_BUTTON_URL_LENGTH(40020, "不合法的按钮URL长度"),
	ILLEGAL_MENU_VERSION(40021, "不合法的菜单版本号"),
	ILLEGAL_SUB_MENU_LEVEL(40022, "不合法的子菜单级数"),
	ILLEGAL_SUB_MENU_BUTTON_NUMBER(40023, "不合法的子菜单按钮个数"),
	ILLEGAL_SUB_MENU_BUTTON_TYPE(40024, "不合法的子菜单按钮类型"),
	ILLEGAL_SUB_MENU_BUTTON_NAME_LENGTH(40025, "不合法的子菜单按钮名字长度"),
	ILLEGAL_SUB_MENU_BUTTON_KEY_LENGTH(40026, "不合法的子菜单按钮KEY长度"),
	ILLEGAL_SUB_MENU_BUTTON_URL_LENGTH(40027, "不合法的子菜单按钮URL长度"),
	ILLEGAL_CUSTOM_MENU_OF_USER(40028, "不合法的自定义菜单使用用户"),
	ILLEGAL_OAUTH_CODE(40029, "不合法的oauth_code"),
	ILLEGAL_REFRESH_TOKEN(40030, "不合法的refresh_token"),
	ILLEGAL_OPENID_TABLES(40031, "不合法的openid列表"),
	ILLEGAL_OPENID_TABLES_LENGTH(40032, "不合法的openid列表长度"),
	ILLEGAL_REQUEST_CHARACTER(40033, "不合法的请求字符，不能包含\\uxxxx格式的字符"),
	ILLEGAL_PARAMATER(40035, "不合法的参数"),
	ILLEGAL_REQUEST_FORMAT(40038, "不合法的请求格式"),
	ILLEGAL_URL_LENGTH(40039, "不合法的URL长度"),
	ILLEGAL_GROUP_ID(40050, "不合法的分组id"),
	ILLEGAL_GROUP_NAME(40051, "分组名字不合法"),
	RMIT_ACCESS_TOKEN_PARAMATER(41001, "缺少access_token参数"),
	RMIT_APP_ID_PARAMATER(41002, "缺少appid参数"),
	RMIT_REFRESH_TOKEN_PARAMATER(41003, "缺少refresh_token参数"),
	RMIT_SECRET_PARAMATER(41004, "缺少secret参数"),
	RMIT_MEDIA_FILE_DATA(41005, "缺少多媒体文件数据"),
	RMIT_MEDIA_ID_PARAMATER(41006, "缺少media_id参数"),
	RMIT_SUB_MENU_DATA(41007, "缺少子菜单数据"),
	RMIT_OAUTH_CODE(41008, "缺少oauth code"),
	RMIT_OPENID(41009, "缺少openid"),
	TIMEOUT_ACCESS_TOKEN(42001, "access_token超时，请检查access_token的有效期，请参考基础支持-获取access_token中，对access_token的详细机制说明"),
	TIMEOUT_REFRESH_TOKEN(42002, "refresh_token超时"),
	TIMEOUT_OAUTH_CODE(42003, "oauth_code超时"),
	NEEDS_GET_REQUEST(43001, "需要GET请求"),
	NEEDS_POST_REQUEST(43002, "需要POST请求"),
	NEEDS_HTTPS_REQUEST(43003, "需要HTTPS请求"),
	NEEDS_RECIPIENT_REQUEST(43004, "需要接收者关注"),
	NEEDS_FRIEND_RELATIONS(43005, "需要好友关系"),
	NULL_MEDIA_FILE(44001, "多媒体文件为空"),
	NULL_POST_PACKET(44002, "POST的数据包为空"),
	NULL_IMAGE_INFORMATION_CONTENT(44003, "图文消息内容为空"),
	NULL_TEXT_CONTENT(44004, "文本消息内容为空"),
	RESTRICTION_MEDIA_FILE_SIZE(45001, "多媒体文件大小超过限制"),
	RESTRICTION_INFORMATION_CONTENT(45002, "消息内容超过限制"),
	RESTRICTION_TITLE_FIELDS(45003, "标题字段超过限制"),
	RESTRICTION_DESCRIPTION_FIELDS(45004, "描述字段超过限制"),
	RESTRICTION_LINK_FIELDS(45005, "链接字段超过限制"),
	RESTRICTION_IMAGE_LINK_FILEDS(45006, "图片链接字段超过限制"),
	RESTRICTION_VOICE_BROADCAST_TIME(45007, "语音播放时间超过限制"),
	RESTRICTION_IMAGE_INFORMATION(45008, "图文消息超过限制"),
	RESTRICTION_INTERFACE_CALLABLE(45009, "接口调用超过限制"),
	RESTRICTION_CREATE_MENU_NUMBERS(45010, "创建菜单个数超过限制"),
	RESTRICTION_REPLY_TIME(45015, "回复时间超过限制"),
	RESTRICTION_GROUP_NOT_ALLOW_MODIFICATION(45016, "系统分组，不允许修改"),
	RESTRICTION_GROUP_NAME_LENGTH(45017, "分组名字过长"),
	RESTRICTION_GROUP_NAME_NUMBERS(45018, "分组数量超过上限"),
	NOT_EXISTS_MEIDA_DATA(46001, "不存在媒体数据"),
	NOT_EXISTS_MENU_VERSIONS(46002, "不存在的菜单版本"),
	NOT_EXISTS_MENU_DATA(46003, "不存在的菜单数据"),
	NOT_EXISTS_USER(46004, "不存在的用户"),
	ERROR_JSON_OR_XML_CONTENT(47001, "解析JSON/XML内容错误"),
	API_UNAUTHORIZED(48001, "api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限"),
	API_USER_UNAUTHORIZED(50001, "用户未授权该api"),
	INVALID_PARAMETER(61451, "参数错误(invalid parameter)"),
	INVALID_KF_ACCOUNT(61452, "无效客服账号(invalid kf_account)"),
	EXSITED_KF_ACCOUNT(61453, "客服帐号已存在(kf_account exsited)"),
	INVALID_KF_ACCOUNT_LENGTH(61454, "客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid kf_acount length)"),
	ILLEGAL_CHARACTER_IN_KF_ACCOUNT(61455, "客服帐号名包含非法字符(仅允许英文+数字)(illegal character in kf_account)"),
	KF_ACCOUNT_COUNT_EXCEEDED(61456, "客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)"),
	INVALID_FILE_TYPE(61457, "无效头像文件类型(invalid file type)"),
	SYSTEM_ERROR(61450, "系统错误(system error)"),
	ERROR_DATE_FORMAT(61500, "日期格式错误"),
	ERROR_DATE_RANGE(61501, "日期范围错误"),
	INVALID_POST_DATA_PARAMETER(9001001, "POST数据参数不合法"),
	UNAVAILABLE_REMOTE_SERVICE(9001002, "远端服务不可用"),
	INVALID_TICKET(9001003, "Ticket不合法"),
	FAILED_GET_USERINFO_OF_PERIPHERY(9001004, "获取摇周边用户信息失败"),
	FAILED_GET_BUSINESS_INFO(9001005, "获取商户信息失败"),
	FAILED_GET_OPEN_ID(9001006, "获取OpenID失败"),
	UPLOAD_MISSING_FILE(9001007, "上传文件缺失"),
	UPLOAD_FILE_TYPE_MATERIAL_IS_NOT_LEGITIMATE(9001008, "上传素材的文件类型不合法"),
	UPLOAD_FILE_LENGTH_MATERIAL_IS_NOT_LEGITIMATE(9001009, "上传素材的文件尺寸不合法"),
	UPLOAD_FAILED(9001010, "上传失败"),
	ILLEGAL_ACCOUNT(9001020, "帐号不合法"),
	NOT_THE_NEW_EQUIPMENT(9001021, "已有设备激活率低于50%，不能新增设备"),
	ILLEGAL_EQUIPMENT_APPLY_NUMBERS(9001022, "设备申请数不合法，必须为大于0的数字"),
	AUDIT_DEVICE_ID_APPLICATION_ALREADY_EXISTS(9001023, "已存在审核中的设备ID申请"),
	QUERY_DEVICE_ID_NUMBER_NOT_MORE_THAN_FIFTY(9001024, "一次查询设备ID数量不能超过50"),
	ILLEGAL_DEVICE_ID(9001025, "设备ID不合法"),
	ILLEGAL_PAGE_ID(9001026, "页面ID不合法"),
	ILLEGAL_PAGE_PARAMETERS(9001027, "页面参数不合法"),
	REMOVE_PAGE_ID_NUMBERS_NOT_MORE_THAN_TEN(9001028, "一次删除页面ID数量不能超过10"),
	PAGE_USED_IN_DEVICE_OF_FIRST_REMOVE_AND_DELETE(9001029, "页面已应用在设备中,请先解除应用关系再删除"),
	QUERY_PAGE_ID_NUMBERS_NOT_MORE_THAN_FIFTY(9001030, "一次查询页面ID数量不能超过50"),
	ILLEGAL_TIME_INTERVAL(9001031, "时间区间不合法"),
	SAVE_BINDING_BETWEEN_DEVICE_AND_PAGE_IS_PARAMETER_ERROR(9001032, "保存设备与页面的绑定关系参数错误"),
	ILLEGAL_STORES_ID(9001033, "门店ID不合法"),
	ILLEGAL_DEVICE_BAK_INFO(9001034, "设备备注信息过长"),
	ILLEGAL_DEVICE_APPLY_PARAMETER(9001035, "设备申请参数不合法"),
	ILLEGAL_QUERY_START_VALUE(9001036, "查询起始值begin不合法"),
	CUSTOM_NULL_APP_ID(8888001, "APPID is null"),
	CUSTOM_NULL_APP_SECRET(8888002, "APPSECRET is null"),
	CUSTOM_NULL_REDIRECT_URI(8888003, "redirectUri is null"),
	CUSTOM_NULL_OPEN_ID(8888004, "openid is null"),
	CUSTOM_NULL_ACCESS_TOKEN(8888005, "access token is null"),;
	
	private long code;
	private String explanation;
	
	private GlobalReturnCode(long code, String explanation) {
		this.code = code;
		this.explanation = explanation;
	}
	
	/**
	 * @return the code
	 */
	public long getCode() {
		return this.code;
	}

	/**
	 * @return the explanation
	 */
	public String getExplanation() {
		return this.explanation;
	}
}

	
