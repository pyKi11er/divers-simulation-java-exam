# Divers Simulation — Java Exam Project

This project is a simulation of an underwater diving operation to retrieve artefacts using object-oriented programming principles in Java. It was created as part of a university-level programming languages exam (2024/2025-1).

## 🧠 Overview

Divers collect artefacts from the ocean such as `Sample` and `Waste`. The system uses classes, inheritance, interfaces, exception handling, and unit testing with JUnit.

### Core Classes:
- `Artefact`, `Sample`, `Waste` – base objects in the simulation
- `Diver`, `Dumper` – manage artefacts and simulate team operations
- `DivingOperation` – coordinates the entire simulation

## 🔍 Key Concepts Implemented

- Abstract classes and method overriding
- Enums (`Color`)
- Interface implementation (`Marked`)
- Defensive copying
- Custom exception handling (`WrongArtefact`)
- JUnit 5 unit testing
- Object equality and `hashCode`
- Proper encapsulation

## 🧪 Testing

Unit tests were written using JUnit 5 and are located alongside the main classes. The project passed all **structural** and **functional** tests required during the exam setup.

## 🗂 Project Structure

/src
--/environment
----/collectables
----/marker
----...
--/person
----/divers
----/utils
----...
--JUnit test files
README.md(you are here)


## ❗ Notes

- This project was completed as part of a real-time 2-hour Java university exam. Due to exam constraints, comments are minimal.
- `.class` files, `.jar` dependencies, and structural test kits are excluded for clarity.

## 👤 Author

Hayk Grigoryan  
University: ELTE — Programming Languages Exam 2024/2025-1  
