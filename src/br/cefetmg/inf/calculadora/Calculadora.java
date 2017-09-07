/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.calculadora;

import br.cefetmg.inf.util.ExcecaoMat;

/**
 *
 * @author GABRIEL HADDAD
 */
public class Calculadora implements InterfaceCalculadora{

    @Override
    public double soma(double valor1, double valor2){
        return valor1+valor2;
    }

    @Override
    public double subtracao(double valor1, double valor2) {
        return valor1-valor2;
    }

    @Override
    public double multiplicacao(double valor1, double valor2) {
        return valor1*valor2;
    }

    @Override
    public double divisao(double valor1, double valor2) throws ExcecaoMat{
        if(valor2 == 0){
            throw new ExcecaoMat("Divisão por 0!");
        }
        else{
            return valor1/valor2;
        }
    }
    
}
