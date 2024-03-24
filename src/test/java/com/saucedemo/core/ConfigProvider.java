package com.saucedemo.core;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String STANDARD_USER_LOGIN = readConfig().getString("userParams.standardUser.login");
    String STANDARD_USER_PASSWORD = readConfig().getString("userParams.standardUser.password");


    // page id's used for site asssets
    String LOGIN_PAGE_ID = readConfig().getString("pageId.login");
    String INVENTORY_PAGE_ID = readConfig().getString("pageId.inventory");




}
