import java.util.Scanner;

public class Puissance4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String joueur1 = new String("");
		String joueur2 = new String("");

		System.out.print("Entrez le nom du joueur 1 : ");
		joueur1 = scanner.nextLine();
		System.out.print("Entrez le nom du joueur 2 : ");
		joueur2 = scanner.nextLine();
		System.out.println("");

		int N = 4;
		int C = 7;
		int L = 6;

		char[][] plateau = new char[C][L];

		for(int x = 0 ; x < C ; x++){
			for(int y = 0 ; y < L ; y++){
				plateau[x][y] = '.';
			}
		}

		int gagnant = 0;

		for(int i = 1 ; i <= C*L ; i++){

			System.out.println("Tour " + i + ", Etat du plateau :");

			for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
			System.out.println();

			for(int y = 0 ; y < L ; y++){
				System.out.print('|');
				for(int x = 0 ; x < C ; x++){
					System.out.print(" " + plateau[x][y] + " ");
				}
				System.out.print('|');
				System.out.println();
			}

			for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
			System.out.println();

			System.out.println("Tour du joueur " + (i%2==1 ? joueur1 : joueur2) );
			System.out.println("Entrez le numero de la colonne dans laquelle vous souhaitez jouer ( entre 1 et " + C + " )");
			boolean placement = false;
			int colonne = -1;
			while(!placement){
				colonne = -1;
				String ligne = scanner.nextLine();

				try{
					colonne = Integer.valueOf(ligne);

					if(colonne >= 1 && colonne <= C){
						if(plateau[colonne - 1][0] != '.'){
							System.out.println("Colonne pleine, reessayez");
						} else {
							placement = true;
						}
					} else {
						System.out.println("Nombre incorrect, reessayez");
					}

				}catch(Exception e){System.out.println("Nombre incorrect, reessayez");}

			}

			int rang = L-1;
			while(plateau[colonne - 1][rang] != '.'){
				rang--;
			}
			plateau[colonne - 1][rang] = (i%2==1 ? 'X' : 'O');

			char symbole = (i%2==1 ? 'X' : 'O');

			int max = 0;
			int x; int y;
			int somme;


			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && x >= 0 && plateau[x][y] == symbole){ y--; x--; somme++;}
			x = colonne-1; y = rang;
			while(y < L && x < C && plateau[x][y] == symbole){ y++; x++; somme++;}
			if(somme > max) max= somme;


			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && x < C && plateau[x][y] == symbole){ y--; x++; somme++;}
			x = colonne-1; y = rang;
			while(y < L && x >= 0 && plateau[x][y] == symbole){ y++; x--; somme++;}
			if(somme > max) max= somme;


			x = colonne-1; y = rang; somme=-1;
			while(y >= 0 && plateau[x][y] == symbole){ y--; somme++;}
			y = rang;
			while(y < L && plateau[x][y] == symbole){ y++; somme++;}
			if(somme > max) max= somme;


			x = colonne-1; y = rang; somme=-1;
			while(x >= 0 && plateau[x][y] == symbole){ x--; somme++;}
			x = colonne-1;
			while(x < C && plateau[x][y] == symbole){ x++; somme++;}
			if(somme > max) max= somme;


			if(max >= N){
				gagnant = (i%2==1 ? 1 : 2);
				i = C*L+1;
			}

			System.out.println("");
		}

		System.out.println();
		System.out.println("");
		System.out.println("--- FIN DE LA PARTIE ---");
		System.out.println("");
		if(gagnant == 0)
			System.out.println("--- EGALITE ---");
		if(gagnant == 1)
			System.out.println("--- VICTOIRE DE "+joueur1+" ---");
		if(gagnant == 2)
			System.out.println("--- VICTOIRE DE "+joueur2+" ---");
		System.out.println("");


		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();

		for(int y = 0 ; y < L ; y++){
			System.out.print('|');
			for(int x = 0 ; x < C ; x++){
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}

		for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
		System.out.println();

	}

}
