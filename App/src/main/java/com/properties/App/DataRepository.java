package com.properties.App;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DataRepository extends CrudRepository<DataModel, Long> {

	List<DataModel> findByRuleCode(String rule_code);

	List<DataModel> findByBotIntId(int botIntId);

	List<DataModel> findByBotDomainIntId(int botDomainIntId);

	List<DataModel> findByChannelName(String channelName);

	List<DataModel> findByRuleType(String ruleType);

	List<DataModel> findByChannelCode(String channelCode);

	List<DataModel> findByBotIntIdAndRuleCode(int botIntId, String ruleCode);

	List<DataModel> findByBotIntIdAndRuleCodeAndChannelCode(int botIntId, String ruleCode, String channelCode);

}
