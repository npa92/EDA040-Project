#Server
{


###AxisApi
{
Allows communication with the camera's functions, such as pulling for images and checking what time said image was taken.
}

###FrameGrabberThread
{
Continuously pulls images from AxisAPI and puts them into CameraControl for storage and processing. 
This class also checks if the system should go into movie-mode. If so, it will go into CameraControl and prepare a message to be sent to the client, which will propagate from there to all servers. 
}

###CameraControll (Monitor)
{
Receives images from FrameGrabberThread, stores them and allows OutputThread to pull for them.
Also allows Movie-mode messages to be sent.
Keeps record of how often OutputThread should pull images, based on if Movie-mode is on or off.
}

###OutputThread
{
Continuously tries to pull images from CameraControl and sends them to the client.
If CameraControl says that a movie-mode message should be sent to the client, that will be sent rather than the picture that would otherwise be sent.
}

###InputThread
{
Actively listens for the clients “SignalingThread”. Upon receiving a message, the class/thread goes into the monitor “CameraControl” and changes the status of “movie-mode” on or off. 
}
}

#Client
{

###ReaderThread
{
Actively listens for the assigned servers OutputThread. Upon receiving a message, the class/thread goes into the monitor Model and makes the action specified in the message
If message is a movie-mode message, goes into Model and changes the Status of movie-mode
If message is an image, it is made into a ViewingInstance and packed into Model for later showing in the GUI. 
}

###SignalingThread
{
Allows communication to all the servers.
Contains references to all the servers and sends messages to all of them. Thus allowing movie.mode to be turned on or off.
Continuously tries to pull the status of movie-mode from model, if it has changed, a broadcast is made to all servers.
}

###Model (Monitor)
{
Allows storage of viewingInstances, which are created by ReaderThread from The images sent by the different servers.
Allows ReaderThread to change the status of movie-mode, which will allow SignalingThread to propagate the message to all servers.
Allows ImageProcessingThread to pull for the image that is to be shown next in the GUI.
Changes the Image output technique between synchronised and not synchronised.
}

###ViewingInstance
{
Is used to store and sort images.
Contains an image, it´s timestamp and what server it is from.
}

###ImageProcessingThread
{
Continuously pulls ViewingInstances from Model and puts them into GUIController for viewing. 
}

###GUIController
{
Listens for commands from the user and sends them to Model.
Allows ImageProsessingThread to update the views for its camera viewing windows
}
}
