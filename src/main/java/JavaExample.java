


import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.net.InetSocketAddress;


public class JavaExample {


  public static void main(String[] args) throws TTransportException {
    TServerSocket server1 = new TServerSocket(new InetSocketAddress("0.0.0.0", 9803));
    TServerSocket server2 = new TServerSocket(10010);
  }
}