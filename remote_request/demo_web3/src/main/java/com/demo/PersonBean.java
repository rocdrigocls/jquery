package com.demo;

import java.util.List;

public class PersonBean {
	
	private String 			id;
	private String 			name;
	private int 			edad;
	private List<String> 	listTelefonos;

	@Override
	public String toString() {
		return String.format("[id:%s, name:%s, edad:%s]  ", id, name, edad);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<String> getListTelefonos() {
		return listTelefonos;
	}

	public void setListTelefonos(List<String> listTelefonos) {
		this.listTelefonos = listTelefonos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
