# 🎯 Jogo de Sudoku em Java

Um jogo de Sudoku completo e interativo desenvolvido em Java para terminal, implementando todas as funcionalidades essenciais para uma experiência de jogo envolvente.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Execução](#instalação-e-execução)
- [Como Jogar](#como-jogar)
- [Estrutura do Código](#estrutura-do-código)
- [Algoritmos Implementados](#algoritmos-implementados)
- [Exemplos de Uso](#exemplos-de-uso)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🎮 Sobre o Projeto

Este projeto foi desenvolvido como um desafio de programação orientada a objetos em Java, implementando um jogo de Sudoku completo com geração automática de puzzles, validação de jogadas, sistema de dicas e interface interativa no terminal.

### Objetivos Alcançados

- ✅ Consolidar conhecimentos em POO (Programação Orientada a Objetos)
- ✅ Implementar manipulação de estruturas de dados (arrays bidimensionais)
- ✅ Criar sistema de validação robusto
- ✅ Desenvolver interface interativa no terminal
- ✅ Aplicar algoritmos de backtracking
- ✅ Implementar geração automática de puzzles

## 🚀 Funcionalidades

### 🎲 Geração de Puzzles
- Criação automática de puzzles válidos
- Algoritmo de backtracking para garantir soluções únicas
- Níveis de dificuldade variados (40-49 células removidas)

### 🎮 Gameplay Interativo
- **Jogadas**: Inserir números em posições específicas
- **Apagar**: Remover números usando o valor 0
- **Dicas**: Sistema inteligente de dicas
- **Validação**: Verificação em tempo real das regras do Sudoku
- **Solução**: Exibição da solução completa

### 🎨 Interface Visual
- Tabuleiro formatado com bordas e separadores
- Diferenciação visual entre números fixos (negrito) e do jogador (azul)
- Indicadores visuais para células vazias
- Feedback claro para todas as ações

### 🔧 Funcionalidades Técnicas
- Validação robusta de entrada
- Tratamento de erros
- Sistema de navegação por menus
- Algoritmos otimizados

## 📋 Pré-requisitos

- **Java**: Versão 8 ou superior (testado com Java 21)
- **IDE**: IntelliJ IDEA, Eclipse, VS Code ou qualquer editor de texto
- **Terminal**: Suporte a caracteres UTF-8 para melhor visualização

## 🛠️ Instalação e Execução

### Método 1: IntelliJ IDEA

1. **Clone ou baixe o projeto**
   ```bash
   git clone <url-do-repositorio>
   ```

2. **Abra o IntelliJ IDEA**
   - File → New → Project from Existing Sources
   - Selecione a pasta do projeto

3. **Execute o projeto**
   - Clique direito em `SudokuGame.java`
   - Selecione "Run 'SudokuGame.main()'"
   - Ou use o atalho `Shift + F10`

### Método 2: Terminal/Linha de Comando

1. **Navegue até o diretório do projeto**
   ```bash
   cd caminho/para/o/projeto
   ```

2. **Compile o código**
   ```bash
   javac SudokuGame.java
   ```

3. **Execute o jogo**
   ```bash
   java SudokuGame
   ```

## 🎯 Como Jogar

### Comandos Principais

| Comando | Descrição | Exemplo |
|---------|-----------|---------|
| `jogar` | Inicia um novo jogo | `jogar` |
| `sair` | Encerra o programa | `sair` |

### Comandos Durante o Jogo

| Comando | Descrição | Exemplo |
|---------|-----------|---------|
| `[linha] [coluna] [número]` | Insere um número | `1 1 5` |
| `[linha] [coluna] 0` | Apaga uma célula | `1 1 0` |
| `dica` | Recebe uma dica | `dica` |
| `verificar` | Valida o tabuleiro | `verificar` |
| `resolver` | Mostra a solução | `resolver` |
| `menu` | Volta ao menu principal | `menu` |

### Regras do Sudoku

1. **Linhas**: Cada linha deve conter números de 1 a 9, sem repetição
2. **Colunas**: Cada coluna deve conter números de 1 a 9, sem repetição
3. **Quadrantes**: Cada quadrante 3x3 deve conter números de 1 a 9, sem repetição

### Dicas Visuais

- **Números em negrito**: Números fixos do puzzle original
- **Números em azul**: Números inseridos pelo jogador
- **Símbolo ·**: Células vazias

## 🏗️ Estrutura do Código

### Classe Principal: `SudokuGame`

```java
public class SudokuGame {
    // Atributos
    private int[][] board;          // Tabuleiro atual
    private int[][] solution;       // Solução completa
    private boolean[][] isFixed;    // Células fixas
    private Scanner scanner;        // Entrada do usuário
    
    // Métodos principais
    public void startGame()         // Inicia o jogo
    private void playGame()         // Loop principal do jogo
    private void generatePuzzle()   // Gera puzzle
    private boolean solveSudoku()   // Resolve usando backtracking
    private void printBoard()       // Exibe o tabuleiro
}
```

### Principais Métodos

#### `generatePuzzle()`
- Gera uma solução completa usando backtracking
- Remove células aleatoriamente para criar o puzzle
- Marca células fixas

#### `solveSudoku(int[][] grid)`
- Implementa algoritmo de backtracking
- Garante soluções válidas e únicas
- Usa randomização para variedade

#### `isValidMove(int[][] grid, int row, int col, int num)`
- Valida regras do Sudoku
- Verifica linha, coluna e quadrante 3x3
- Retorna true se a jogada é válida

#### `printBoard()`
- Renderiza o tabuleiro formatado
- Aplica cores e formatação
- Exibe coordenadas e bordas

## 🧮 Algoritmos Implementados

### 1. Backtracking para Geração de Puzzles

```java
private boolean solveSudoku(int[][] grid) {
    // Encontra célula vazia
    // Tenta números de 1-9 randomicamente
    // Recursão para próxima célula
    // Backtrack se não há solução
}
```

### 2. Validação de Jogadas

```java
private boolean isValidMove(int[][] grid, int row, int col, int num) {
    // Verifica linha
    // Verifica coluna  
    // Verifica quadrante 3x3
    // Retorna resultado
}
```

### 3. Geração Aleatória de Puzzles

```java
private void generatePuzzle() {
    // Gera solução completa
    // Remove 40-49 células aleatoriamente
    // Garante puzzle solucionável
}
```

## 💡 Exemplos de Uso

### Exemplo 1: Iniciando um Jogo
```
=== BEM-VINDO AO SUDOKU ===
Comando: jogar

   1 2 3   4 5 6   7 8 9
  ╔═══════╤═══════╤═══════╗
1 ║ 5 3 · │ · 7 · │ · · · ║
2 ║ 6 · · │ 1 9 5 │ · · · ║
```

### Exemplo 2: Fazendo uma Jogada
```
Sua jogada: 1 3 4
Jogada realizada!
```

### Exemplo 3: Pedindo uma Dica
```
Sua jogada: dica
Dica: Posição (1, 3) = 4
```

### Exemplo 4: Verificando o Tabuleiro
```
Sua jogada: verificar
✓ Tabuleiro válido até agora. Continue jogando!
```

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal (compatível com Java 8+)
- **Scanner**: Para entrada de dados
- **Arrays bidimensionais**: Estrutura de dados principal
- **Collections**: Para manipulação de listas
- **Random**: Para geração aleatória
- **ANSI Escape Codes**: Para formatação colorida no terminal

## 🔧 Possíveis Melhorias

- [ ] Implementar diferentes níveis de dificuldade
- [ ] Adicionar sistema de pontuação
- [ ] Salvar e carregar jogos
- [ ] Interface gráfica (GUI)
- [ ] Multiplayer local
- [ ] Estatísticas de jogo
- [ ] Themes visuais
- [ ] Modo competitivo com timer

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

## 👨‍💻 Autor

Desenvolvido como projeto educacional em Java.

**Contato:**
- 📧 Email: [diegodecstraid@gmail.com]
- 🐙 GitHub: [https://github.com/DiegoSouza01]

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!

## 🎯 Status do Projeto

✅ **Concluído** - Todas as funcionalidades principais implementadas

**Última atualização:** Julho 2025
