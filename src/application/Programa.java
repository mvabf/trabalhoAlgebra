package application;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		System.out.println("----------------------------");
		System.out.println("    B E M     V I N D O");
		System.out.println("----------------------------");
		
		System.out.print("Insira a Quantidade de linhas e colunas de sua matriz: ");
		int linhas = in.nextInt();
		int colunas = in.nextInt();
		
		int [][] matriz = new int[linhas][colunas];
		
		for(int i = 0;i < linhas;i++) {
			for(int j = 0;j < colunas;j++) {
				
				System.out.printf("Preencha Sua matriz na posição [%d][%d]: ",i+1,j+1);
				matriz[i][j] = in.nextInt();
			}
		}
		

		in.close();
	}
	
	public static void trocaLinha(int [][]matriz,int lx, int ly) {
		int [] aux = matriz[lx];
		matriz[lx] = matriz[ly];
		matriz[ly] = aux;
	}
	
	public static void imprimirMatriz(int[][]matriz) {
		System.out.print("Matriz: ");
		for(int i = 0;i < matriz.length;i++) {
			System.out.println();
			for(int j = 0;j < matriz[i].length;j++) {
				
				System.out.printf("[%d]", matriz[i][j]);
			}
		}
	}
	
	
	
}
