# EDA040-Project User guide
The system contains two separate programs, one client and one server. The server is to be installed on the AXIS cameras that are used, and will send captured images over a network connection. The client will connect to one or more servers and show their images in different windows.

##Server manual

###RealServer
The server is installed on the cameras according to the guide on the EDA040 homepage. When installed, the command ./Main PORTNUMBER should be run. The PORTNUMBER is the port number that the server is running on. If this number is incorrect, the server will terminate. When a server is up and running, it requires no further human interaction. 

If a camera detects motion, it will tell all other cameras that is connected to a client, that they should enter what is called movie mode. Movie mode tells cameras that they should send images as fast as possible, unlike the idle (normal) mode, where images are sent every 5 seconds.

###ProxyServer
To run the proxycamera navigate to the folder containing EDA040ProxyServer.jar via the terminal using cd. Write java -jar EDA040ProxyServer.jar -serverportnumber -arguscameranbr -argusportnbr. 


##Client manual 
To start the client, run the program. In the window that is opened, write the port number of the server that you wish to connect to. Push the Connect button, and a new window will be opened. To disconnect and close a connection, write the port number that you wish to disconnect from and the window will close. 

When a camera detects movement, all the cameras that are connected in the client will switch to movie mode. It is possible to force either movie or idle mode from the GUI in the client. However, if you are forcing the cameras into idle mode, they will automatically switch to movie if they continue to detect motion. 

It is also possible to change synchronous modes. The synchronous mode will display the images from the cameras in a synchronized manner. If the network delay is too large, the system enters asynchronous mode, meaning that images are not display in temporal order but as fast as they are received. The switching of synchronous mode is not recommended, and should be left to AUTO. 

To exit the client program, close the window.



