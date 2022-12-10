import socket

def run():
    s = socket.socket()
    port = 5000
    s.bind(('', port))

    # put the socket into listening mode
    s.listen(5)
    print ("socket is listening")

    while True:
        c, addr = s.accept()
        print('Got connection from', addr)
        data = c.recv(1024).decode()
        if not data:
            continue
        else:
            msg = str(data)[0]
            print("from connected user: " + msg)
            if msg == "0":
                stop()
            elif msg == "1":
                forward()
            elif msg == "2":
                left()
            elif msg == "3":
                right()
            elif msg == "4":
                backward()
            else:
                print(msg)
                print("Unknown message")
            c.send('1'.encode())
        c.close()


def left():
    print("Turning left")


def right():
    print("Turning right")


def forward():
    print("Moving forward")


def backward():
    print("Moving backward")


def stop():
    print("stop")


if __name__ == "__main__":
    run()