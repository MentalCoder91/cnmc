# Codebase Task Proposals

This file captures four concrete, scoped tasks discovered during a quick review of the codebase.

## 1) Typo fix task

**Task:** Correct the misspelled error text `Error Occured as user not present` to `Error occurred: user not present` in `AuthService.loginUser`.

- **Why:** The current user-facing message contains a typo (`Occured`), which looks unpolished and may complicate log/error searching.
- **Location:** `src/main/java/com/authservice/authenticationservice/service/AuthService.java`.

## 2) Bug fix task

**Task:** Return both access and refresh tokens from registration (or stop generating refresh token if not used).

- **Why:** `register` currently generates a refresh token but discards it, which is a functional inconsistency and likely a bug in auth flow design.
- **Suggested implementation:** Extend `AuthResponse` with `refreshToken` and populate it in `AuthService.register`.
- **Locations:**
  - `src/main/java/com/authservice/authenticationservice/service/AuthService.java`
  - `src/main/java/com/authservice/authenticationservice/entity/AuthResponse.java`

## 3) Code comment/documentation discrepancy task

**Task:** Resolve discrepancy between register comments and actual implementation.

- **Why:** `register` contains comments indicating user-existence validation and password hashing, but neither behavior is currently active (hashing line is commented out, validation not implemented). This misleads maintainers.
- **Suggested implementation options:**
  1. Implement the commented/intended behavior; or
  2. Replace comments with accurate Javadoc explaining the current delegated behavior to `user-service`.
- **Location:** `src/main/java/com/authservice/authenticationservice/service/AuthService.java`.

## 4) Test improvement task

**Task:** Add unit tests for `JwtUtil` token generation/validation and a service-level test for `AuthService.loginUser` null-user behavior.

- **Why:** Current test suite contains only a context smoke test and does not verify critical auth behavior.
- **Suggested additions:**
  - `JwtUtil` test: token contains expected subject and expires as configured.
  - `AuthService` test with mocked `RestTemplate`: assert exception path when login returns null, and success path returns token.
- **Location:** `src/test/java/com/authservice/authenticationservice/`.
