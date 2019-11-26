/**
 * @author JOSE ALAN DA SILVA (Aluno DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.util.Scanner;
import br.ufs.dcomp.ExemploTcpJava.TCPController;

public class ChatTCP{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Escola o modo de operação === \n");
        System.out.print("Client[1] - Server[2] >> ");
        int resp = sc.nextInt();
        
        if(resp == 1){
            TCPController.executeClient();
        }else{
            TCPController.executeServer();
        }
    }
}