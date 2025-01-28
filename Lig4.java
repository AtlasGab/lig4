public class Lig4 {
    private char matrizJogo[][];
    private char p1, p2;
    private char pAtual;
    private int coluna;

    public void desenharMatriz(){
        matrizJogo=new char[6][7];
        for (int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                matrizJogo[i][j]=' ';
            }
        }
    }

    public void printJogo() {
        System.out.println("---------------");
        for (int i = 0; i < 6; i++) {
            System.out.print("|");

            for (int j = 0; j < 7; j++) {
                System.out.print(matrizJogo[i][j]+"|");
            }
            System.out.println();
        }

        System.out.println("---------------");


    }

    public void pInicial(char p1, char p2){
        this.p1=p1;
        this.p2=p2;
        this.pAtual=p1;
    }

    public void trocarP(){
    	pAtual = (pAtual == p1) ? p2 : p1; 
    	
    }

    public boolean verificarValidade(int coluna) {
        if (coluna < 0 || coluna > 6) {
            System.out.println("Coluna inválida. Tente novamente de 0 a 6");
            return false;
        }
        for (int i = 5; i >= 0; i--) {
            if (matrizJogo[i][coluna] == ' ') {
                matrizJogo[i][coluna] = pAtual;
                return true;
            }
        }
        System.out.println("Escolha outra coluna, essa está cheia!");
        return false;
    }


    //  0 1 2 3  4 5 6
    // (* * * *) * * *
    public boolean verificarHorizontal() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizJogo[i][j] == pAtual && matrizJogo[i][j + 1] == pAtual &&
                    matrizJogo[i][j + 2] == pAtual && matrizJogo[i][j + 3] == pAtual) {
                    return true;
                }
            }
        }
        return false;
    }


    //  0 1 2  3 4 5
    // (* * *) * * *
    public boolean verificarVertical() {
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) { 
                if (matrizJogo[i][j] == pAtual && matrizJogo[i + 1][j] == pAtual &&
                    matrizJogo[i + 2][j] == pAtual && matrizJogo[i + 3][j] == pAtual) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    0 1 2 3 4 5
  0 X * X * * *
  1 * X * X * *
  2 * * X * X *
  3 X * * X * X
  4 * X * * X *
  5 * * X * * X
  6 * * * X * *
     */

    public boolean verificarDiagonal(){
        //esquerda para direita
    	for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizJogo[i][j] == pAtual && matrizJogo[i + 1][j + 1] == pAtual &&
                    matrizJogo[i + 2][j + 2] == pAtual && matrizJogo[i + 3][j + 3] == pAtual) {
                    return true;
                }
            }
        }

        /*
    0 1 2 3 4 5
  0 * * * O * *
  1 * * 0 * * *
  2 * 0 * * * *
  3 0 * * * * 0
  4 * * * * 0 *
  5 * * * 0 * *
  6 * * 0 * * *
     */

        //invertendo
    	for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrizJogo[i][j] == pAtual && matrizJogo[i - 1][j + 1] == pAtual &&
                    matrizJogo[i - 2][j + 2] == pAtual && matrizJogo[i - 3][j + 3] == pAtual) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarVencedor() {
        return (verificarDiagonal() || verificarHorizontal() || verificarVertical());
    }

    public char getVencedor(){
        return pAtual;
    }

    public char getpAtual(){
        return pAtual;
    }

    public boolean verificarEmpate() {
        for (int j = 0; j < 7; j++) {
            if (matrizJogo[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }



}

