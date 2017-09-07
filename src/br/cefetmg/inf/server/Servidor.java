/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author GABRIEL HADDAD
 */
public class Servidor {
    public static void main(String[] args) throws Exception{
        DatagramSocket d = new DatagramSocket(2223);
            
        while(true){
            try{
                byte[] buf = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(buf, buf.length);
                
                System.out.println("Recebendo dados");
                d.receive(pacote);
                System.out.println("Pacote recebido com sucesso");
                new Thread(new AdapterCalc(d, buf, pacote)).start();
            }catch(IOException ex){
                System.out.println("Ocorreu um erro! \n");
                ex.printStackTrace();
            }
        }
            
        
    }
}
