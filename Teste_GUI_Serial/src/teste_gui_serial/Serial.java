package teste_gui_serial;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public class Serial implements SerialPortEventListener{
    private String message,aux="";
    private SerialPort serialPort;
    private int temp1,temp2,humf1;
    private String stemp1,stemp2,shumf1;

    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };

    public Serial() {
        this.initialize();
    }
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    /**
     * Milliseconds to block while waiting for port open
     */
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    private void initialize() {
        String[] portNames = SerialPortList.getPortNames();
        String portId = null;
        //First, Find an instance of serial port as set in PORT_NAMES.
        for (String portName1 : portNames) {
            for (String portName : PORT_NAMES) {
                if (portName1.equals(portName)) {
                    portId = portName1;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = new SerialPort(portId);
            serialPort.openPort();
            // set port parameters
            serialPort.setParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN
                    | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            // add event listeners
            serialPort.addEventListener(this);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            try {
                serialPort.removeEventListener();
                serialPort.closePort();

            } catch (SerialPortException ex) {}
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventValue() > 0) {
            try {
                String receivedData = serialPort.readString();
                aux+=receivedData;
                if(aux.contains("\n")){
                    message=aux.substring(0, aux.indexOf('\n'));
                    //System.out.println("Received response: " + message);
                    aux=aux.substring(aux.indexOf('\n')+1);
                    if (message.length()>2){
                        this.setTemp1(message);
                        this.setTemp2(message);
                        this.setHumf1(message);
                    }
                }
                    
                } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public int getTemp1() {
        return temp1;
    }

    private void setTemp1(String s) {
        this.setStemp1(s);
        this.temp1=Integer.parseInt(this.getStemp1());
    }

    public int getTemp2() {
        return temp2;
    }

    private void setTemp2(String s) {
        this.setStemp2(s);
        this.temp2=Integer.parseInt(this.getStemp2());
    }

    public int getHumf1() {
        return humf1;
    }

    private void setHumf1(String s) {
        this.setShumf1(s);
        this.humf1=Integer.parseInt(this.getShumf1());
    }

    public String getStemp1() {
        return stemp1;
    }

    private void setStemp1(String s) {
        stemp1=s.substring(0, s.indexOf(' '));
        stemp1=stemp1.replaceAll("\\s+", "");
    }

    public String getStemp2() {
        return stemp2;
    }

    private void setStemp2(String s) {
        stemp2=s.substring(s.indexOf(' '),s.lastIndexOf(' '));
        stemp2=stemp2.replaceAll("\\s+", "");
    
    }

    public String getShumf1() {
        return shumf1;
    }

    private void setShumf1(String s) {
        shumf1=s.substring(s.lastIndexOf(' '));
        shumf1=shumf1.replaceAll("\\s+", "");
    }
}


