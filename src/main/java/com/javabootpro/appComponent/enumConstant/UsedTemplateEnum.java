package com.javabootpro.appComponent.enumConstant;


//
//  log.info("UsedEnum.USED : [{}]",UsedEnum.USED);  // [USED]
//
//   log.info("UsedEnum.USED.getCode() : [{}]",UsedEnum.USED.getCode()); // [1]
//
//    log.info("UsedEnum.USED.getDiscribe() : [{}]",UsedEnum.USED.getDiscribe()); // [已用过]


/**
 *  枚举类 模板
 */

// 注意事项 : 枚举类型 不能使用 lombok 注解
// 必须生成get set 以及构造器方法
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public enum UsedTemplateEnum {

    // 注意是用英文逗号隔开
    // 最后是以英文分号结束

    UN(0,"没用过"),
    USED(5,"已用过"),
    USED2(5,"已用过","33"),
    FORBIDDEN(2,"不能用");



    private Integer code;
    private String discribe;

    public Integer getCode() {
        return code;
    }
    public String getDiscribe() {
        return discribe;
    }
    private UsedTemplateEnum(Integer code, String discribe) {
        this.code = code;
        this.discribe = discribe;
    }

    private UsedTemplateEnum(Integer code, String discribe,String info) {

    }

}
