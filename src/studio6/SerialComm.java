package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method to write data to serial port
	void writeByte(byte a) {
		try {
			port.writeByte(a);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (debug) {
			System.out.println(Integer.toHexString(a));
		}
	}
	
	
	// TODO: Add available() method
	boolean available() {
		try {
			if (port.getInputBufferBytesCount() >= 1) {
				return true;
			}
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	
	// TODO: Add readByte() method	
	byte readByte() {
		try {
			return(port.readBytes(1)[0]);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return 0;
	}
	
	public static void main(String [ ] args){
		
		SerialComm myComm = null;
		try {
			myComm = new SerialComm("COM3");
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (1==1) {
			if (myComm.available()) {
				System.out.println((char)myComm.readByte());
			}
		}
	}
}
