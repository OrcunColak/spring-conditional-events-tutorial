The original idea is from  
https://arvind4gl.medium.com/detailed-explanation-of-eventlistener-b3d6796780ac

More complex conditional examples

```java
@EventListener(condition = "#event.user=='arvind'")     // Equality
@EventListener(condition = "#event.user!='arvind'")     // Inequality
@EventListener(condition = "#event.age > 18")           // Greater than
@EventListener(condition = "#event.age >= 18")          // Greater than or equal
@EventListener(condition = "#event.age < 18")           // Less than
@EventListener(condition = "#event.age <= 18")          // Less than or equal
@EventListener(condition = "#event.user matches 'ar.*'") // Regex match
@EventListener(condition = "#event.role.equals('ADMIN')") // Object equality

// Logical operators
@EventListener(condition = "#event.age > 18 and #event.user=='arvind'")  // AND
@EventListener(condition = "#event.age > 18 or #event.user=='arvind'")   // OR
@EventListener(condition = "!#event.isDeleted")                          // NOT

// Collection operations
@EventListener(condition = "#event.roles.contains('ADMIN')")             // Contains
@EventListener(condition = "#event.tags.size() > 0")                     // Size check

// Null checks
@EventListener(condition = "#event.user != null")                        // Not null

@EventListener(condition = "#event.user?.length() > 5")  // Safe navigation
@EventListener(condition = "#event instanceof T(com.example.AdminEvent)") // Type check
@EventListener(condition = "#event.timestamp > T(java.time.Instant).now().minusSeconds(3600)") // Time comparison
```