/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_serial;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.*;

/**
 *
 * @author Usuário
 */
public class Teste_jSSC implements SerialPortEventListener {
    private String message,aux="";
    SerialPort serialPort;
    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public void initialize() {
                // the next line is for Raspberry Pi and 
        // gets us into the while loop and was suggested here was suggested https://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        //               System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

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

            } catch (SerialPortException ex) {
                Logger.getLogger(Teste_jSSC.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                    System.out.println("Received response: " + message);
                    aux=aux.substring(aux.indexOf('\n')+1);
                }
                    
                } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

}
