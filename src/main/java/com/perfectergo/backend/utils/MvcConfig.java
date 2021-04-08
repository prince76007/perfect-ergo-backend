package com.perfectergo.backend.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	exposeDirectory("upload-photo", registry);
	WebMvcConfigurer.super.addResourceHandlers(registry);
}

@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedOrigins("http://192.168.0.104:4200");
}

public void exposeDirectory(String pathName,ResourceHandlerRegistry registry) {
	Path pathDir= Paths.get(pathName);
	String photoDir= pathDir.toFile().getAbsolutePath();
	if (pathName.startsWith("../")) pathName = pathName.replace("../", "");
	registry.addResourceHandler("/" + pathName + "/**").addResourceLocations("file:/"+ photoDir + "/");
}
}
