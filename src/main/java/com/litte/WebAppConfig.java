package com.litte;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LitteInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/login",
                        "/user/login",
                        "/**/*.js",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.css",
                        "/**/*.ts",
                        "/territory/listTerritorySele",
                        "/dept/listDeptByPort",
                        "/coupon/listCouponByPort",
                        "/price/listPriceUserByPort",
                        "/evaluate/listEvaluateByPort",
                        "/indent/addIndent",
                        "/slideshow/listSlideshowByPort",
                        "/file/download",
                        "/indent/noticeCardOrder",
                        "/personage/addPersonage",
                        "/indent/payIndent",
                        "/indent/refund",
                        "/rest/addRestRort",
                        "/menu/menuTreePort",
                        "/personage/updPersonage",
                        "/rest/seleDateRort",
                        "/indent/smsXxs",
                        "/indent/verifyConde",
                        "/rest/getNowDateRort",
                        "/dept/selDeptByIdPort",
                        "/wallet/walletCardOrder",
                        "/wallet/payWallet",
                        "/user/listUserByPort",
                        "/recruit/listRecruitByPort",
                        "/personage/seleByKeyPort",
                        "/file/uploadFile",
                        "/evaluate/addEvaluate",
                        "/price/listPriceRestByPort",
                        "/rest/seleDateStaffRort",
                        "/projects/listProjectsByPort",
                        "/trecruitInfo/trecruitInfoData",
                        "/trecruitInfo/updTrecruitInfo");

    }
}
