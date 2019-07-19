package com.allinpay.core.constant;

/**
 * 公共常量类
 */
public class CommonConstant {
    /**
     * 图片存放子目录，营业执照图片
     */
    public static String SUB_DIR_LICENSE = "/license/";
    /**
     * 图片存放子目录，协议照片
     */
    public static String SUB_DIR_AGREEMENT = "/agreement/";
    /**
     * 图片存放子目录，身份证正面照
     */
    public static String SUB_DIR_FRONT = "/front/";
    /**
     * 图片存放子目录，身份证背面照
     */
    public static String SUB_DIR_BACK = "/back/";

    /**
     * 页面file域名称
     */
    public static String LICENSE_FILE = "licenseFile";
    public static String FRONT_FILE = "legalFront";
    public static String BACK_FILE = "legalBack";
    public static String AGREEMENT_FILE = "agreementFile";

    /**
     * 机构状态 1 正常 2 注销 3 冻结 4 审核中 5 审核成功 6 审核失败 7 未提交
     */
    public static Integer STATUS_NORMAL = 1;
    public static Integer STATUS_LOGOUT = 2;
    public static Integer STATUS_FROZEN = 3;
    public static Integer STATUS_AUDIT = 4;
    public static Integer STATUS_SUCCESS = 5;
    public static Integer STATUS_FAIL = 6;
    public static Integer STATUS_TEMP = 7;

    /**
     * 保存图片路径,如：D:\d\4\
     */
    public static String imagPath;

    /**
     * 银行基础信息数据状态、机构银行映射关系状态 0 禁用 1 有效
     */
    public static String BANK_STATUS_NORMAL = "1";
    public static String BANK_STATUS_ABNORMAL = "0";

    /**
     * 银行卡类型 1 借记卡 2 贷记卡
     */
    public static String CARD_TYPE_DEBT = "1";
    public static String CARD_TYPE_CREDIT = "2";
}
