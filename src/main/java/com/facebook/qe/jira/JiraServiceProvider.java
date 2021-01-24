package com.facebook.qe.jira;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
		BasicCredentials credentials = new BasicCredentials(username, password);
		jira = new JiraClient(jiraUrl, credentials);
		this.project = project;
	}
	
	public void createJiraTicket(String sIssueType, String sSummary, String sDescription) {
		try {
			FluentCreate fluentCreate = jira.createIssue(project, sIssueType);
			fluentCreate.field(Field.SUMMARY, sSummary);
			fluentCreate.field(Field.DESCRIPTION, sDescription);
			fluentCreate.field(Field.PRIORITY, "Medium");
			Issue issue = fluentCreate.execute();
			System.out.println("New issue created. Jira ID: "+issue);
		} catch (JiraException e) {
			e.printStackTrace();
		}
	}
}
