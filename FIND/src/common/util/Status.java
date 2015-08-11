package common.util;

public enum Status {		/*ö������*/
	/**
	 * 成功
	 */
	SUCCESS,
	/**
	 * 失败
	 */
	FAIL,
	/**
	 * 用户未登陆
	 */
	USER_NOT_LOGIN,
	/**
	 * 用户账户已存在
	 */
	USER_ACCONUT_EXIST,
	/**
	 * 用户密码错误
	 */
	USER_PASSWD_WRONG,
	/**
	 * 5���û���Ȩ�޷���
	 */
	ACCESS_DENIED,
	/**
	 * 6请求超时
	 */
	REQUEST_TIMEOUT,
	/**
	 * 请求过于频繁
	 */
	REQUEST_FREQUENT,
	/**
	 * 编码错误
	 */
	ENCODING_WRONG,
	/**
	 * 服务不可用
	 */
	SERVER_UNAVAILABLE,
	/**
	 * 参数错误
	 */
	PARAMETER_ERROR,
	/**
	 * 用户账户不存在
	 */
	 USER_ACCOUNT_NOT_EXIST,
	 /**
	  * 用户名错误
	  */
	 USER_NAME_WRONG,
	 /**
	  * 班级账号已存在
	  */
	 CLASS_ACCONUT_EXIST,
	 /**
	  * 班级账号不存在
	  */
	 CLASS_ACCONUT_NOT_EXIST,
	 /**
	  * 15 存在敏感词
	  */
	 SENSITIVE_WORD_TRUE,
	 /**
	  * 16 没有关注
	  */
	 NO_FOLLOW
	 
}
