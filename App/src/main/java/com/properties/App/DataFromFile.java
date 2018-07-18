package com.properties.App;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DataFromFile {
	public List<DataModel> getData() throws Exception
	{
		DataModel s=new DataModel();
		List<DataModel> a=null;
		try {
			File file = new File("/home/dev/snap/skype/common/retail-banking.properties");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(!line.startsWith("#")&&!line.isEmpty())
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
						a.add(s);
						System.out.println(a);
					};
				}
			}
			fileReader.close();
			System.out.println(a);
			return a;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
