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
public interface InterfaceCalculadora {
    public double soma(double valor1, double valor2);
    public double subtracao(double valor1, double valor2);
    public double multiplicacao(double valor1, double valor2);
    public double divisao(double valor1, double valor2) throws ExcecaoMat;
}
