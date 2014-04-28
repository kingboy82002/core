package cn.com.free.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Resources> resources = new HashSet<Resources>();

	public Set<Resources> getResources() {
		return resources;
	}

	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}
	
	
}
