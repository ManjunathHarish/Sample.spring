package com.properties.App;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ApiHittingAndAvailabilityTestCases {
	@Test
	public void getAllRecords() {
		Response resp=get("http://localhost:8080/rest/all");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByBotIntId() {
		Response resp=get("http://localhost:8080/rest/botIntId/2");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByBotDomainIntId() {
		Response resp=get("http://localhost:8080/rest/ruleType/ruleType1");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByChannelName() {
		Response resp=get("http://localhost:8080/rest/channelName/Channel_name0");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByRuleCode() {
		Response resp=get("http://localhost:8080/rest/ruleCode/qry-portfolio_ACCOUNT_CATEGORIES");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByRuleType() {
		Response resp=get("http://localhost:8080/rest/ruleType/RuleType1");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByBotIdRuleCode() {
		Response resp=get("http://localhost:8080/rest/botIdRuleCode/1/qry-portfolio_ACCOUNT_CATEGORIES");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
	@Test
	public void getByBotIdRuleCodeChannelCode() {
		Response resp=get("http://localhost:8080/rest/botIdRuleCodeChannelCode/1/qry-portfolio_ACCOUNT_CATEGORIES/channel_code0");
		int code=resp.getStatusCode();
		Assert.assertEquals(code,200);
	}
}
