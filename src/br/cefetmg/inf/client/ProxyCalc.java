/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.client;

import br.cefetmg.inf.calculadora.InterfaceCalculadora;
import br.cefetmg.inf.util.ExcecaoMat;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author GABRIEL HADDAD
 */
public class ProxyCalc implements InterfaceCalculadora{
    private int port = 2223;    
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buf;
    private DatagramPacket pacote;
    
    public ProxyCalc() throws IOException{
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
            buf = new byte[1024];
            pacote = new DatagramPacket(buf, buf.length, address, port);
    }
            
    
    @Override
    public double soma(double valor1, double valor2) {
        String saida = valor1 + "+" + valor2;
        buf = saida.getBytes();
        pacote.setData(buf);
        try {
            socket.send(pacote);
            
            pacote = new DatagramPacket(buf, buf.length);
            socket.receive(pacote);

        } catch (IOException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        String result = new String(pacote.getData(), pacote.getOffset(), pacote.getLength());
        double resultado = Double.parseDouble(result);
        return resultado;
    }

    @Override
    public double subtracao(double valor1, double valor2) {
        String saida = valor1 + "-" + valor2;
        buf = saida.getBytes();
        pacote.setData(buf);
        try {
            socket.send(pacote);

            pacote = new DatagramPacket(buf, buf.length);
            socket.receive(pacote);

        } catch (IOException ex) {
            System.out.println("Ocorreu um erro! \n" + ex.getMessage());
        }
        
        String result = new String(pacote.getData(), pacote.getOffset(), pacote.getLength());
        double resultado = Double.parseDouble(result);
        return resultado;
    }

    @Override
    public double multiplicacao(double valor1, double valor2) {
        String saida = valor1 + "*" + valor2;
        buf = saida.getBytes();
        pacote.setData(buf);
        try {
            socket.send(pacote);

            pacote = new DatagramPacket(buf, buf.length);
            socket.receive(pacote);

        } catch (IOException ex) {
            System.out.println("Ocorreu um erro! \n"+ ex.getMessage());
        }
        
        String result = new String(pacote.getData(), pacote.getOffset(), pacote.getLength());
        double resultado = Double.parseDouble(result);
        return resultado;
    }

    @Override
    public double divisao(double valor1, double valor2) throws ExcecaoMat {
        String saida = valor1 + "/" + valor2;
        buf = saida.getBytes();
        pacote.setData(buf);
        
        try {
            socket.send(pacote);

            pacote = new DatagramPacket(buf, buf.length);
            socket.receive(pacote);

        } catch (IOException ex) {
            System.out.println("Ocorreu um erro! \n"+ ex.getMessage());
        }
        
        String result = new String(pacote.getData(), pacote.getOffset(), pacote.getLength());
        double resultado = Double.parseDouble(result);
        return resultado;
    }
    
}
