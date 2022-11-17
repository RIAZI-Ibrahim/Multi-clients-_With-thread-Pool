

import socket

if __name__ == '__main__':
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(('localhost', 1234))
    message = input()
    message = str.encode(message)
    s.send(message, 1234)

    s.close()
