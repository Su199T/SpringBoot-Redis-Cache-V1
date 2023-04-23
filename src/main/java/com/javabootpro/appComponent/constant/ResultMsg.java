package com.javabootpro.appComponent.constant;

public class ResultMsg {
    public static final String RESULT_NULL_OF_PAGE = "分页查询结果为空,请输入正确页数";

    //正则表达式
    public static final String RESULT_NOT_RIGHTFUL = "请求参数输入不合法";
    public static final String RESULT_REGISTER_NOT_RIGHTFUL = "输入不合法,只能为数字、字母、下划线组合";
    public static final String RESULT_REGISTER_ACCOUNT_NOT_RIGHTFUL = "账号ID不合法,只能为数字、字母、下划线组合";

    //登录注册相关
    public static final String RESULT_ACCESS_TOKEN_ERROR = "ACCESS TOKEN HEADER ERROR!";
    public static final String RESULT_PWD_NULL = "密码为空!";
    public static final String RESULT_NAME_NULL = "姓名为空!";
    public static final String RESULT_NAME_OR_PWD_NULL = "姓名或密码为空!";
    public static final String RESULT_ACCOUNT_NULL = "账户ID为空!";
    public static final String RESULT_NO_ACCOUNT = "没有该账户ID!";

    public static final String ACCOUNT_ALREADY_REGISTER = "已被注册,请更换一个账户ID.";
    public static final String ACCOUNT_REGISTER_OK = "账户ID注册成功.";
    public static final String RESULT_REGISTER_OK = "注册成功.";
    public static final String RESULT_REGISTER_ERROR = "注册失败!";
    public static final String RESULT_REGISTER_OK_AND_INFO = "请妥善保管好您的用户名、密码";
    //默认 管理
    public static final String ADMIN_DEFAULT_REGISTER_OK = "默认管理员注册到数据库成功.";
    public static final String ADMIN_DEFAULT_ALREADY_REGISTER = "默认管理员账号已经注册到数据库.";
    //非默认管理员
    public static final String ADMIN_NOT_DEFAULT_LOGIN_OK = "管理员账号登录成功.";
    public static final String ADMIN_NOT_DEFAULT_ALREADY_LOGIN = "您的管理员账号已经登录.";


    public static final String RESULT_NOT_REGISTER = "您还没有注册!";
    public static final String LOGIN_TYPE_ERROR = "登录类型错误!";
    public static final String LOGIN_OK= "登录成功.";
    public static final String LOGOUT_OK= "您已退出登录.";
    public static final String CHANGE_NAME_AND_PWD_SUCCESS ="姓名和密码已经修改.";
    public static final String CHANGE_NAME_AND_PWD_ERROR ="姓名和密码已经失败.";
    //token
    public static final String TOKEN_INVALID ="无效的token!";
    public static final String LOGIN_OK_AND_TOKEN_INFO = "登录成功,请保管好您的token.";
    public static final String LOGIN_OK_AND_ALREADY_HAVE_A_TOKEN = "登录成功,您已经收到过token";

    public static final String RESULT_REGISTER_ALREADY_HAVE_A_SAME_USER = "账号被注册.请更换姓名和密码.";

    //用户名和密码相同的用户存在多个!!!!!!!!!!!!!!!!!!!!
    public static final String UN_KNOW_USER ="您的账号出现问题,请联系客服申诉你的账号";

    //针对爬虫等用户
    public static final String CAN_NOT_VISIT ="你被限制访问!";

    //user status
    public static final String USER_STATUS_ONLINE = "用户处于登录状态.";
    public static final String USER_STATUS_OFFLINE = "用户处于离线状态.";
}
