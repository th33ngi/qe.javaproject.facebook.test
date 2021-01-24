package com.facebook.qe.listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.facebook.qe.base.BaseTest;


public class TestListener extends BaseTest implements ITestListener {
	
	private static String testMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case: "+testMethodName(result)+", Started...");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(testMethodName(result)+" test case, Passed.");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(testMethodName(result)+" test case, Failed.");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println(testMethodName(result)+" test case, Skipped.");
	}
	
	public void onStart(ITestContext iTestContext) {
		System.out.println(iTestContext.getName()+"...");
	}
	
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Test suite execution in complete.");
	}
}
