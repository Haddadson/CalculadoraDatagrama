/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.server;

import br.cefetmg.inf.calculadora.Calculadora;
import br.cefetmg.inf.util.ExcecaoMat;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author GABRIEL HADDAD
 */
public class AdapterCalc implements Runnable{
    private Calculadora calc;
    private DatagramSocket d;
    private DatagramPacket pacote;
    private byte[] buf;
    
    public AdapterCalc(){}
    
    public AdapterCalc(DatagramSocket d, byte[] buf, DatagramPacket pacote){
        this.calc = new Calculadora();
        this.d = d;
        this.buf = buf;
        this.pacote = pacote;
    }

    @Override
    public void run() {
        double resultado = 0;
        String result = new String();
        String aux = new String(pacote.getData());
        System.out.println(aux);
        if (aux.contains("+")) {
            double a = Double.parseDouble(aux.split("\\+")[0]);
            double b = Double.parseDouble(aux.split("\\+")[1]);
            resultado = calc.soma(a, b);
        }
        if (aux.contains("-")) {
            double a = Double.parseDouble(aux.split("\\-")[0]);
            double b = Double.parseDouble(aux.split("\\-")[1]);
            resultado = calc.subtracao(a, b);

        }
        if (aux.contains("*")) {

            double a = Double.parseDouble(aux.split("\\*")[0]);
            double b = Double.parseDouble(aux.split("\\*")[1]);
            resultado = calc.multiplicacao(a, b);

        }
        if (aux.contains("/")) {

            double a = Double.parseDouble(aux.split("\\/")[0]);
            double b = Double.parseDouble(aux.split("\\/")[1]);
            try{
                resultado = calc.divisao(a, b);
            } catch (ExcecaoMat ex){
                System.out.println("Erro! " +ex.getMessage());
            }
        }

        result += resultado;
        buf = result.getBytes();
        pacote.setData(buf);
        
        try {
            d.send(pacote);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
