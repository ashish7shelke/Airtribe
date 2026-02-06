
1)  Download tar files from web resource.

    https://www.java.com/en/download/help/linux_x64_install.html
    jre-8u471-linux-x64.tar.gz 

2)  Change to the directory in which you want to install. Type:
cd directory_path_name
For example, to install the software in the /usr/java/ directory, Type:
cd /usr/java/

3)  Move the .tar.gz archive binary to the current directory.
Unpack the tarball and install Java
    tar zxvf jre-8u73-linux-x64.tar.gz

4)  The Java files are installed in a directory called jre1.8.0_73 in the current directory. In this example, it is installed in the /usr/java/jre1.8.0_73 directory. When the installation has completed, you will see the word Done.

5)  java --version
    javac --version

$ java --version
java 25.0.1 2025-10-21 LTS
Java(TM) SE Runtime Environment (build 25.0.1+8-LTS-27)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.1+8-LTS-27, mixed mode, sharing)

$ javac --version
javac 25.0.1
