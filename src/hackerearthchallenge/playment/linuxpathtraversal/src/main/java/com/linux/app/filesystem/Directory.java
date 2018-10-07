package com.linux.app.filesystem;

import java.util.ArrayList;
import java.util.List;

import com.linux.app.config.Constants;

/**
 * This represent logical track of filesystem.
 * 
 * @author  Rakesh Gupta
 *
 */
public class Directory {

	private Directory parent;
	private String name;
	private List<Directory> childDirs;

	public Directory(String name) {
		this();
		this.name = name;
	}

	public Directory() {
		this.parent = null;
		this.name = Constants.ROOT_DIR;
		this.childDirs = new ArrayList<>();
	}

	public Directory(String dirName, Directory parentDir) {
		this.name = dirName;
		this.parent = parentDir;
		if (parentDir != null) {
			parentDir.addChildDir(this);	
		}
		childDirs = new ArrayList<>();
	}

	public boolean deleteChildDir(Directory directory) {
		return childDirs.remove(directory);
	}

	public void addChildDir(Directory entry) {
		childDirs.add(entry);
	}

	public List<Directory> getChildDirs() {
		return childDirs;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printDirs() {
		System.out.print("DIRS: ");
		for (Directory directory : childDirs) {
			System.out.print(directory.getName() + " ");
		}
		System.out.println();
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
		Directory other = (Directory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
