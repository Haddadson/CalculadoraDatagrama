/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.client;
import br.cefetmg.inf.calculadora.InterfaceCalculadora;
import br.cefetmg.inf.util.ExcecaoMat;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author GABRIEL HADDAD
 */
public class Cliente {
    public static void main(String[] args) {
        try {


            Scanner scan = new Scanner(System.in);
            System.out.println("Operações: \n+ -> Adição\n- -> Subtração\n* -> Multiplicação\n/ -> Divisão");
            char op = scan.next().charAt(0);
            double num1, num2;
            double result;

            System.out.println("Digite o primeiro número: ");
            num1 = scan.nextDouble();

            System.out.println("Digite o segundo número: ");
            num2 = scan.nextDouble();
            InterfaceCalculadora proxy = new ProxyCalc();

            switch (op) {
                case '+':
                    result = proxy.soma(num1, num2);

                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case '-':
                    result = proxy.subtracao(num1, num2);

                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case '/':
                    result = proxy.divisao(num1, num2);

                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;

                case 'x':
                    result = proxy.multiplicacao(num1, num2);

                    System.out.println("Resultado: ");
                    System.out.print(result);

                    break;
            }
            System.out.println();
        } catch (IOException | ExcecaoMat e) {
            System.out.println("Ocorreu um erro! \n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
