package com.vatsalya.add_student;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MarksBean implements Serializable 
{
	private int coreJava, advJava,ui,db,tools;
	
	public MarksBean() {}

	public int getCoreJava() {
		return coreJava;
	}

	public void setCoreJava(int coreJava) {
		this.coreJava = coreJava;
	}

	public int getAdvJava() {
		return advJava;
	}

	public void setAdvJava(int advJava) {
		this.advJava = advJava;
	}

	public int getUi() {
		return ui;
	}

	public void setUi(int ui) {
		this.ui = ui;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getTools() {
		return tools;
	}

	public void setTools(int tools) {
		this.tools = tools;
	}
	
	
}
