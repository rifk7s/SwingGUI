# CS2 Skin Rating GUI

This project is a Java Swing application designed to display and allow users to rate CS2 (Counter-Strike 2) weapon skins. It features a dark-themed user interface with a title bar, a sidebar for navigation (e.g., by weapon type), a central content area displaying skin images and names in a card layout, and a bottom panel for actions like rating or saving.

## Showcase

![Application Screenshot](img/showcase/Screenshot.png)

## Object-Oriented Programming (OOP) Concepts Utilized

The `CS2_SkinRating.java` file demonstrates several key OOP concepts:

### 1. Classes and Objects

*   **Class:** A blueprint for creating objects.
    *   `CS2_SkinRating`: This is the main class of the application, defining the structure and behavior of the main window.
    *   Swing classes like `JFrame`, `JPanel`, `JButton`, `JLabel`, `ImageIcon`, `JScrollPane`, `Dimension`, `Color`, `Font`, `BorderLayout`, `GridLayout`, `FlowLayout`, `BoxLayout`, `EmptyBorder`, `BorderFactory` are used extensively. Each of these defines a type of UI component or layout manager.
*   **Object:** An instance of a class.
    *   `new CS2_SkinRating()`: Creates an object (an instance) of the `CS2_SkinRating` class, which represents the application window.
    *   `JPanel mainPanel = new JPanel(...)`: Creates an object of the `JPanel` class.
    *   `JButton discordButton = new JButton(...)`: Creates an object of the `JButton` class.
    *   Each UI element you see (labels, buttons, panels) is an object created from its respective class.

### 2. Inheritance (IS-A Relationship)

*   **Concept:** A mechanism where a new class (subclass or derived class) inherits properties and methods from an existing class (superclass or base class).
*   **Example:**
    *   `public class CS2_SkinRating extends JFrame`
        *   The `CS2_SkinRating` class *is a* `JFrame`. It inherits all the characteristics and functionalities of a `JFrame` (like having a title bar, content pane, ability to be resized, closed, etc.) and can add its own specific features or override existing ones.

### 3. Encapsulation

*   **Concept:** Bundling data (attributes) and methods (functions) that operate on the data within a single unit (a class). It also involves restricting direct access to some of an object's components, which is a means of preventing unintended interference and misuse of the methods and data.
*   **Example:**
    *   The `CS2_SkinRating` class encapsulates all the UI components (`mainPanel`, `sidebarPanel`, `cardPanel`, buttons, labels, etc.) and the logic for their setup and layout within its constructor.
    *   While many components are created and manipulated within the constructor in this example, in a more complex application, attributes (like the `JPanel`s) would typically be declared as instance variables (often `private`) and accessed or modified through the class's methods, further strengthening encapsulation.

### 4. Abstraction

*   **Concept:** Hiding complex implementation details and showing only the essential features of an object. It helps in managing complexity by providing a simplified view.
*   **Example:**
    *   When you use `JButton button = new JButton("Click Me");`, you are interacting with an abstraction. You don't need to know how the button is drawn on the screen, how it handles mouse clicks at a low level, or how its text is rendered. You just use its methods like `setBackground()`, `setForeground()`, `addActionListener()`.
    *   The `JFrame` class itself abstracts the underlying windowing system of the operating system.
    *   The `CS2_SkinRating` class, as a whole, provides an abstraction for a "skin rating application window."

### 5. Polymorphism (Many Forms)

*   **Concept:** The ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
*   **Examples:**
    *   **Method Overriding:** While not explicitly overriding methods from `JFrame` in the provided constructor snippet (other than implicitly through its lifecycle), if `CS2_SkinRating` were to override a method like `paintComponent` (more common for `JPanel`), that would be polymorphism.
    *   The `run()` method in the anonymous `Runnable` class:
        ```java
        SwingUtilities.invokeLater(new Runnable() {
            @Override // This annotation indicates overriding
            public void run() {
                new CS2_SkinRating().setVisible(true);
            }
        });
        ```
        The `run()` method is defined in the `Runnable` interface, and the anonymous class provides a specific implementation for it.
    *   **Component Addition:** Methods like `mainPanel.add(component, constraint)` can accept any object that *is a* `Component` (e.g., `JPanel`, `JLabel`, `JButton`). The `add` method behaves polymorphically based on the actual type of component being added.

### 6. Composition (HAS-A Relationship)

*   **Concept:** Building complex objects by combining simpler objects. One object "has an" instance of another object.
*   **Example:**
    *   The `CS2_SkinRating` (which is a `JFrame`) *has a* `JPanel` (e.g., `mainPanel`).
    *   The `mainPanel` *has* other `JPanel`s (e.g., `topBarPanel`, `sidebarPanel`, `cardPanel`).
    *   The `topBarPanel` *has a* `JLabel` (`titleLabel`) and another `JPanel` (`topRightButtonsPanel`).
    *   This "has-a" relationship is fundamental to how Swing UIs are constructed: frames contain panels, and panels contain other components like buttons and labels.
    *   `mainPanel.add(topBarPanel, BorderLayout.NORTH);` explicitly shows `mainPanel` composing `topBarPanel`.

This application effectively uses these OOP principles to create a modular, maintainable, and extensible GUI structure.