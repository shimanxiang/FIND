package test;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import find.util.WordValidatorInit;
public class test extends TestCase{
	
	public void test (){	
		Map<Object, Object> t=new HashMap<>(); 
		WordValidatorInit wordValidatorInit =new WordValidatorInit();
		t=wordValidatorInit.initKeyWord();
		for(Object key:t.keySet()){
			System.out.println(t.get(key));
		}
	}
}
