package com.properties.App;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="data")
public class DataModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int domain_rules_int_id;
	@Column(name="bot_int_id")
	private int botIntId;
	@Column(name="bot_domain_int_id")
	private int botDomainIntId;
	@Column(name="channel_name")
	private String channelName;
	@Column(name="rule_code")
	private String ruleCode;
	@Column(name="rule_value")
	private String ruleValue;
	@Column(name="rule_type")
	private String ruleType;
	@Column(name="rule_description")
	private String ruleDescription;
	@Column(name="functionality_code")
	private String functionalityCode;
	@Column(name="sub_functionality_code")
	private String subFunctionalityCode;
	@Column(name="channel_code")
	private String channelCode;
	@Column(name="rec_created_by")
	private String recCreatedBy;
	@Column(name="rec_created_date")
	private Date recCreatedDate;
	@Column(name="rec_updated_date")
	private Date recUpdatedDate;
	@Column(name="rec_updated_by")
	private String recUpdatedBy;
	public int getDomain_rules_int_id() {
		return domain_rules_int_id;
	}
	public int getBotIntId() {
		return botIntId;
	}
	public int getBotDomainIntId() {
		return botDomainIntId;
	}
	public String getChannelName() {
		return channelName;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public String getRuleValue() {
		return ruleValue;
	}
	public String getRuleType() {
		return ruleType;
	}
	public String getRuleDescription() {
		return ruleDescription;
	}
	public String getFunctionalityCode() {
		return functionalityCode;
	}
	public String getSubFunctionalityCode() {
		return subFunctionalityCode;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public String getRecCreatedBy() {
		return recCreatedBy;
	}
	public Date getRecCreatedDate() {
		return recCreatedDate;
	}
	public Date getRecUpdatedDate() {
		return recUpdatedDate;
	}
	public String getRecUpdatedBy() {
		return recUpdatedBy;
	}
	public void setBotIntId(int botIntId) {
		this.botIntId = botIntId;
	}
	public void setBotDomainIntId(int botDomainIntId) {
		this.botDomainIntId = botDomainIntId;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}
	public void setFunctionalityCode(String functionalityCode) {
		this.functionalityCode = functionalityCode;
	}
	public void setSubFunctionalityCode(String subFunctionalityCode) {
		this.subFunctionalityCode = subFunctionalityCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public void setRecCreatedBy(String recCreatedBy) {
		this.recCreatedBy = recCreatedBy;
	}
	public void setRecCreatedDate(Date recCreatedDate) {
		this.recCreatedDate = recCreatedDate;
	}
	public void setRecUpdatedDate(Date recUpdatedDate) {
		this.recUpdatedDate = recUpdatedDate;
	}
	public void setRecUpdatedBy(String recUpdatedBy) {
		this.recUpdatedBy = recUpdatedBy;
	}

	
	
}
