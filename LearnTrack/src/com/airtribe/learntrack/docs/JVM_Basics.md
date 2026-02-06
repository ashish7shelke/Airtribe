1) What is JDK, JRE, JVM?
    *JDK (Java Development Kit)*
        The JDK is used to develop Java applications.
        It includes:
            JRE
        Development tools such as:
            javac (Java compiler)
            java (program runner)
            Debugging and documentation tools
        JDK = JRE + Development Tools

    *JRE (Java Runtime Environment)*
        The JRE is the environment required to run Java applications.
        It includes:
            The JVM
            Core Java libraries (like java.lang, java.util)
            Supporting files needed at runtime

    *JVM (Java Virtual Machine)*
        The JVM is a virtual machine that runs Java programs.
        It does not understand Java source code directly. Instead, it executes bytecode.
        The JVM is responsible for:
            Running Java programs
            Managing memory
            Handling garbage collection
            Making Java platform independent
        Each operating system (Windows, Linux, macOS) has its own JVM implementation.



2) What is bytecode?
    When a Java program is compiled using the javac compiler, it is not converted directly into machine code.
    Instead, it is converted into an intermediate format called bytecode.
        Bytecode is stored in .class files
        Bytecode is platform independent
        The JVM converts bytecode into machine-specific instructions at runtime.
    This intermediate step is what allows Java programs to run on different systems.


3) What does “write once, run anywhere” mean?
    Java program needs to be written and compiled only once, and it can run on any system that has a compatible JVM.

    After compilation, the same .class (bytecode) file can be executed on Windows, Linux, or macOS without changing the code. The JVM on each platform takes care of converting bytecode into native machine instructions.

    This makes Java platform independent, unlike languages that compile directly to machine code and require separate builds for different operating systems.