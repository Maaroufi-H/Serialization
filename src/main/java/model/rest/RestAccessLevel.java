package model.rest;

public class RestAccessLevel 
{
	int readLevel;
	int writeLevel;
	public int getReadLevel() {
		return readLevel;
	}
	public void setReadLevel(int readLevel) {
		this.readLevel = readLevel;
	}
	public int getWriteLevel() {
		return writeLevel;
	}
	public void setWriteLevel(int writeLevel) {
		this.writeLevel = writeLevel;
	}
	public RestAccessLevel(int readLevel, int writeLevel) {
		super();
		this.readLevel = readLevel;
		this.writeLevel = writeLevel;
	}
	
	
	
}
