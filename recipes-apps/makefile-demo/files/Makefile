TARGET = hello_makefile

# 使用 Yocto 提供的 CC 和 CFLAGS，自动设置交叉编译器和编译标志
$(TARGET): hello_makefile.o
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(TARGET) hello_makefile.o

hello_makefile.o: hello_makefile.c
	$(CC) $(CFLAGS) -c hello_makefile.c

clean:
	rm -f *.o $(TARGET)