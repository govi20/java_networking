package com.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args) throws UnknownHostException {
        getIpAddressByHost ("www.google.com");
        getHostByIp ("172.217.27.196");
        getIpAddressByHost ("bom07s15-in-f4.1e100.net");
        getAllIpAddressesByHost ("www.google.com");

        // Below will lead to exception, as https is not part of host name, it is rather used to connect to port on host.
        // getAllIpAddressesByHost ("https://www.google.com");

        //local address. It will return loop back address, unless local machine has entry in DNS
        InetAddress local = InetAddress.getLocalHost ();
        System.out.println (local);


        // If we know IP address, InetAddress object can be created following way
        byte[] address = {107, 23, (byte) 216, (byte) 196};
        InetAddress byIpAddress = InetAddress.getByAddress(address);

        /*
            signature: public static InetAddress getByAddress(String hostname, byte[] addr)
            This could be useful if a domain name server is not available or might have inaccurate information
            UnknownHostException will be thrown only if a byte array of an illegal size (neither 4 nor 16 bytes long) is passed as the address argument.
         */
        InetAddress lessWrongWithname = InetAddress.getByAddress("www.randomhost.com", address);

    }

    public static void getIpAddressByHost(String host) {
        try {
            InetAddress inetAddress = InetAddress.getByName (host);
            System.out.println (inetAddress);
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }

    // in case host is load-balanced.
    public static void getAllIpAddressesByHost(String host) {
        try {
            InetAddress[] inetAddresses = InetAddress.getAllByName (host);
            System.out.println ("Totat hosts => " +inetAddresses.length);
            for(InetAddress inetAddress: inetAddresses) {
                System.out.println (inetAddress);
            }
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }


    static void getHostByIp(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName (ipAddress);
            System.out.println (inetAddress.getHostName ());
        } catch (UnknownHostException e) {
            e.printStackTrace ();
        }
    }

}
