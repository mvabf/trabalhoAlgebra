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
		
		System.out.print("Insira a Quantidade de Equações e Icógnitas do seu sistema: ");
		int linhas = in.nextInt();
		int colunas = in.nextInt();
		
		double [][] matriz = new double [linhas + 1][colunas + 1];
		
		System.out.println("Insira Seus valores abaixo: ");
		for(int i = 1;i <= linhas;i++) {
			for(int j = 1;j <= colunas;j++) {
				
				//System.out.printf("Insira %dª Equação: ",i);
				
				matriz[i][j] = in.nextInt();
				
			}
		}
		
			imprimirMatriz(matriz);

			//lógica para escalonar
			
			int i = 1;
			int j = 1;
			
			while(i<= linhas && j<= colunas) {
				int x = i;
				
				while(x <= linhas && matriz[x][j] == 0) {
					x++;
				}
				if(x <= linhas ) {
					
					if(x != i) {
						trocaLinha(matriz, i, x, j);
						imprimirMatriz(matriz);
					}
					if (matriz[i][j] != 1) {
						divideElemento(matriz, i, j);
						imprimirMatriz(matriz);
					}
					
					subtrairElemento(matriz, i, j);
					imprimirMatriz(matriz);
					i++;
				}
				j++;
			}
			
		in.close();
	}

	public static void trocaLinha(double[][] matriz,int i, int x, int j) {
		
		// troca linha lx por ly
		
		int m = matriz[0].length - 1;
			
		double temporario;
			for(int q = j; q <= m; q++) {
				temporario = matriz[i][q];
				matriz[i][q] = matriz[x][q];
				matriz[x][q] = temporario;
			}
	}
	
	static void divideElemento(double[][] matriz, int i, int j) {
		
		//divide o primeiro elemento da linha com os proximos
		
		int m = matriz[0].length - 1;
		for (int q = j + 1; q <= m; q++){
			matriz [i][q] /= matriz[i][j];
		}
		matriz[i][j] = 1;
	}

	public static void imprimirMatriz(double[][]matriz) {
		
		//imprime a matriz
		System.out.println();
		System.out.print("Matriz: ");
		for(int i = 1;i <= matriz.length - 1;i++) {
			System.out.println();
			for(int j = 1;j <= matriz[i].length - 1;j++)
				System.out.printf("%.1f ",matriz[i][j]); 
			}
	}
	
	static void subtrairElemento(double[][] matriz, int i, int j) {	
		
		// subtrai elemento com a multipliccação de elementos de outra linha
		
		
		int n = matriz.length - 1; 
		
		int m = matriz[0].length - 1;
		
		for (int p = 1; p <= n; p++) {
			
			if (p != i && matriz[p][j] != 0) {
				
				for (int q = j + 1; q <= m; q++) {
					matriz[p][q] -= matriz[p][j] * matriz[i][q];					
				}
				matriz[p][j] = 0;
			}
		}
	}
}


