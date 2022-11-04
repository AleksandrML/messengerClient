messengerClient project

To use a client properly you have to set port number and ip to settings.txt (as it is shown in settings.txt file).
Then, the server will accept socket connections of any clients which start communication with message in form as:
"name:AnyClientName". Then client will be allowed to be connected to mutual chat of several clients and will be able
to send any messages he wishes. Server will be sending to all clients all messages it got back (from any client 
messages will go back to the same client and to any other connected clients).
To leave chat the client should send a message "/exit".

When client starts the user has to input his name, after that he can begin messaging in mutual chat.
