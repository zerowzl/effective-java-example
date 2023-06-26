## try-with-resources 优先于 try-finally

`try-with-resources` 是 Java 7 引入的一个新的语言特性，它允许自动管理资源，以便在使用完毕后将其关闭。`try-with-resources` 语句确保了任何实现了 `java.lang.AutoCloseable` 或 `java.io.Closeable` 的资源将会被自动关闭，无论是否抛出异常。

这个特性带来的好处是，你不再需要在 `finally` 块中显式关闭资源，这可以减少代码量，同时避免了因忘记关闭资源或者在关闭资源时抛出异常的风险。

假设你有一个需要读取文件的场景，使用 `try-finally` 的代码可能如下：

```java
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("file.txt"));
    // ... 使用 br 进行读取操作
} catch(IOException e) {
    // ... 处理异常
} finally {
    if (br != null) {
        try {
            br.close();
        } catch(IOException e) {
            // ... 处理异常
        }
    }
}
```

在这个例子中，你需要在 `finally` 块中显式关闭 `BufferedReader`，并处理可能在关闭时抛出的异常。

现在，使用 `try-with-resources`，你可以这样写：

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // ... 使用 br 进行读取操作
} catch(IOException e) {
    // ... 处理异常
}
```

在这个例子中，`BufferedReader` 将在 try 块结束时被自动关闭，无论是否抛出异常。你不再需要显式关闭它，也不需要处理可能在关闭时抛出的异常。

总的来说，使用 `try-with-resources` 可以简化代码，提高可读性，同时减少错误的可能性，因此，建议优先使用 `try-with-resources` 而不是 `try-finally`。