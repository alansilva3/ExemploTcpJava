/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public abstract class TCPController{
    public static void executeClient(){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println("Escreva uma mensagem");
                System.out.print(">>> ");
                String msg = sc.nextLine();
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
                
                byte[] buf2 = new byte[20]; // buffer de recepção
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf2); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                String msg2 = new String(buf2); // Mapeando vetor de bytes recebido para String
                System.out.println("  Mensagem recebida: "+ msg2);
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
    
    public static void executeServer(){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            byte[] buf = new byte[20]; // buffer de recepção

            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(buf); // Operação bloqueante (aguardando chegada de dados)
            System.out.println("[OK] ]");
            
            String msg = new String(buf); // Mapeando vetor de bytes recebido para String
            
            System.out.println("  Mensagem recebida: "+ msg);
            
            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println("Escreva uma mensagem");
                System.out.print(">>> ");
                String msg3 = sc.nextLine();
                byte[] buf3 = msg3.getBytes(); // Obtendo a respresntação em bytes da mensagem
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf3);
                System.out.println("[OK] ]");
                
                byte[] buf2 = new byte[20]; // buffer de recepção
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf2); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                String msg2 = new String(buf2); // Mapeando vetor de bytes recebido para String
                System.out.println("  Mensagem recebida: "+ msg2);
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}