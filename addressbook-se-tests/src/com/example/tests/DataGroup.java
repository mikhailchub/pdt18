package com.example.tests;

public class DataGroup implements Comparable<DataGroup> {

	public String name;
	public String header;
	public String footer;

	public DataGroup() {
	}

	public DataGroup(String group_name, String group_header, String group_footer) {
		this.name = group_name;
		this.header = group_header;
		this.footer = group_footer;
	}

	@Override
	public String toString() {
		return "DataGroup [name=" + name + ", header=" + header + ", footer="
				+ footer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataGroup other = (DataGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(DataGroup other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}	
	
}