# Genetic & Evolutionary Computation Platform

This project was developed across three incremental phases. Each phase introduces new algorithmic approaches and visualization features that allow users to experiment with genetic and evolutionary techniques applied to optimization problems. The tool includes a GUI for parameter configuration, function selection, and real-time visualization of algorithm performance.

## 📌 Overview

The platform is divided into the following phases:

1. **Phase 1** - Basic Genetic Algorithms applied to numerical optimization.
2. **Phase 2** - Scheduling problems using permutation-based GAs with custom operators.
3. **Phase 3** - Genetic Programming and Grammatical Evolution for rule-based environments (e.g., robot lawn mowing).

---

## ⚙️ Features by Phase

### ✅ Phase 1: Basic Genetic Algorithms

- Optimization of numerical functions using binary and real-coded individuals.
- Customizable operators:
  - **Selection**: Roulette, Stochastic, Tournament (Deterministic & Probabilistic), Truncation, Remainders
  - **Crossover**: One-point, Uniform
  - **Mutation**: Basic bitwise and real-value mutation
- Graphs showing best per generation, best overall, and average fitness.
- **Fitness transformation for minimization problems**.
- **Elitism** and initial attempts at **contractive selection**.
- Modular Java code using OOP principles and factory design patterns.

---

### ✈️ Phase 2: Scheduling with Custom Genetic Operators

In this phase, the problem shifts from numerical optimization to a **real-world-like scheduling task**, where a set of flights must be assigned to a number of runways. Two scenarios were evaluated:

- **Case 1**: 12 flights, 3 runways  
- **Case 2**: 25 flights, 5 runways

#### 🧠 Observations

- **Case 1** typically converges to an optimal solution within 100 generations.
- **Case 2**, being more complex, often requires over 400 generations to reach optimality.

#### 🔧 Improvements Introduced

- **Selective Pressure Visualization**: A yellow curve was added to the convergence graphs to represent selection pressure over time. This helps monitor the loss of genetic diversity and convergence speed.
- **Fitness Shifting**: As in Phase 1, fitness was shifted so that all values are positive by subtracting each fitness from 105% of the generation’s maximum. This allows minimization problems to be treated as maximization.

#### 🔄 OXOP Crossover (Order Crossover with Priorities)

An advanced crossover operator was implemented voluntarily. It:
1. Randomly selects a set of positions from Parent 1.
2. Identifies which genes (flights) are in those positions.
3. Fills the child with Parent 2’s genes excluding the selected ones, keeping the order.
4. Inserts the selected genes in their corresponding positions.

This process is repeated symmetrically to generate two children.

#### 🧪 Custom Operators

##### 🧬 ZigZag Crossover

An original method where:
- Genes are alternately picked from both parents in order, skipping duplicates.
- The first child is created left-to-right; the second right-to-left.
- This guarantees no repeated genes and unique offspring.

##### 🔁 Fibonacci Mutation

This mutation applies a creative transformation based on the **Fibonacci sequence**:
1. Chosen Fibonacci values: `[1, 2, 3, 5]`
2. For each value, a new individual is created by shifting all genes by that amount.
3. From all variants, the one with the best fitness is kept.

**Example with individual** `[9,3,2,12,4,11,8,7,10,1,6,5]`:

- +1 → `[5,9,3,2,12,4,11,8,7,10,1,6]`
- +2 → `[6,5,9,3,2,12,4,11,8,7,10,1]`
- +3 → `[1,6,5,9,3,2,12,4,11,8,7,10]`
- +5 → `[7,10,1,6,5,9,3,2,12,4,11,8]`

This approach introduces diversity and often leads to better exploration of the search space.

---

### 🌳 Phase 3: Genetic Programming & Grammatical Evolution

- Tree-based individual representation with control structures:
  - `IF-DIRTY`, `REPEAT-X`, `REPEAT-Y`, `TURN RIGHT`
- Custom garden-mowing simulation visualized in a GUI.
- Supports **depth control** and **bloating prevention**.
- Integration of **Grammatical Evolution** using BNF grammars:
  - Individuals as arrays of integers (codons).
  - Custom rules defined via `.txt` grammar files.
  - Wrap control to limit recursion during decoding.

---

## 🧠 Architecture

- **Language**: Java
- **Paradigm**: Object-Oriented with emphasis on abstraction and reuse.
- **UI**: Java Swing + JFreeChart
- **Design Pattern**: MVC

### Key Classes:
- `Individuo<T>` / `IndividuoBinario` / `IndividuoReal`
- `TPoblacion`
- `Selector`, `Cruzador`, `Mutador` (strategy pattern)
- `AlgoritmoGenetico` (universal algorithm logic)
- `Controller`, `TParametros`, `TResultStatistics`
- `MainWindow` (UI interface)
- `Nodo` (tree representation for GP)
- `BNFGramatical` (GE interpreter)

---

## 📈 Visualization

- Real-time plots for:
  - Best, average, and worst fitness over generations
  - Selective pressure (Phase 2)
- Interactive grid for Genetic Programming execution
- Pattern visualization for GE with grammar-based decoding

---

## 🧪 How to Run

1. Compile the project with `javac` or your preferred Java IDE.
2. Run the main UI from `MainWindow.java`.
3. Select:
   - Phase (GA, Scheduling, GP, or GE)
   - Function/problem type
   - Algorithm parameters
4. Click "Run" and observe convergence charts or behavior on the grid.


## 📄 License

This project was developed as part of a university course on Evolutionary Computation. Educational and non-commercial use only.
