package com.properties.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/rest")
public class Datacontroller {

	@Autowired
	DataRepository dataRepository;
	@GetMapping(path="/add")
	@ResponseBody
	public String addData() throws Exception
	{
//		DataFromFile d=new DataFromFile();
		List<DataModel> list=new ArrayList<DataModel>();
//		a=d.getData();
//		System.out.println("result"+a);
//	dataRepository.saveAll(a);
		
		try {
			File file = new File("/home/dev/snap/skype/common/retail-banking.properties");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				DataModel s=new DataModel();
				if(!line.startsWith("#")&& !line.isEmpty())
				{
					if(line.contains("="))
					{
						int b=line.indexOf("=");
						String w=line.substring(0, b);
						s.setProperties(w);
						w=line.substring(b+1);
						if(w.length()<255)
						{
							s.setValues(w);
						}
						else
							s.setValues(null);
						list.add(s);
					};
				}
				
			}
			
			fileReader.close();
			dataRepository.saveAll(list);
		}
		catch(Exception e)
		{
			throw e;
		}
	return "saved";
	}
}
