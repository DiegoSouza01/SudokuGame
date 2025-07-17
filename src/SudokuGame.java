
import java.util.*;

    // Classe principal do jogo Sudoku
    public class SudokuGame {
        private int[][] board;
        private int[][] solution;
        private boolean[][] isFixed;
        private Scanner scanner;
        private static final int SIZE = 9;
        private static final int EMPTY = 0;

        public SudokuGame() {
            board = new int[SIZE][SIZE];
            solution = new int[SIZE][SIZE];
            isFixed = new boolean[SIZE][SIZE];
            scanner = new Scanner(System.in);
        }

        // Método principal para iniciar o jogo
        public void startGame() {
            System.out.println("=== BEM-VINDO AO SUDOKU ===");
            System.out.println("Instruções:");
            System.out.println("- Digite 'jogar' para iniciar um novo jogo");
            System.out.println("- Digite 'sair' para encerrar");
            System.out.println("- Durante o jogo, digite linha, coluna e número (ex: 1 1 5)");
            System.out.println("- Use 0 para apagar uma célula (ex: 1 1 0)");
            System.out.println("- Digite 'dica' para obter uma dica");
            System.out.println("- Digite 'verificar' para validar o tabuleiro");
            System.out.println("- Digite 'resolver' para ver a solução");

            while (true) {
                System.out.print("\nComando: ");
                String command = scanner.nextLine().toLowerCase().trim();

                switch (command) {
                    case "jogar":
                        playGame();
                        break;
                    case "sair":
                        System.out.println("Obrigado por jogar! Até logo!");
                        return;
                    default:
                        System.out.println("Comando inválido. Digite 'jogar' ou 'sair'.");
                }
            }
        }

        // Método principal do gameplay
        private void playGame() {
            generatePuzzle();

            while (true) {
                printBoard();
                System.out.println("\nComandos: [linha col num] | [linha col 0] para apagar | dica | verificar | resolver | menu");
                System.out.print("Sua jogada: ");

                String input = scanner.nextLine().trim();

                if (input.equals("menu")) {
                    break;
                } else if (input.equals("dica")) {
                    giveHint();
                } else if (input.equals("verificar")) {
                    if (isValidBoard()) {
                        if (isBoardComplete()) {
                            System.out.println("\n🎉 PARABÉNS! Você completou o Sudoku! 🎉");
                            break;
                        } else {
                            System.out.println("✓ Tabuleiro válido até agora. Continue jogando!");
                        }
                    } else {
                        System.out.println("❌ Há erros no tabuleiro. Verifique suas jogadas.");
                    }
                } else if (input.equals("resolver")) {
                    System.out.println("\nSolução do puzzle:");
                    printSolution();
                    break;
                } else {
                    processMove(input);
                }
            }
        }

        // Processa uma jogada do usuário
        private void processMove(String input) {
            try {
                String[] parts = input.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Formato inválido. Use: linha coluna número");
                    return;
                }

                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;
                int num = Integer.parseInt(parts[2]);

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("Posição inválida. Use números de 1 a 9.");
                    return;
                }

                if (num < 1 || num > 9) {
                    System.out.println("Número inválido. Use números de 1 a 9.");
                    return;
                }

                if (isFixed[row][col]) {
                    System.out.println("Esta posição não pode ser alterada!");
                    return;
                }

                board[row][col] = num;
                System.out.println("Jogada realizada!");

            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Use números inteiros.");
            }
        }

        // Gera um puzzle de Sudoku
        private void generatePuzzle() {
            // Limpa o tabuleiro
            clearBoard();

            // Gera uma solução válida
            solveSudoku(solution);

            // Copia a solução para o tabuleiro
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = solution[i][j];
                }
            }

            // Remove números aleatoriamente para criar o puzzle
            Random random = new Random();
            int cellsToRemove = 40 + random.nextInt(10); // Remove 40-49 células

            for (int i = 0; i < cellsToRemove; i++) {
                int row = random.nextInt(SIZE);
                int col = random.nextInt(SIZE);

                if (board[row][col] != EMPTY) {
                    board[row][col] = EMPTY;
                    isFixed[row][col] = false;
                }
            }

            // Marca as células preenchidas como fixas
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] != EMPTY) {
                        isFixed[i][j] = true;
                    }
                }
            }
        }

        // Limpa o tabuleiro
        private void clearBoard() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = EMPTY;
                    solution[i][j] = EMPTY;
                    isFixed[i][j] = false;
                }
            }
        }

        // Resolve o Sudoku usando backtracking
        private boolean solveSudoku(int[][] grid) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (grid[row][col] == EMPTY) {
                        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
                        Collections.shuffle(numbers);

                        for (int num : numbers) {
                            if (isValidMove(grid, row, col, num)) {
                                grid[row][col] = num;

                                if (solveSudoku(grid)) {
                                    return true;
                                }

                                grid[row][col] = EMPTY;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        // Verifica se uma jogada é válida
        private boolean isValidMove(int[][] grid, int row, int col, int num) {
            // Verifica linha
            for (int j = 0; j < SIZE; j++) {
                if (grid[row][j] == num) {
                    return false;
                }
            }

            // Verifica coluna
            for (int i = 0; i < SIZE; i++) {
                if (grid[i][col] == num) {
                    return false;
                }
            }

            // Verifica quadrante 3x3
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (grid[i][j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        // Verifica se o tabuleiro atual está válido
        private boolean isValidBoard() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] != EMPTY) {
                        int temp = board[i][j];
                        board[i][j] = EMPTY;
                        if (!isValidMove(board, i, j, temp)) {
                            board[i][j] = temp;
                            return false;
                        }
                        board[i][j] = temp;
                    }
                }
            }
            return true;
        }

        // Verifica se o tabuleiro está completo
        private boolean isBoardComplete() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        // Fornece uma dica ao jogador
        private void giveHint() {
            List<int[]> emptyCells = new ArrayList<>();

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        emptyCells.add(new int[]{i, j});
                    }
                }
            }

            if (emptyCells.isEmpty()) {
                System.out.println("Não há células vazias para dar dica!");
                return;
            }

            Random random = new Random();
            int[] cell = emptyCells.get(random.nextInt(emptyCells.size()));
            int row = cell[0];
            int col = cell[1];

            board[row][col] = solution[row][col];
            System.out.println("Dica: Posição (" + (row + 1) + ", " + (col + 1) + ") = " + solution[row][col]);
        }

        // Imprime o tabuleiro
        private void printBoard() {
            System.out.println("\n   1 2 3   4 5 6   7 8 9");
            System.out.println("  ╔═══════╤═══════╤═══════╗");

            for (int i = 0; i < SIZE; i++) {
                if (i == 3 || i == 6) {
                    System.out.println("  ╟───────┼───────┼───────╢");
                }

                System.out.print((i + 1) + " ║ ");

                for (int j = 0; j < SIZE; j++) {
                    if (j == 3 || j == 6) {
                        System.out.print("│ ");
                    }

                    if (board[i][j] == EMPTY) {
                        System.out.print("· ");
                    } else {
                        // Diferencia visualmente números fixos (pré-definidos) dos inseridos pelo jogador
                        if (isFixed[i][j]) {
                            System.out.print("\033[1m" + board[i][j] + "\033[0m ");  // Negrito para números fixos
                        } else {
                            System.out.print("\033[36m" + board[i][j] + "\033[0m "); // Azul para números do jogador
                        }
                    }
                }
                System.out.println("║");
            }

            System.out.println("  ╚═══════╧═══════╧═══════╝");
        }

        // Imprime a solução
        private void printSolution() {
            System.out.println("\n   1 2 3   4 5 6   7 8 9");
            System.out.println("  ╔═══════╤═══════╤═══════╗");

            for (int i = 0; i < SIZE; i++) {
                if (i == 3 || i == 6) {
                    System.out.println("  ╟───────┼───────┼───────╢");
                }

                System.out.print((i + 1) + " ║ ");

                for (int j = 0; j < SIZE; j++) {
                    if (j == 3 || j == 6) {
                        System.out.print("│ ");
                    }
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println("║");
            }

            System.out.println("  ╚═══════╧═══════╧═══════╝");
        }

        // Método main para executar o jogo
        public static void main(String[] args) {
            SudokuGame game = new SudokuGame();
            game.startGame();
        }
    }
