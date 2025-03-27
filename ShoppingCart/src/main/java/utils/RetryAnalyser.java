package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int countRetryAttempt=0;
	int setMaxNoOfcount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
		if(countRetryAttempt<setMaxNoOfcount) {
			countRetryAttempt++;
			return true;  
		}
		
	}
		return false;
	}
	

}
