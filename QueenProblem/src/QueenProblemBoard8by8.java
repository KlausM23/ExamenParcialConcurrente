public class QueenProblemBoard8by8 {
    int N = 8;

    public QueenProblemBoard8by8() {
    }

    void imprimirSolucion(int[][] tablero) {
        for(int i = 0; i < this.N; ++i) {
            for(int j = 0; j < this.N; ++j) {
                System.out.print(" " + tablero[i][j] + " ");
            }

            System.out.println();
        }

    }

    boolean permitirMover(int[][] tablero, int filas, int columnas) {
        int i;
        for(i = 0; i < columnas; ++i) {
            if (tablero[filas][i] == 1) {
                return false;
            }
        }

        i = filas;

        int j;
        for(j = columnas; i >= 0 && j >= 0; --j) {
            if (tablero[i][j] == 1) {
                return false;
            }

            --i;
        }

        i = filas;

        for(j = columnas; j >= 0 && i < this.N; --j) {
            if (tablero[i][j] == 1) {
                return false;
            }

            ++i;
        }

        return true;
    }

    boolean solucionPrincipalQueensBack(int[][] tablero, int col) {
        if (col >= this.N) {
            return true;
        } else {
            for(int i = 0; i < this.N; ++i) {
                if (this.permitirMover(tablero, i, col)) {
                    tablero[i][col] = 1;
                    if (this.solucionPrincipalQueensBack(tablero, col + 1)) {
                        return true;
                    }

                    tablero[i][col] = 0;
                }
            }

            return false;
        }
    }

    boolean solucionQueens() {
        int inicio = 0;
        int[][] tablero = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        if (!this.solucionPrincipalQueensBack(tablero, inicio)) {
            System.out.print("Solution does not exist");
            return false;
        } else {
            this.imprimirSolucion(tablero);
            return true;
        }
    }

    public static void main(String[] args) {
        QueenProblemBoard8by8 queensPorblemBoard8by8 = new QueenProblemBoard8by8();
        queensPorblemBoard8by8.solucionQueens();
    }
}
