# Artificial Intelligence Project in Java

A Java-based Artificial Intelligence project that combines **heuristic search**, **knowledge representation**, and **logical inference** through three independent but conceptually connected parts.

This repository demonstrates core AI topics including:

* state-space search
* problem solving with heuristics
* propositional logic inference
* first-order logic inference
* Horn clauses
* forward chaining
* unification

The project is organized as a collection of academic implementations that showcase both **search-based AI** and **symbolic reasoning**.

---

## Overview

This project is divided into two main sections:

### Part 1 — Missionaries and Cannibals

A classic state-space search problem in which missionaries and cannibals must cross a river under a set of safety constraints.

### Part 2 — Logical Inference Systems

This section is further divided into two subparts:

* **Part 2A:** Forward Chaining in **Propositional Logic**
* **Part 2B:** Forward Chaining in **First-Order Predicate Logic** with **Unification**

Together, these parts form a complete introductory Artificial Intelligence project that covers two major areas of the field:

* **Search and problem solving**
* **Knowledge representation and reasoning**

---

## Educational Goals

The project was developed to demonstrate fundamental AI concepts in practice.

Through its three parts, it explores:

* how problems can be modeled as states and transitions
* how heuristics guide search toward solutions
* how knowledge bases can store facts and rules
* how forward chaining derives new knowledge
* how Horn clauses support efficient inference
* how unification enables reasoning with variables in first-order logic

It is especially relevant for courses such as:

* Artificial Intelligence
* Knowledge Representation
* Automated Reasoning
* Logic in Computer Science
* Search Algorithms and Problem Solving

---

## Project Structure

```text
AI_Project/
├── part1/
│   ├── main.java
│   ├── searcher.java
│   └── state.java
├── part2/
│   ├── Part2A/
│   │   ├── Base.java
│   │   ├── FC_PL.java
│   │   ├── Horn.java
│   │   ├── Main.java
│   │   └── knowledge_base.txt
│   └── Part2B/
│       ├── BaseKat.java
│       ├── FC_Kat.java
│       ├── HornKat.java
│       ├── MainKat.java
│       ├── Unifier.java
│       └── knowledge_base_kat.txt
├── README.md
└── .gitignore
```

---

## Technologies Used

* **Java**
* Standard Java collections
* File-based knowledge base loading
* Heuristic search techniques
* Forward chaining inference
* First-order logic unification

---

# Part 1 — Missionaries and Cannibals

## Problem Description

The first part of the project solves the classical **Missionaries and Cannibals** problem.

A number of missionaries and cannibals start on one side of a river and must all cross to the opposite side using a boat with limited capacity.

The system must respect the constraint that on either river bank, cannibals must never outnumber missionaries when missionaries are present. Otherwise, the state is considered invalid.

The user provides:

* the number of missionaries and cannibals
* the boat capacity
* the maximum allowed number of crossings

The program then attempts to find a valid solution path.

---

## AI Concepts Demonstrated in Part 1

This part demonstrates:

* state representation
* successor generation
* validity checking
* goal-state testing
* heuristic evaluation
* closed-set search to avoid revisiting states
* path reconstruction through stored transitions

It is a classic example of **state-space search** in Artificial Intelligence.

---

## Main Components of Part 1

### `main.java`

This is the entry point of the first part.

Its responsibilities include:

* reading user input
* constructing the initial state
* starting the search process
* measuring execution time
* printing the solution path if one is found

### `searcher.java`

This class implements the search logic.

It maintains:

* an **open list** of candidate states to explore
* a **closed set** of already visited states

The search process expands states, generates valid children, avoids repeated exploration, and orders the open list according to a heuristic value.

### `state.java`

This class models a complete configuration of the problem.

Each state contains:

* number of missionaries on the left bank
* number of missionaries on the right bank
* number of cannibals on the left bank
* number of cannibals on the right bank
* boat position
* boat capacity
* transition history

It also provides methods for:

* checking whether a state is valid
* checking whether a state is final
* computing heuristic values
* generating child states
* comparing states for duplicate detection

---

## Search Workflow in Part 1

The search process follows these steps:

1. Construct the initial state with all missionaries and cannibals on the starting bank.
2. Insert the initial state into the open list.
3. Repeatedly remove the next state to examine.
4. Check whether the state is a goal state.
5. If not, add it to the closed set.
6. Generate all possible child states by simulating legal boat moves.
7. Keep only the valid states.
8. Add unexplored states to the open list.
9. Sort the open list according to the heuristic value.
10. Continue until a solution is found or the search space is exhausted.

This creates a heuristic-guided exploration of the problem space.

---

## State Validation

A state is considered valid only if:

* no population count becomes negative
* missionaries are never outnumbered by cannibals on the left bank when missionaries are present
* missionaries are never outnumbered by cannibals on the right bank when missionaries are present

This validity check is the key constraint that shapes the state-space of the problem.

---

## Goal State

The problem is solved when:

* all missionaries are on the destination bank
* all cannibals are on the destination bank
* the boat has also reached the destination side

At that point, the program prints the full sequence of transitions that led to the solution.

---

## Heuristic Role

The first part uses a heuristic function to guide the search toward promising states.

The heuristic is based on how many people remain on the starting side of the river and whether the boat is on the left or right side. This gives the algorithm a way to prioritize states that appear closer to the solution.

This makes the program more efficient than an uninformed blind search.

---

## Output of Part 1

When a solution is found, the program prints:

* the final state
* the number of crossings used
* the sequence of boat movements
* execution time

If no solution is found within the explored space or within the crossing limit, the program reports failure.

---

# Part 2 — Logical Inference Systems

The second main section of the project focuses on **knowledge representation and reasoning**.

It is divided into two subparts:

* propositional logic reasoning
* first-order predicate logic reasoning

Both subparts use **Horn clauses** and **forward chaining** as the main reasoning mechanism.

---

# Part 2A — Forward Chaining in Propositional Logic

## Purpose

Part 2A implements a simple forward chaining engine for **propositional logic**.

The system reads a knowledge base containing:

* atomic facts
* Horn rules of the form `A & B -> C`

It then receives a query and determines whether the query can be derived from the known facts and rules.

---

## Main Components of Part 2A

### `Base.java`

Represents the propositional knowledge base.

It stores:

* a set of facts
* a list of Horn rules

It provides methods to add facts and rules and to print the contents of the knowledge base.

### `Horn.java`

Represents a single Horn clause.

Each Horn rule contains:

* a list of premises
* a conclusion

This is the core data structure for rule-based inference.

### `FC_PL.java`

Implements the propositional forward chaining algorithm.

Its responsibilities include:

* maintaining an agenda of facts to process
* tracking already inferred propositions
* counting how many premises remain unsatisfied for each rule
* deriving new facts when all premises of a rule are satisfied

### `Main.java`

Acts as the entry point for propositional inference.

It:

* loads the knowledge base from file
* displays the loaded facts and rules
* reads a user query
* runs the forward chaining procedure
* prints whether the query is derivable

### `knowledge_base.txt`

Stores the propositional facts and Horn rules used by the inference engine.

This file serves as the input knowledge base for the system.

---

## Reasoning Process in Part 2A

The forward chaining algorithm works in a data-driven way:

1. All known facts are inserted into an agenda.
2. Facts are processed one by one.
3. For each fact, the system checks which rules depend on it.
4. The number of unsatisfied premises for each rule is updated.
5. When a rule has no remaining unmet premises, its conclusion is derived.
6. Newly derived conclusions are added to the agenda.
7. The process continues until the query is found or no more new facts can be generated.

This is a classic and efficient strategy for inference in Horn-clause knowledge bases.

---

## Example Knowledge Model in Part 2A

A simple knowledge base may contain:

* `A`
* `B`
* `A & B -> C`
* `C -> D`

In this case, the system can derive:

* `C` from `A` and `B`
* `D` from `C`

This demonstrates how new propositions emerge from previously known facts.

---

## Concepts Demonstrated in Part 2A

* propositional logic
* Horn clauses
* forward chaining
* knowledge bases
* agenda-based inference
* rule activation
* symbolic reasoning

---

# Part 2B — Forward Chaining in First-Order Logic with Unification

## Purpose

Part 2B extends the previous inference system from propositional logic to **first-order predicate logic**.

Instead of using only atomic symbols, the system now works with predicates that contain arguments, such as:

* `Parent(John,Mary)`
* `Child(Mary,Alice)`

It also supports rules with variables, such as:

* `Parent(x,y) & Child(y,z) -> Grandparent(x,z)`

To reason with such rules, the system must perform **unification** and **substitution**.

---

## Main Components of Part 2B

### `BaseKat.java`

Represents the first-order knowledge base.

It stores:

* predicate facts
* Horn rules with predicates

### `HornKat.java`

Represents a Horn rule in first-order predicate logic.

Each rule includes:

* a list of predicate premises
* a predicate conclusion

### `FC_Kat.java`

Implements the forward chaining procedure for first-order logic.

It is responsible for:

* processing known predicate facts
* checking whether rule premises can be matched to existing facts
* invoking unification
* generating substitutions
* instantiating new conclusions
* adding derived predicates back into the knowledge base

### `Unifier.java`

Implements the unification mechanism.

This is one of the most important AI-related components of the project.

It supports:

* variable matching
* term decomposition
* recursive comparison of compound terms
* substitution construction
* occurs check

Through these operations, the system can match predicates with variables to concrete facts.

### `MainKat.java`

Acts as the entry point of the first-order inference system.

It:

* loads the first-order knowledge base from file
* prints the knowledge base
* reads the query from the user
* runs the inference process
* reports whether the query can be derived

### `knowledge_base_kat.txt`

Contains the initial first-order facts and Horn rules.

This file serves as the data source for the first-order reasoning engine.

---

## Reasoning Process in Part 2B

The inference process in this part is more sophisticated because it must reason with predicates and variables.

The workflow is:

1. Load all first-order facts and rules from the knowledge base.
2. Insert the known facts into the agenda.
3. Process facts one by one.
4. For each rule, attempt to match its premises against known facts.
5. Use the unifier to determine whether variable substitutions can satisfy the rule premises.
6. If successful, instantiate the conclusion using the discovered substitutions.
7. Add the new derived predicate to the knowledge base and agenda.
8. Continue until the query is derived or no new predicates can be generated.

This creates a first-order extension of the forward chaining process used in Part 2A.

---

## Unification

Unification is the key mechanism that distinguishes Part 2B from Part 2A.

It allows the system to match symbolic expressions with variables to concrete expressions.

For example, the rule premise:

* `Parent(x,y)`

can be unified with the fact:

* `Parent(John,Mary)`

producing the substitution:

* `x = John`
* `y = Mary`

This substitution can then be used in other premises and in the rule conclusion.

Through unification, the system can generalize inference beyond fixed atomic propositions and reason over structured symbolic knowledge.

---

## Example Knowledge Model in Part 2B

A first-order knowledge base may contain:

* `Parent(John,Mary)`
* `Child(Mary,Alice)`
* `Parent(x,y) & Child(y,z) -> Grandparent(x,z)`

Using forward chaining and unification, the system can derive:

* `Grandparent(John,Alice)`

This is a classic example of rule-based symbolic reasoning in first-order logic.

---

## Concepts Demonstrated in Part 2B

* first-order predicate logic
* Horn clauses with variables
* forward chaining
* unification
* variable substitution
* structured symbolic reasoning
* derivation of new predicate facts

---

# Comparison of the Three Parts

Each part focuses on a different AI theme.

## Part 1

Focuses on **search and problem solving**.

Main idea:

* find a valid sequence of actions leading from an initial state to a goal state

## Part 2A

Focuses on **propositional knowledge representation and inference**.

Main idea:

* derive a new proposition from known facts and Horn rules

## Part 2B

Focuses on **first-order symbolic reasoning**.

Main idea:

* derive a new predicate by combining Horn rules, forward chaining, and unification

Together, these parts provide a balanced introduction to both algorithmic search and symbolic inference in AI.

---

## How to Compile and Run

Because the project is divided into separate parts, each section can be compiled and run independently.

### Part 1

Compile:

```bash
javac main.java searcher.java state.java
```

Run:

```bash
java main
```

### Part 2A

Compile:

```bash
javac Base.java FC_PL.java Horn.java Main.java
```

Run:

```bash
java Main
```

### Part 2B

Compile:

```bash
javac BaseKat.java FC_Kat.java HornKat.java MainKat.java Unifier.java
```

Run:

```bash
java MainKat
```

Make sure the corresponding knowledge base files remain in the correct folder when executing each part.

---

## Why This Project Is Interesting

This repository is especially interesting because it covers multiple fundamental aspects of Artificial Intelligence in one place.

It is not limited to a single algorithm or a single type of problem. Instead, it demonstrates:

* search in state spaces
* heuristic guidance
* symbolic logic systems
* inference with Horn clauses
* unification for first-order logic

This makes the project a strong academic example of how different AI techniques address very different types of reasoning tasks.

---

## Learning Outcomes

By studying this repository, one can gain practical understanding of:

* how to represent search states
* how to generate valid successor states
* how heuristics influence search order
* how rule-based systems derive new facts
* how propositional and first-order logic differ
* how unification supports reasoning with variables
* how forward chaining operates in different logic settings

---

## Possible Extensions

The project has a modular academic structure and could be extended in many ways.

Possible future extensions include:

* implementing breadth-first or A* search for Part 1
* adding graphical visualization of the river-crossing solution path
* supporting larger and more complex propositional knowledge bases
* adding backward chaining inference
* extending unification with more advanced term handling
* supporting more expressive logical rule languages
* building a unified interface for all three parts

These possibilities make the project a strong foundation for further AI experimentation.

---

## Repository Goals

This repository showcases:

* a classic search problem solved in Java
* propositional forward chaining with Horn clauses
* first-order forward chaining with unification
* practical implementations of introductory AI techniques
* a strong academic project combining search and reasoning

---

## Authors


* Konstantinos Gougas

---

## Final Notes

This project demonstrates how core Artificial Intelligence ideas can be translated into working Java implementations. By combining search-based problem solving with symbolic reasoning and inference, it provides a complete educational overview of multiple foundational AI topics within a single repository.
