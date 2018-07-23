package com.properties.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.properties.App.Exception.ResourceNotFoundException;

import javassist.NotFoundException;



@RestController
@RequestMapping(path="/rest")
public class Datacontroller {

	@Autowired
	DataRepository dataRepository;
	@GetMapping(path="/add")
	@ResponseBody
	public String addData() throws Exception
	{
		getDataAndStoreInDb();		
		return "saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody List<DataModel> getAllRecords() throws ResourceNotFoundException {
		List<DataModel> data=(List<DataModel>) dataRepository.findAll();
		if(data.isEmpty())
			throw new ResourceNotFoundException("database is empty please add some records then try again");
		return (List<DataModel>) dataRepository.findAll();
	}
	
	@GetMapping(path="botIntId/{botIntId}")
	public List<DataModel> getByBotIntId(@PathVariable("botIntId") int botIntId) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByBotIntId(botIntId);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on bot id of "+botIntId);
		return data;
	}
	
	@GetMapping(path="botDomainIntId/{botDomainIntId}")
	public List<DataModel> getByBotDomainIntId(@PathVariable("botDomainIntId") int botDomainIntId ) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByBotDomainIntId(botDomainIntId);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on bot domain id of "+botDomainIntId);
		return data;
	}
	
	@GetMapping(path="channelName/{channelName}")
	public List<DataModel> getByChannelName(@PathVariable("channelName") String channelName) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByChannelName(channelName);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found found on channel name "+channelName);
		return data;
	}
	
	@GetMapping(path="ruleCode/{ruleCode}")
	public List<DataModel> getByRuleCode(@PathVariable("ruleCode") String ruleCode) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByRuleCode(ruleCode);
		System.out.println("hi"+(data!=null));
		if(data.isEmpty())
			throw new ResourceNotFoundException("No Data Found on rule code="+ruleCode);
		return data;
	}

	@GetMapping(path="ruleType/{ruleType}")
	public List<DataModel> getByRuleType(@PathVariable("ruleType") String ruleType) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByRuleType(ruleType);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on rule type "+ruleType);
		return data;
	}
	@GetMapping(path="channelCode/{channelCode}")
	public List<DataModel> getByChannelCode(@PathVariable("channelCode") String channelCode) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByChannelCode(channelCode);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on channel code "+channelCode);
		return data;
	}
	//by multiple parameters
	@GetMapping(path="botIdRuleCode/{botIntId}/{RuleCode}")
	public List<DataModel> getByBotIdRuleCode(@PathVariable("botIntId") int botIntId,@PathVariable("RuleCode") String RuleCode ) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByBotIntIdAndRuleCode(botIntId,RuleCode);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on bot id ="+botIntId+"and rule code ="+RuleCode);
		return data;
	}
	
	@GetMapping(path="botIdRuleCodeChannelCode/{botIntId}/{RuleCode}/{channelCode}")
	public List<DataModel> getByBotIdRuleCodeChannelCode(@PathVariable("botIntId") int botIntId,@PathVariable("RuleCode") String RuleCode, @PathVariable("channelCode") String channelCode) throws ResourceNotFoundException
	{
		List<DataModel> data=dataRepository.findByBotIntIdAndRuleCodeAndChannelCode(botIntId,RuleCode,channelCode);
		if(data.isEmpty())
			throw new ResourceNotFoundException("no data found on bot id ="+botIntId+" rule code ="+RuleCode+" and channel code ="+channelCode);
		return data;
	}
	public void getDataAndStoreInDb()
	{
		List<DataModel> list=new ArrayList<DataModel>();
		Date date = new Date();
		try {
			File file = new File("/home/dev/snap/skype/common/retail-banking.properties");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int length=0;
			int temp1=0,temp2=50;
			while ((line = bufferedReader.readLine()) != null) {
				DataModel s=new DataModel();
				if(!line.startsWith("#")&& !line.isEmpty())
				{
					if(line.contains("="))
					{
						length++;
						int b=line.indexOf("=");
						String w=line.substring(0, b);
						s.setRuleCode(w);
						w=line.substring(b+1);
						if(w.length()<255)
						{
							s.setRuleValue(w);
						}
						else
							s.setRuleValue(null);
						s.setRecCreatedDate(date);
						s.setRecUpdatedDate(date);
						s.setRecCreatedBy("man");
						s.setRecUpdatedBy("man");
						
						//to generate dummy values
						if(length<temp1+temp2)
						{
							s.setBotIntId(temp1);
							s.setChannelCode("channel_code"+temp1);
							s.setChannelName("Channel_name"+temp1);
							s.setBotDomainIntId(temp1+1);
						}
						else
						{
							s.setBotIntId(temp1++);
							temp2+=50;
						}
						length++;
						list.add(s);
					};
				}
				
			}
			
			fileReader.close();
			dataRepository.saveAll(list);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
