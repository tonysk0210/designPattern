# Repository Guidelines

## Project Structure & Module Organization
- `src/` — Java source (e.g., `src/singleton/Singleton.java`).
- `out/production/PatternDesign/` — compiled classes (e.g., `singleton/Main.class`).
- `.idea/`, `*.iml` — IntelliJ project metadata (do not edit in PRs).
- Add new packages under `src/<package>/` using lowercase package names.

## Build, Test, and Development Commands
- Compile (no build tool): `javac -d out/production/PatternDesign src/**/*.java`
- Run (example main): `java -cp out/production/PatternDesign singleton.Main`
- Clean: delete `out/production/PatternDesign` before a fresh compile.
- IDE: Prefer IntelliJ “Build Project” and “Run” configs for day‑to‑day.

## Coding Style & Naming Conventions
- Java 8+ style; 4‑space indentation; max line length ~120.
- Packages: lowercase (`singleton`); classes: PascalCase (`EnumSingleton`);
  methods/fields: camelCase (`getInstance`); constants: UPPER_SNAKE_CASE.
- One public top‑level class per file; filename matches class name.
- Braces: K&R style; avoid wildcard imports; keep methods focused and small.

## Testing Guidelines
- Prefer JUnit 5. Place tests under `src/test/java/<package>/` mirroring source.
- Test names: `<ClassName>Test.java` with descriptive `@Test` method names.
- Aim for covering critical branches of patterns (creation, threading, errors).
- Run tests via IDE; if a build tool is introduced later, wire tests accordingly.

## Commit & Pull Request Guidelines
- Use imperative, concise messages. Prefer Conventional Commits:
  - `feat: add thread-safe singleton`
  - `fix: guard enum singleton against reflection`
- PRs must include: scope/intent, before/after notes, and linked issues (`#123`).
- Keep changes focused; include small example usage or snippet when applicable.

## Agent-Specific Notes
- Scope: This guide applies to the entire repository unless overridden by
  a nested `AGENTS.md`.
- When adding code, align with the existing package layout under `src/` and
  keep output in `out/production/PatternDesign` for manual builds.
