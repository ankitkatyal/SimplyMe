package com.society.management.domain;

import java.util.Date;

import com.society.management.util.EventEnum;

public class EmailTemplateEnum {

	private EventEnum event;
	private Date eventDt;
	private String context1;
	private String context2;
	private String context3;
	private String context4;
	private String context5;
	private String eventBy;
	

	public EmailTemplateEnum() {
	}

	public EmailTemplateEnum(EventEnum event, Date eventDt, String context1, String context2, String context3,
			String context4, String context5, String eventBy) {
		super();
		this.event = event;
		this.eventDt = eventDt;
		this.context1 = context1;
		this.context2 = context2;
		this.context3 = context3;
		this.context4 = context4;
		this.context5 = context5;
		this.eventBy = eventBy;
	}

	public EventEnum getEvent() {
		return event;
	}

	public void setEvent(EventEnum event) {
		this.event = event;
	}

	public Date getEventDt() {
		return eventDt;
	}

	public void setEventDt(Date eventDt) {
		this.eventDt = eventDt;
	}

	public String getContext1() {
		return context1;
	}

	public void setContext1(String context1) {
		this.context1 = context1;
	}

	public String getContext2() {
		return context2;
	}

	public void setContext2(String context2) {
		this.context2 = context2;
	}

	public String getContext3() {
		return context3;
	}

	public void setContext3(String context3) {
		this.context3 = context3;
	}

	public String getContext4() {
		return context4;
	}

	public void setContext4(String context4) {
		this.context4 = context4;
	}

	public String getContext5() {
		return context5;
	}

	public void setContext5(String context5) {
		this.context5 = context5;
	}

	public String getEventBy() {
		return eventBy;
	}

	public void setEventBy(String eventBy) {
		this.eventBy = eventBy;
	}

	@Override
	public String toString() {
		return "EmailTemplateEnum [event=" + event + ", eventDt=" + eventDt + ", context1=" + context1 + ", context2="
				+ context2 + ", context3=" + context3 + ", context4=" + context4 + ", context5=" + context5
				+ ", eventBy=" + eventBy + "]";
	}
}
