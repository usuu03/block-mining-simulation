# Block Mining Simulation in Java

This project is a **block mining simulation** written in Java. It demonstrates the basic concepts of blockchain, including **proof-of-work** and hashing. The program creates blocks, each containing metadata such as the hash of the previous block, the miner's pseudonym, and a dynamically adjustable difficulty level.

## Features

1. **SHA-256 Hashing**: Ensures block integrity.
2. **Proof-of-Work Simulation**: Uses a `difficulty` parameter to define how many leading zeros the hash must have.
3. **Dynamic Difficulty Adjustment**: Iteratively increases difficulty to show the mining process under progressively harder conditions.
4. **Randomized Nonce Generation**: Uses a `nonce` (random number) to alter the block's hash until the difficulty requirement is met.

---

## Code Overview

### Core Components

1. **`Block` Class**:

   - Stores block metadata:
     - `previousHash`: Hash of the previous block.
     - `pseudonym`: Name of the miner.
     - `difficulty`: Number of leading zeros required in the hash.
     - `hash`: Computed SHA-256 hash for the block.
     - `nonce`: Random number used to meet the difficulty requirement.
   - Key Methods:
     - `generateMine()`: Performs mining by generating hashes until one meets the required difficulty.
     - `toString()`: Returns a readable representation of the block.

2. **Main Method**:
   - Starts with an initial `previousHash`.
   - Iteratively mines blocks, increasing the `difficulty` from 1 to 40.
   - Prints each block's details after successful mining.

---

## Prerequisites

### Tools Required

- **Java Development Kit (JDK)**: Version 8 or later.
- **Integrated Development Environment (IDE)** (e.g., IntelliJ, Eclipse) or a text editor.

### Knowledge Required

- Basic understanding of Java programming.
- Familiarity with blockchain concepts such as:
  - Proof-of-Work.
  - Hashing algorithms (e.g., SHA-256).

---

## How to Run

1. **Clone the Repository**:

   ```bash
   git clone <repository_url>
   cd <repository_directory>
   ```

2. **Compile the Program**:

   ```bash
   javac Block.java
   ```

3. **Run the Program**:

   ```bash
   java Block
   ```

4. **Observe the Output**:
   - Each block's details will be printed to the console.
   - Example output for `difficulty = 1`:
     ```
     Block: - Previous Hash: 000000000a1049209e53f14b7acbbb580273372946c4058647dd6311fa4c81e5, Miner: maquina, Nonce: -8442967256134226201, Difficulty: 1, Hash: 06fd574890123bd42c5db4ff37e72a0aef7f792c8d56e85e979daedb2c00399f
     ```

---

## How It Works

1. **Mining a Block**:

   - Combine `previousHash`, `pseudonym`, and a randomly generated `nonce` into a string (block header).
   - Hash the block header using the SHA-256 algorithm.
   - Check if the resulting hash starts with the required number of zeros (`difficulty`).
   - If not, generate a new `nonce` and repeat.

2. **Difficulty Adjustment**:
   - The `main` method increases the `difficulty` from 1 to 40, making mining progressively harder.

---

## Suggested Improvements

1. **Persistence**: Save mined blocks to a database or file.
2. **Network Simulation**: Implement multiple miners to simulate competition.
3. **Blockchain**: Extend the program to maintain a chain of blocks.
4. **Performance Optimization**: Use multithreading to parallelize mining.

---

## Concepts Demonstrated

- **Proof-of-Work**: Illustrates the computational effort required to mine a block.
- **Cryptographic Hashing**: Uses SHA-256 to ensure block immutability.
- **Dynamic Difficulty**: Simulates the adjustment of mining difficulty in real blockchain networks.

---

## License

This project is open-source and available under the MIT License. Feel free to modify and distribute it as you see fit.
