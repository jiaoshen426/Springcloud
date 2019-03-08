package com.jiaoshen.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name="first-police",configuration=MyConfig.class)
public class CloudProviderConfig {
	
    
}
