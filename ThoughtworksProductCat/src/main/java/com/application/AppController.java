package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.service.consumer.ProductCatalogService;

@RestController
@RequestMapping("app")
public class AppController {
	@Autowired
	private ProductCatalogService productCatalogService;
}
