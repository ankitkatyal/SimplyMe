package com.society.management.domain;

import java.util.Arrays;

public class EmailAttribute {

	private String[] to;
	private String[] from;
	private String[] cc;
	private String[] bcc;
	private String subject;

	public EmailAttribute() {
	}

	public EmailAttribute(String[] to, String[] from, String[] cc, String[] bcc, String subject) {
		super();
		this.to = to;
		this.from = from;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getFrom() {
		return from;
	}

	public void setFrom(String[] from) {
		this.from = from;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailAttributeEnum [to=" + Arrays.toString(to) + ", from=" + Arrays.toString(from) + ", cc="
				+ Arrays.toString(cc) + ", bcc=" + Arrays.toString(bcc) + ", subject=" + subject + "]";
	}

}
